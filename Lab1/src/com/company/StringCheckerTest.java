package com.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@RunWith(Parameterized.class)
public class StringCheckerTest {
    private String input;
    private String[] expected;

    public StringCheckerTest(String input, String[] expected){
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection inputData() {
        return Arrays.asList(new Object[][] {
                {"java Core киррилица word", new String[] {"java", "Core"}},
                {"gg dd", new String[] {}},
                {"Lorem ipsum dolor sit amet", new String[] {"amet"}},
                {"тест слово бегемот lala", new String[] {"lala"}},
        });
    }

    @Test
    public void getSameVowelsConstantsWord() {
        StringChecker s = new StringChecker();
        String[] res = s.getSameVowelsConstantsWord(input);
        assertArrayEquals(expected, res);
    }
}