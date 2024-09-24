package org.peekmoon.webp;

public record Features(int width, int height, boolean hasAlpha, boolean hasAnimation, LossMode lossMode) {
    public enum LossMode {
        MIXED, LOSSY, LOSSLESS
    }
}
