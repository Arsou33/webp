package org.peekmoon.webp.library;

import org.scijava.nativelib.NativeLoader;

public class InitBinding {

    public static void init() {
        {
            try {
                NativeLoader.loadLibrary("webp");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

}
