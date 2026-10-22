import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double assignmentPoints = 0;
        int assignmentCount = 0;
        double examPoints = 0;
        int examCount = 0;

        boolean running = true;

        while (running) {
            System.out.print("\n===== SEMESTER GRADE TRACKER =====");
            System.out.print("\n1. Add assignment result");
            System.out.print("\n2. Add exam result");
            System.out.print("\n3. View current grade");
            System.out.print("\n4. Exit");
            System.out.print("\nChoose an option: ");

            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("\nInvalid option. Choose a number from 1 to 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("\nEnter assignment score: ");
                    double assignmentScore = readScore(scanner.nextLine());
                    if (assignmentScore < 0) {
                        System.out.print("\nInvalid score. Enter a value from 0 to 100.");
                    } else {
                        assignmentPoints += assignmentScore;
                        assignmentCount++;
                        System.out.print("\nAssignment score added.");
                    }
                    break;

                case 2:
                    System.out.print("\nEnter exam score: ");
                    double examScore = readScore(scanner.nextLine());
                    if (examScore < 0) {
                        System.out.print("\nInvalid score. Enter a value from 0 to 100.");
                    } else {
                        examPoints += examScore;
                        examCount++;
                        System.out.print("\nExam score added.");
                    }
                    break;

                case 3:
                    if (assignmentCount == 0 && examCount == 0) {
                        System.out.print("\nNo results available yet.");
                        break;
                    }

                    double assignmentAverage = 0;
                    double examAverage = 0;
                    double overallAverage;

                    if (assignmentCount > 0) {
                        assignmentAverage = assignmentPoints / assignmentCount;
                    }
                    if (examCount > 0) {
                        examAverage = examPoints / examCount;
                    }

                    String note = null;
                    if (assignmentCount > 0 && examCount > 0) {
                        overallAverage = assignmentAverage * 0.50 + examAverage * 0.50;
                    } else if (assignmentCount > 0) {
                        overallAverage = assignmentAverage;
                        note = "Note: No exams entered yet. The overall average is based on assignments only.";
                    } else {
                        overallAverage = examAverage;
                        note = "Note: No assignments entered yet. The overall average is based on exams only.";
                    }

                    System.out.print("\n\n===== CURRENT RESULTS =====");
                    System.out.print("\nAssignments completed: " + assignmentCount);
                    if (assignmentCount > 0) {
                        System.out.printf("\nAssignment average: %.1f%n", assignmentAverage);
                    } else {
                        System.out.print("\nAssignment average: no data");
                    }
                    System.out.print("\nExams completed: " + examCount);
                    if (examCount > 0) {
                        System.out.printf("\nExam average: %.1f%n", examAverage);
                    } else {
                        System.out.print("\nExam average: no data");
                    }
                    System.out.printf("\nOverall average: %.1f%n", overallAverage);
                    System.out.print("\nGrade: " + getGrade(overallAverage));
                    System.out.print("\nStatus: " + (overallAverage >= 60 ? "Passing" : "Not passing"));
                    if (note != null) {
                        System.out.println(note);
                    }
                    break;

                case 4:
                    System.out.print("\nGrade tracker closed.");
                    running = false;
                    break;

                default:
                    System.out.print("\nInvalid option. Choose a number from 1 to 4.");
            }
        }

        scanner.close();
    }

    private static double readScore(String input) {
        try {
            double score = Double.parseDouble(input.trim().replace(',', '.'));
            if (Double.isNaN(score) || score < 0 || score > 100) {
                return -1;
            }
            return score;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String getGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}