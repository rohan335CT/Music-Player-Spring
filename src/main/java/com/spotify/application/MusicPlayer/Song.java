package com.spotify.application.MusicPlayer;

public class Song {
    String name;
    String artistName;
    int playCount;

    public Song(String name, String artistName){
        this.name = name;
        this.artistName = artistName;
        this.playCount = 0;
    }

    public void incrementCount(){
        this.playCount++;
    }

}
