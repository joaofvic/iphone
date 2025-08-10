package services;

import java.util.List;

public interface TelephoneDevice {

	boolean call(String number);
	boolean answer();
	List<VoiceMailMessage> startVoicelMail();
}
