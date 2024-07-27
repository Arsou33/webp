package org.peekmoon.webp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WebPDecodeTest {

    @Test
    public void getVersionReturnVersion() throws Throwable {
        WebPDecode webPDecode = new WebPDecode();
        var version = webPDecode.getDecoderVersion();
        assertThat(version).isEqualTo(new Version(1, 4, 0));
    }

    @Test
    public void getSizeReturnSize() throws IOException {

        int expectedWidth = 550;
        int expectedHeight = 368;

        Path webpPath = Path.of("src/test/resources/1.webp");
        byte[] webp = Files.readAllBytes(webpPath);

        WebPDecode webPDecode = new WebPDecode();
        var size = webPDecode.getSize(webp);

        assertThat(size.width()).isEqualTo(expectedWidth);
        assertThat(size.height()).isEqualTo(expectedHeight);
    }

    @Test
    public void getSizeWhenDataCorruptedThrowException() {

        byte[] webp = new byte[500];

        WebPDecode webPDecode = new WebPDecode();
        assertThatThrownBy(() -> webPDecode.getSize(webp))
                .isInstanceOf(WebPDecodeException.class);
    }
}
