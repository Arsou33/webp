package org.peekmoon.webp;

import org.peekmoon.webp.binding.LibWebPDecode;
import org.peekmoon.webp.binding.WebPBitstreamFeatures;
import org.peekmoon.webp.library.InitBinding;

import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;

public class WebPDecode {

    /** Build a new WebP decoder */
    public WebPDecode() {
        // Load the native library
        InitBinding.init();
    }

    /**
     * Get the version of the WebP decoder
     *
     * @return the version of the decoder
     */
    public Version getDecoderVersion() {
        return new Version(LibWebPDecode.WebPGetDecoderVersion());
    }

    /**
     * Extract size of a WebP image
     *
     * @param data buffer containing the WebP image
     * @return the size of the image in pixels
     */
    public Size getSize(byte[] data) {

        try (Arena arena = Arena.ofConfined()) {

            var webpBuffer = arena.allocateFrom(LibWebPDecode.C_CHAR, data);
            var widthAddr = arena.allocate(ValueLayout.JAVA_INT);
            var heightAddr = arena.allocate(ValueLayout.JAVA_INT);

            var result = LibWebPDecode.WebPGetInfo(webpBuffer, webpBuffer.byteSize(), widthAddr, heightAddr);
            if (result == 0) {
                throw new WebPDecodeException();
            }

            int width = widthAddr.get(ValueLayout.JAVA_INT, 0);
            int height = heightAddr.get(ValueLayout.JAVA_INT, 0);
            return new Size(width, height);
        }

    }

    public Features getFeatures(byte[] data) {

        try (Arena arena = Arena.ofConfined()) {
            var webpBuffer = arena.allocateFrom(LibWebPDecode.C_CHAR, data);
            // Use internal version as non-internal is static and not exposed by the binding
            // Non-internal only calls internal version with WEBP_DECODER_ABI_VERSION as last argument
            var features = WebPBitstreamFeatures.allocate(arena);
            var result = LibWebPDecode.WebPGetFeaturesInternal(webpBuffer, webpBuffer.byteSize(), features, LibWebPDecode.WEBP_DECODER_ABI_VERSION());
            if (result != LibWebPDecode.VP8_STATUS_OK()) {
                throw new WebPDecodeException(result);
            }
            int lossModeInt = WebPBitstreamFeatures.format(features);
            var lossMode = switch (lossModeInt) {
                case 0 -> Features.LossMode.MIXED;
                case 1 -> Features.LossMode.LOSSY;
                case 2 -> Features.LossMode.LOSSLESS;
                default -> throw new IllegalStateException("Unexpected value: " + lossModeInt);
            };

            return new Features(
                    WebPBitstreamFeatures.width(features),
                    WebPBitstreamFeatures.height(features),
                    WebPBitstreamFeatures.has_alpha(features) != 0,
                    WebPBitstreamFeatures.has_animation(features) != 0,
                    lossMode);
        }
    }

    /**
     * Decode a WebP image
     *
     * @param data buffer containing the WebP image
     * @return the decoded image
     */
    public DecodedImage decode(byte[] data) {

        try (Arena arena = Arena.ofConfined()) {
            var webpBuffer = arena.allocateFrom(LibWebPDecode.C_CHAR, data);
            var widthAddr = arena.allocate(ValueLayout.JAVA_INT);
            var heightAddr = arena.allocate(ValueLayout.JAVA_INT);
            var imgBufferAddr = LibWebPDecode.WebPDecodeRGBA(webpBuffer, webpBuffer.byteSize(), widthAddr, heightAddr);
            if (imgBufferAddr == null) {
                throw new WebPDecodeException();
            }
            int width = widthAddr.get(ValueLayout.JAVA_INT, 0);
            int height = heightAddr.get(ValueLayout.JAVA_INT, 0);

            byte[] imgBuffer = imgBufferAddr.asSlice(0, (long) width*height*4).toArray(LibWebPDecode.C_CHAR);

            LibWebPDecode.WebPFree(imgBufferAddr);

            return new DecodedImage(imgBuffer, width, height);
        }

    }


}
