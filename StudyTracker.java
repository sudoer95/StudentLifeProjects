import java.util.Scanner;

public class StudyTracker{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int weeklygoal = 600;
        int command = 0;
        int subcommand = 0;
        int temp = 0;
        int programming = 0, mathematics = 0, english = 0, other = 0, total = 0, sessions = 0;

        while (command != -5){
            temp = 0;
            System.out.print("\n===== STUDY TRACKER =====\n1. Add study session\n2. View statistics\n3. Check weekly goal\n4. Exit\n\nChoose an option:");
            command = scan.nextInt();

            switch (command){
                case 1:
                    System.out.print("\nChoose subject:\n1. Programming\n2. Mathematics\n3. English\n4. Other\n\nChoose an option:");
                    subcommand = scan.nextInt();
                    if (subcommand <= 0 || subcommand > 4){System.out.print("\nInvalid option."); break;}
                    System.out.print("\nStudy time in minutes: ");
                    temp = scan.nextInt();
                    if (temp <= 0){System.out.print("\nEnter valid study time(must be more than 0)"); break;}
                    total += temp;
                    System.out.print("\nStudy session added!\nCurrent total study time: " + total + " minutes.");
                    sessions++;
                    switch (subcommand){
                        case 1:
                            programming += temp;
                            break;
                        case 2:
                            mathematics += temp;
                            break;
                        case 3:
                            english += temp;
                            break;
                        case 4:
                            other += temp;
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.print("\n===== WEEKLY STATISTICS =====\n\nStudy sessions: " + sessions + "\nTotal study time: " + total + "minutes\n\nProgramming: " + programming + " minutes\nMathematics: " + mathematics + " minutes\nEnglish: " + english + " minutes\nOther: " + other +" minutes\n");
                    break;
                case 3:
                    if(weeklygoal > total){
                        System.out.print("\nWeekly goal: " + weeklygoal + " minutes.");
                        System.out.print("\nYou studied: " + total + "minutes.");
                        System.out.print("\nRemaining: " + (weeklygoal - total) + "minutes.");
                    }
                    else {
                        System.out.print("\nYa completed weekly goal.");
                    }
                    break;
                case 4:
                    command = -5;
                    System.out.print("\nStudy tracker closed. Keep up the good work!");
                    return;
            }
        }

    }
}