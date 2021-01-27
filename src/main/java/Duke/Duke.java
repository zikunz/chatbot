package Duke;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        /**
         * String logo = " ____        _        \n"
         *         + "|  _ \\ _   _| | _____ \n"
         *         + "| | | | | | | |/ / _ \\\n"
         *         + "| |_| | |_| |   <  __/\n"
         *         + "|____/ \\__,_|_|\\_\\___|\n";
         */

        greet();
        
        Scanner in = new Scanner(System.in);
        String userInput = "";
        boolean isInvalid = true;

        while (isInvalid) {
            userInput = in.nextLine();
            if (!userInput.equals("list")) {
                isInvalid = false;
            } else {
                printSeparationLine();
                System.out.println("You do not have any task to do.");
                printSeparationLine();
            }
        }

        Task[] tasks = new Task[100];
        tasks[0] = new Task(userInput);

        int numberOfTasks = 1;
        int selectedTask;
        boolean listRequested = false;

        while (true) {
            if (userInput.startsWith("done ")) {
                selectedTask = Integer.parseInt(userInput.substring(5)) - 1;
                tasks[selectedTask].setAsDone();
                printSeparationLine();
                System.out.println("     Nice! I've marked this task as done:");
                System.out.println("       [" + tasks[selectedTask].getStatusIcon() + "] " +
                        tasks[selectedTask].getDescription());
                printSeparationLine();
            } else if (userInput.equals("bye")) {
                exit();
                System.exit(0);
            } else if (userInput.equals("list")) {
                printSeparationLine();
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < numberOfTasks; i++) {
                    System.out.println("     " + (i + 1) + "." + "[" + tasks[i].getStatusIcon() + "] " +
                            tasks[i].getDescription());
                }
                printSeparationLine();
                System.out.println();
            } else {
                echo(userInput);
            }
            userInput = in.nextLine();
            if (!(userInput.equals("list") || userInput.startsWith("done "))) {
                tasks[numberOfTasks] = new Task(userInput);
                numberOfTasks++;
            }
        }
    }

    static void greet() {
        String greet = "    ____________________________________________________________\n" +
                "     Hello! I'm Duke\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________\n";
        System.out.println(greet);
    }

    static void printSeparationLine() {
        System.out.println("    ____________________________________________________________");
    }

    static void echo(String userInput) {
        printSeparationLine();
        System.out.println("     added: " + userInput);
        printSeparationLine();
        System.out.println();
    }

    static void exit() {
        String exit = "    ____________________________________________________________\n" +
                "     Bye. Hope to see you again soon!\n" +
                "    ____________________________________________________________";
        System.out.println(exit);
    }
}