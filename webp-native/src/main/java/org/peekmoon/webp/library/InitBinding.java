package org.peekmoon.webp.library;

import org.scijava.nativelib.BaseJniExtractor;
import org.scijava.nativelib.NativeLibraryUtil;
import org.scijava.nativelib.NativeLoader;

import java.io.File;
import java.io.IOException;

public class InitBinding {

    public static void init() {
        {

            try {
                if (NativeLibraryUtil.getArchitecture() == NativeLibraryUtil.Architecture.LINUX_64) {
                    System.setProperty("mx.sysinfo", "linux-x86_64");
                    NativeLoader.setJniExtractor(new JniExtractor());
                }
                NativeLoader.extractRegistered();
                NativeLoader.loadLibrary("webp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static class JniExtractor extends BaseJniExtractor {

        private File jniDir;

        public JniExtractor() throws IOException {
            super(null);
            var libraryJniDir = System.getProperty("library.extract.dir");
            if (libraryJniDir == null || libraryJniDir.isEmpty()) {
                throw new RuntimeException("library.extract.dir is not set");
            }
            setJniDir(new File(libraryJniDir));
        }

        @Override
        public File getJniDir() {
            return jniDir;
        }

        @Override
        public File getNativeDir() {
            return jniDir;
        }

        private void setJniDir(File jniDir) {

            if (jniDir.exists()) {
                if (!jniDir.isDirectory()) {
                    throw new RuntimeException("Not a directory: " + jniDir);
                }
            } else {
                boolean success = jniDir.mkdirs();
                if (!success) {
                    throw new RuntimeException("Cannot create directory: " + jniDir);
                }
            }
            this.jniDir = jniDir;
        }


    }

}
