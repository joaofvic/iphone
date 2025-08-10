package application;

import entities.Iphone;
import services.VoiceMailMessage;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Iphone myIphone = new Iphone();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;


        while (isRunning) {
            System.out.println("\n===== IPHONE MENU =====");
            System.out.println("1: Play a Song");
            System.out.println("2: Make a Call");
            System.out.println("3: Browse the Internet");
            System.out.println("4: Check Voicemail");
            System.out.println("5: Simulate Receiving a Voicemail");
            System.out.println("0: Turn off iPhone");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the song name to play: ");
                    String song = scanner.nextLine();
                    myIphone.playSong(song);
                    System.out.println("\n(Press Enter to pause the song)");
                    scanner.nextLine();
                    myIphone.pauseSong();
                    break;
                case 2:
                    System.out.print("Enter the number to call: ");
                    String number = scanner.nextLine();
                    myIphone.makeCall(number);
                    break;
                case 3:
                    System.out.print("Enter the URL to browse: ");
                    String url = scanner.nextLine();
                    myIphone.browsePage(url);
                    myIphone.refreshPage();
                    myIphone.openNewTab();
                    break;
                case 4:
                    List<VoiceMailMessage> messages = myIphone.checkVoicemail();
                    if (messages.isEmpty()){
                         System.out.println("Your voicemail inbox is empty.");
                    }
                    break;
                case 5:
                    System.out.println("An external call was missed. A new voicemail has arrived.");
                    myIphone.simulateLeavingVoicemail("9-8765-4321", Duration.ofSeconds(42));
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Shutting down the iPhone...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("iPhone has been turned off.");
    }
}