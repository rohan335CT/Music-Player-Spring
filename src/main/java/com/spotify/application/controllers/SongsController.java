package com.spotify.application.controllers;

import com.spotify.application.SongInformation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@RestController
public class SongsController {
    private List<SongInformation> songList = new ArrayList<>();

    @PostMapping("/add-songs")
    public  void addSong(@RequestBody SongInformation songInformation) {
        // Add song logic
        songList.add(songInformation);
        System.out.println("Song addition success");
    }

    @GetMapping("/get-songs")
    public String getSong() {
        // Get song logic
        String song = songList.get(0).getSongArtist();
        return "Song 123 .... Retrieval successful" + songList.get(0);
    }

    @GetMapping("/csv-playlist")
    public void getCsv() {
        System.out.println("Reading from CSV file");
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/Users/rohan.k/Documents/ClearPractice/Day8/application/src/main/java/com/spotify/application/MusicPlayer/CsvDemo.csv"));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                System.out.print(sc.next());
                System.out.print("\n");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/add-csv")
    public void addCsv(@RequestBody SongInformation songInformation) {
        System.out.println("Writing to CSV file");

        String[][] data = {
                {songInformation.getSongName(), songInformation.getSongArtist()}
        };

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.println(data[i][j]);
            }

        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("/Users/rohan.k/Documents/ClearPractice/Day8/application/src/main/java/com/spotify/application/MusicPlayer/CsvDemo.csv"));
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {

                    writer.write(data[i][j]);
                    if (j < data[i].length - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }

            System.out.println("Data written successfully to CSV file");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to TSV file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while writing to TSV file: " + e.getMessage());
            }
        }
    }
}
