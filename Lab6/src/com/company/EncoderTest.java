package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {

    private static Encoder encoder;
    private static StringWriter sw;
    private static char cipherChar;

    @BeforeAll
    public static void setUp(){
        sw = new StringWriter();
        cipherChar = 'A';
        encoder = new Encoder(sw, cipherChar);
    }


    @Test
    public void TestEncodeDecodeIsCorrect() throws IOException {
        String message = "Hello world!";
        encoder.write(message);
        String str = encoder.toString();
        StringReader sr = new StringReader(sw.toString());
        Decoder decoder = new Decoder(sr, cipherChar);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < message.length(); i++){
            result.append((char) decoder.read());
        }
        assertEquals(message, result.toString());
    }
    @Test
    public void TestWrongCipherChar() throws IOException {
        String message = "Hello world!";
        char wrongCipherChar = 'B';
        encoder.write(message);
        String str = encoder.toString();
        StringReader sr = new StringReader(sw.toString());
        Decoder decoder = new Decoder(sr, wrongCipherChar);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < message.length(); i++){
            result.append((char) decoder.read());
        }
        assertNotEquals(message, result.toString());
    }
}