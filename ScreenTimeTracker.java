import java.util.Scanner;

public class ScreenTimeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int socialMediaTime = 0;
        int gamingTime = 0;
        int studyingTime = 0;
        int streamingTime = 0;
        int totalScreenTime = 0;
        int sessions = 0;

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("===== SCREEN-TIME TRACKER =====");
            System.out.println("1. Add social media time");
            System.out.println("2. Add gaming time");
            System.out.println("3. Add studying time");
            System.out.println("4. Add video or streaming time");
            System.out.println("5. View statistics");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Choose a number from 1 to 6.");
                continue;
            }

            if (choice < 1 || choice > 6) {
                System.out.println("Invalid option. Choose a number from 1 to 6.");
                continue;
            }

            if (choice >= 1 && choice <= 4) {
                String categoryName;
                switch (choice) {
                    case 1:
                        categoryName = "social media";
                        break;
                    case 2:
                        categoryName = "gaming";
                        break;
                    case 3:
                        categoryName = "studying";
                        break;
                    default:
                        categoryName = "video or streaming";
                }

                System.out.print("Enter " + categoryName + " minutes: ");
                int minutes;
                try {
                    minutes = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                    continue;
                }

                if (minutes <= 0) {
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        socialMediaTime += minutes;
                        break;
                    case 2:
                        gamingTime += minutes;
                        break;
                    case 3:
                        studyingTime += minutes;
                        break;
                    default:
                        streamingTime += minutes;
                }
                totalScreenTime += minutes;
                sessions++;
                System.out.println("Time added successfully!");
            } else if (choice == 5) {
                System.out.println();
                System.out.println("===== TODAY'S SCREEN TIME =====");
                System.out.println("Social media: " + socialMediaTime + " minutes");
                System.out.println("Gaming: " + gamingTime + " minutes");
                System.out.println("Studying: " + studyingTime + " minutes");
                System.out.println("Streaming: " + streamingTime + " minutes");
                System.out.println();
                System.out.println("Total screen time: " + totalScreenTime + " minutes");
                System.out.println("Recorded sessions: " + sessions);
                System.out.println();

                int entertainmentTime = socialMediaTime + gamingTime + streamingTime;

                if (studyingTime > entertainmentTime) {
                    System.out.println("Study screen time is greater than entertainment screen time. Good balance!");
                } else if (entertainmentTime > studyingTime) {
                    System.out.println("Entertainment screen time is greater than study time.");
                } else {
                    System.out.println("Study and entertainment screen time are equal.");
                }

                if (totalScreenTime < 120) {
                    System.out.println("Low screen time");
                } else if (totalScreenTime <= 240) {
                    System.out.println("Moderate screen time");
                } else {
                    System.out.println("High screen time");
                }
            } else {
                System.out.println("Screen-time tracker closed.");
                running = false;
            }
        }

        scanner.close();
    }
}