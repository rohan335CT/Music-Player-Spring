package com.spotify.application;

import lombok.*;

public class SongInformation {
    private String songName;
    private String songArtist;


    public String getSongName() {
        System.out.println(songName);
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        System.out.println(songArtist);
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }
}
