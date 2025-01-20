package com.spotify.application;

import com.spotify.application.MusicPlayer.MusicPlayer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		MusicPlayer ms = new MusicPlayer();
		ms.addSong("A", "Rohan");
		ms.addSong("B", "Rohan");
		ms.addSong("C", "Harshit");

		ms.playSong("A", LocalDate.of(2023, 12, 25));
		ms.playSong("B", LocalDate.of(2023, 12, 25));
		ms.playSong("B", LocalDate.of(2023, 12, 25));
		ms.playSong("C", LocalDate.of(2023, 12, 25));

		System.out.println(ms.topSongByDate(LocalDate.of(2023, 12, 25)));
		System.out.println(ms.topSongByArtist("Rohan"));
		System.out.println(ms.topSong());
	}

}
