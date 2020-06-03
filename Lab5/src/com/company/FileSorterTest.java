package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSorterTest {

    @org.junit.jupiter.api.Test
    void sortIsCorrect() throws IOException {
        File tempFile = File.createTempFile("testing", ".txt");
        tempFile.deleteOnExit();
        List<String > expectedOrder = new ArrayList<>();

        expectedOrder.add("This must be first line");
        expectedOrder.add("This must be second line lorem ipsum");
        expectedOrder.add("This must be third line gg ddawtatassklaj");
        expectedOrder.add("This must be fourth line kkaopwujahrarja;j wsrja;rf sksoo");


        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write("This must be third line gg ddawtatassklaj");
        writer.newLine();
        writer.write("This must be fourth line kkaopwujahrarja;j wsrja;rf sksoo");
        writer.newLine();
        writer.write("This must be second line lorem ipsum");
        writer.newLine();
        writer.write("This must be first line");
        writer.newLine();
        writer.close();


        FileSorter fs = new FileSorter(tempFile);
        File f = fs.sort();
        f.deleteOnExit();
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line;
        for(int i = 0; (line=reader.readLine())!=null; i++){
            assertEquals(line, expectedOrder.get(i));
        }
        reader.close();
    }

}