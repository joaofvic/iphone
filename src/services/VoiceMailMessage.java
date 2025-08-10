package services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VoiceMailMessage {

	private String fromNumber;
	private LocalDateTime timestamp;
	private Duration duration;

	public VoiceMailMessage(String fromNumber, LocalDateTime timestamp, Duration duration) {
		this.fromNumber = fromNumber;
		this.timestamp = timestamp;
		this.duration = duration;
	}

	public String getFromNumber() {
		return fromNumber;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public Duration getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return "Voice Message [From=" + fromNumber + ", In=" + timestamp.format(formatter) + ", Duration="
				+ duration.toSeconds() + "s]";
	}
}
