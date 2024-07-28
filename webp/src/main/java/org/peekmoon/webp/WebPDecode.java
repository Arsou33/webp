package org.peekmoon.webp;

import org.peekmoon.webp.binding.LibWebPDecode;
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
