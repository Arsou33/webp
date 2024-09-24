package org.peekmoon.webp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class WebPDecodeFeaturesTest {

    @Test
    public void getFeaturesReturnFeatures_step1() throws IOException {
        int expectedWidth = 550;
        int expectedHeight = 368;

        Path webpPath = Path.of("src/test/resources/1.webp");
        byte[] webp = Files.readAllBytes(webpPath);

        WebPDecode webPDecode = new WebPDecode();
        var features = webPDecode.getFeatures(webp);

        assertThat(features.width()).isEqualTo(expectedWidth);
        assertThat(features.height()).isEqualTo(expectedHeight);
        assertThat(features.hasAlpha()).isFalse();
        assertThat(features.hasAnimation()).isFalse();
        assertThat(features.lossMode()).isEqualTo(Features.LossMode.LOSSY);
    }

    @Test
    public void getFeaturesReturnFeatures_step2() throws IOException {
        int expectedWidth = 400;
        int expectedHeight = 400;

        Path webpPath = Path.of("src/test/resources/2.webp");
        byte[] webp = Files.readAllBytes(webpPath);

        WebPDecode webPDecode = new WebPDecode();
        var features = webPDecode.getFeatures(webp);

        assertThat(features.width()).isEqualTo(expectedWidth);
        assertThat(features.height()).isEqualTo(expectedHeight);
        assertThat(features.hasAlpha()).isTrue();
        assertThat(features.hasAnimation()).isTrue();
        assertThat(features.lossMode()).isEqualTo(Features.LossMode.MIXED);
    }

}
