package org.peekmoon.webp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WebPDecodeVersionTest {

    @Test
    public void getVersionReturnVersion() {
        WebPDecode webPDecode = new WebPDecode();
        var version = webPDecode.getDecoderVersion();
        assertThat(version).isEqualTo(new Version(1, 4, 0));
    }

    @Test
    public void toStringOfVersionReturnVersionString() {
        Version version = new Version(1, 4, 0);
        assertThat(version.toString()).isEqualTo("1.4.0");
    }

}
