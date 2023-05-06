package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataManipulationTool {
    private String src = "/Users/andreeaolariu/Facultate/programare-avansata/Laborator_8/optional/data/albumlist.csv";

    public List<String[]> read() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(src))) {
            List<String[]> res = reader.readAll();
            for(String[] album : res) {
                for(int i = 0; i < album.length; i++) {
                    album[i] = convert(album[i]);
                }
            }
            return res.subList(1, res.size());
        }
    }

    public String convert(String title) {
        Integer len = title.length();
        StringBuilder newTitle = new StringBuilder("");
        char[] chars = new char[len];
        title.getChars(0, len, chars,0);
        for(char ch : chars) {
            if(ch == '\'') {
                newTitle.append('\'');
            }
            newTitle.append(ch);
        }
        title = newTitle.toString();
        return title;
    }

    public String genreName(String genre) {
        Integer len = genre.length();
        StringBuilder newGenre = new StringBuilder("");

        char[] chars = new char[len];
        genre.getChars(0, len, chars,0);
        for(char ch : chars) {
            if(Character.isLetter(ch)) {
                newGenre.append(ch);
            }
        }
        genre = newGenre.toString();
        return genre;
    }

    public void print() throws IOException, CsvException {
        List<String[]> albums = read();
        for(String[] album : albums) {
            for(String info : album) {
                System.out.println(info);
            }
            System.out.println("=======");
        }
    }
}
