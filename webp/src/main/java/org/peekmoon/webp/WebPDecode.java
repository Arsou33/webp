package org.peekmoon.webp;

import org.peekmoon.webp.binding.LibWebPDecode;
import org.peekmoon.webp.library.InitBinding;

import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;

public class WebPDecode {

    public WebPDecode() {
        // Load the native library
        InitBinding.init();
    }

    public Version getDecoderVersion() {
        return new Version(LibWebPDecode.WebPGetDecoderVersion());
    }

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


}
