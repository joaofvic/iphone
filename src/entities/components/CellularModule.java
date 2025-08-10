package entities.components;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import services.TelephoneDevice;
import services.VoiceMailMessage;

public class CellularModule implements TelephoneDevice {

	private boolean activeCall;
	private List<VoiceMailMessage> messageInbox;

	public CellularModule() {
		this.messageInbox = new ArrayList<>();
	}

	@Override
	public boolean call(String number) {
		System.out.println("Calling to: " + number);
		return true;
	}

	@Override
	public boolean answer() {
		if (!this.activeCall) {
			System.out.println("Answered call.");
			this.activeCall = true;
			return true;
		}
		System.out.println("Unable to answer, already on a call or no incoming call.");
		return false;
	}

	@Override
	public List<VoiceMailMessage> startVoicelMail() {
		System.out.println("Accessing voicemail...");

		if (messageInbox.isEmpty()) {
			System.out.println("No new voice messages.");
		} else {
			System.out.println(messageInbox.size() + " message(s) found.");
			for (VoiceMailMessage msg : messageInbox) {
				System.out.println("  -> " + msg);
			}
		}
		return this.messageInbox;
	}

	public void leaveVoiceMail(String fromNumber, Duration duration) {
		VoiceMailMessage newMessage = new VoiceMailMessage(fromNumber, LocalDateTime.now(), duration);
		this.messageInbox.add(newMessage);
		System.out.println("-> New voice message from " + fromNumber + " received.");
	}
}