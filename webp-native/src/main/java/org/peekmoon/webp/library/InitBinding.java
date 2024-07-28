package org.peekmoon.webp.library;

import org.scijava.nativelib.NativeLoader;

import java.io.IOException;

public class InitBinding {

    public static void init() {
        {
            try {
                NativeLoader.loadLibrary("webp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
