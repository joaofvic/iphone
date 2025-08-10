package entities.components;

import services.MusicPlayer;

public class DefaultMusicPlayer implements MusicPlayer {

	private String currentMusic;

	@Override
	public void play() {
		if (currentMusic != null) {
			System.out.println("Playing music: " + currentMusic);
		} else {
			System.out.println("No songs selected.");
		}
	}

	@Override
	public void pause() {
		System.out.println("Music paused.");
	}

	@Override
	public boolean selectMusic(String music) {
		this.currentMusic = music;
		System.out.println("Music selected: " + music);
		return true;
	}
}
