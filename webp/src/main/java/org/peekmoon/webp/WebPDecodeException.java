package org.peekmoon.webp;

public class WebPDecodeException extends RuntimeException {

    public WebPDecodeException() {
        super();
    }

    public WebPDecodeException(int result) {
        super("Error decoding WebP image: " + result);
    }
}
