package com.spotify.application.MusicPlayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MusicPlayer {

    HashMap<String, Song> songNameList;
    List<Song> songList;
    HashMap<String, Artist> artistList;
    HashMap<LocalDate, DateClass> dateList;

    public MusicPlayer(){
        this.songNameList = new HashMap<>();
        this.artistList = new HashMap<>();
        this.dateList = new HashMap<>();
        this.songList = new ArrayList<>();
    }

    public void addSong(String songName, String artistName){

        //working on song
        Song s = new Song(songName, artistName);
        songNameList.put(songName, s);
        songList.add(s);

        //working on artist
        Artist a;
        if(artistList.get(artistName) == null){
            a = new Artist(artistName);
            a.addSong(songName);
            //a.songList.add(s);
            artistList.put(artistName, a);
        }else {
            a = artistList.get(artistName);
            //a.songList.add(s);
            a.addSong(songName);
            artistList.replace(artistName, a);
        }

    }

    public void playSong(String name, LocalDate date){
        Song s = songNameList.get(name);
        songList.remove(s);
        songList.add(s);
        s.playCount++;
        songNameList.put(name, s);


        if(dateList.containsKey(date)){
            DateClass dc = dateList.get(date);
            dc.addSong(name);
            dateList.replace(date, dc);
        }else{
            DateClass dc = new DateClass(date);
            dc.addSong(name);
            dateList.put(date, dc);
        }

    }

    public String topSongByDate(LocalDate date){
        if(dateList.containsKey(date)){
            DateClass dc = dateList.get(date);
            return dc.topSong();
        }

        return "Not Found";

    }

    public String topSongByArtist(String artistName){
        if(artistList.containsKey(artistName)){
            //DateClass dc = dateList.get(date);
            Artist a = artistList.get(artistName);
            return a.topSong();
        }

        return "Not Found";

    }

    public String topSong(){
        int max = 0;
        String song = "";
        for(Song s: songList){
            if(s.playCount > max){
                max = s.playCount;
                song = s.name;
            }
        }

        return song;
    }



}
