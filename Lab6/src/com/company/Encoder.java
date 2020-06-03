package com.company;

import java.io.*;

public class Encoder extends FilterWriter {

    private final int cipher;
    protected Encoder(Writer out, char cipherChar) {
        super(out);
        this.cipher = (int)cipherChar;
    }

    @Override
    public void write(String str) throws IOException {
        for(int i=0;i < str.length();i++){
            super.write(str.codePointAt(i) + cipher);
        }
    }
}
