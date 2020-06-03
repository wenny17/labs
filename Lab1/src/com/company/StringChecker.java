package com.company;

import java.util.ArrayList;

public class StringChecker {
    // Find words, that contains only latin symbols.
    // Find words with the same count of vowels and consonants

    public static boolean isLatinLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public String[] getSameVowelsConstantsWord(String words){
        ArrayList<String> strList = new ArrayList<>();
        String[] splittedWords = words.split("\\s+|,");
        String vowels = "aeiou";
        int vowelsCount = 0;
        int consonantsCount = 0;
        boolean isLatin = false;
        for (String word : splittedWords) {
            for (int i = 0; i < word.length(); i++){
                isLatin = isLatinLetter(word.charAt(i));
                if (!isLatin) {break;}
                if (vowels.indexOf(word.charAt(i)) != -1) {
                    vowelsCount++;
                }
                else {
                    consonantsCount++;
                }
            }
            if (isLatin && consonantsCount == vowelsCount){
                strList.add(word);
            }
            vowelsCount = 0;
            consonantsCount = 0;
        }
        return strList.toArray(new String[0]);
    }
}
