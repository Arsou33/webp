package org.peekmoon.webp.binding;

import org.junit.jupiter.api.Test;
import org.peekmoon.webp.library.InitBinding;

import static org.assertj.core.api.Assertions.assertThat;

public class BindingTest {

    @Test
    public void initDontThrowException() {
        InitBinding.init();
    }

    @Test
    public void getDecoderVersionTest() {
        int version = LibWebPDecode.WebPGetDecoderVersion();
        assertThat(version).isEqualTo(0x010400);
    }

}
