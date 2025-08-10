package entities;

import services.InternetBrowser;
import services.MusicPlayer;
import services.Tab;
import services.TelephoneDevice;
import services.VoiceMailMessage;

import entities.components.CellularModule;
import entities.components.DefaultMusicPlayer;
import entities.components.SafariBrowser;

import java.time.Duration;
import java.util.List;

public class Iphone {

	private MusicPlayer musicPlayer;
	private TelephoneDevice telephoneDevice;
	private InternetBrowser internetBrowser;

	public Iphone() {
		this.musicPlayer = new DefaultMusicPlayer();
		this.telephoneDevice = new CellularModule();
		this.internetBrowser = new SafariBrowser();
		System.out.println("iPhone is ready.");
	}

	public void playSong(String song) {
		System.out.println("iPhone: Selecting and playing song...");
		if (this.musicPlayer.selectMusic(song)) {
			this.musicPlayer.play();
		}
	}

	public void pauseSong() {
		System.out.println("iPhone: Pausing song...");
		this.musicPlayer.pause();
	}

	public void makeCall(String number) {
		System.out.println("iPhone: Making a call...");
		this.telephoneDevice.call(number);
	}

	public void answerCall() {
		System.out.println("iPhone: Answering a call...");
		this.telephoneDevice.answer();
	}

	public List<VoiceMailMessage> checkVoicemail() {
		System.out.println("iPhone: Checking voicemail...");
		return this.telephoneDevice.startVoicelMail();
	}

	public void simulateLeavingVoicemail(String fromNumber, Duration duration) {
		if (this.telephoneDevice instanceof CellularModule) {
			((CellularModule) this.telephoneDevice).leaveVoiceMail(fromNumber, duration);
		} else {
			System.err.println("This phone's telephone component does not support leaving voicemails directly.");
		}
	}

	public void browsePage(String url) {
		System.out.println("iPhone: Browse to a webpage...");
		this.internetBrowser.showPage(url);
	}

	public void openNewTab() {
		System.out.println("iPhone: Opening a new browser tab...");
		Tab newTab = this.internetBrowser.addNew();
		System.out.println("A new tab was successfully opened: " + newTab.getTitle());
	}

	public void refreshPage() {
		System.out.println("iPhone: Refreshing webpage...");
		this.internetBrowser.updatePage();
	}
}