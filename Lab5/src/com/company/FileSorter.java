package com.company;

import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;

public class FileSorter {
    private File file;
    public FileSorter(File file) {
        this.file = file;
    }
    public FileSorter(String path, String fileName){
        file = new File(path, fileName);
    }

    class Line implements Comparable<Line>{
        private final String line;

        public Line(String line) {
            this.line = line;
        }

        public int getLineLength() {
            return line.length();
        }

        public String getLine() {
            return line;
        }

        public int compareTo(Line line){
            return getLineLength() - line.getLineLength();
        }
    }

    private TreeSet<Line> getSortedLines() throws IOException {
        TreeSet<Line> lines = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line=reader.readLine())!=null){

            lines.add(new Line(line));
        }
        reader.close();
        return lines;
    }

    private File writeToNewFile(Iterable<Line> lines) throws IOException {
        File newFile = new File("Sorted_" + file.getName());
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
        for(Line line : lines) {
            writer.write(line.getLine());
            writer.newLine();
        }
        writer.close();
        return newFile;
    }

    public File sort() throws IOException {
        Iterable<Line> lines = getSortedLines();
        return writeToNewFile(lines);
    }
}
