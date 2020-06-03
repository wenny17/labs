package com.company;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class Decoder extends FilterReader {

    private final int cipher;
    protected Decoder(Reader in, char cipherChar) {
        super(in);
        this.cipher = (int) cipherChar;
    }

    @Override
    public int read() throws IOException {
        return super.read() - cipher;
    }
}
