package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringWriter sw = new StringWriter();
        Encoder encoder = new Encoder(sw, 'A');
        encoder.write("Hello world!");
        String str = sw.toString();
        StringReader sr = new StringReader(str);
        Decoder decoder = new Decoder(sr, 'A');
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            result.append((char) decoder.read());
        }
        System.out.println(result);
    }
}
