package org.peekmoon.webp.demo;

import org.peekmoon.webp.WebPDecode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        log.info("Start demo decode!");

        Path webpPath = Path.of(args[0]);
        byte[] webp = Files.readAllBytes(webpPath);

        WebPDecode webPDecode = new WebPDecode();
        var decoded = webPDecode.decode(webp);

        byte[] buffer = decoded.buffer();

        Files.write(Path.of(args[1]), buffer);
    }

}