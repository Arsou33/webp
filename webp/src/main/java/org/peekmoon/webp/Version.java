package org.peekmoon.webp;

public record Version(int major, int minor, int revision) {

    public Version(int version) {
        this((version >> 16) & 0xff, (version >> 8) & 0xff, version & 0xff);
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + revision;
    }
}
