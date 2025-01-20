package com.spotify.application.MusicPlayer;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class DateClass {
    LocalDate d;
    Set<Pair<Integer, String>> topSong;
    HashMap<String, Integer> list;

    public DateClass(LocalDate d){
        this.d = d;
        this.topSong = new TreeSet<>(
                Comparator.comparing(Pair::getKey));
        this.list = new HashMap<>();
    }

    public void addSong(String song) {
        if (list.containsKey(song)) {
            list.replace(song, list.get(song) + 1);
        } else {
            list.put(song, 1);
        }

        Pair<Integer, String> p = new Pair<>(list.get(song) - 1, song);
        topSong.remove(p);
        Pair<Integer, String> p0 = new Pair<>(list.get(song) - 1, song);
        topSong.add(p0);
    }

    public String topSong(){
        Pair<Integer, String> biggestPair = ((TreeSet<Pair<Integer, String>>) topSong).last();
        return biggestPair.getValue();
    }
}
