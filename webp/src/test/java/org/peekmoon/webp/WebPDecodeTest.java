package org.peekmoon.webp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WebPDecodeTest {

    @Test
    public void getVersionReturnVersion() {
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
    public void toStringOfVersionReturnVersionString() {
        Version version = new Version(1, 4, 0);
        assertThat(version.toString()).isEqualTo("1.4.0");
    }

    @Test
    public void getSizeWhenDataCorruptedThrowException() {

        byte[] webp = new byte[500];

        WebPDecode webPDecode = new WebPDecode();
        assertThatThrownBy(() -> webPDecode.getSize(webp))
                .isInstanceOf(WebPDecodeException.class);
    }

    @Test
    public void decodeReturnBuffer() throws IOException {

        int expectedWidth = 550;
        int expectedHeight = 368;

        Path webpPath = Path.of("src/test/resources/1.webp");
        byte[] webp = Files.readAllBytes(webpPath);

        WebPDecode webPDecode = new WebPDecode();
        var decoded = webPDecode.decode(webp);

        byte[] buffer = decoded.buffer();
        assertThat(buffer.length).isEqualTo(expectedWidth * expectedHeight * 4);
        assertThat(decoded.width()).isEqualTo(expectedWidth);
        assertThat(decoded.height()).isEqualTo(expectedHeight);

        // TopLeft pixel is RVB : 118 -75 -15
        assertThat(buffer[0]).isEqualTo((byte) 0x76); // Red
        assertThat(buffer[1]).isEqualTo((byte) 0xB5); // Blue
        assertThat(buffer[2]).isEqualTo((byte) 0xF1); // Green
        assertThat(buffer[3]).isEqualTo((byte) 0xFF); // Alpha
    }
}
