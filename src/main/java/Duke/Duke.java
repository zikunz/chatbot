package Duke;

import java.util.Scanner;

public class Duke {
    private static Task[] tasks = new Task[100];
    private static int numberOfTasks;

    private static String logo = "     ____        _        \n" +
            "    |  _ \\ _   _| | _____ \n" +
            "    | | | | | | | |/ / _ \\\n" +
            "    | |_| | |_| |   <  __/\n" +
            "    |____/ \\__,_|_|\\_\\___|\n";

    private static String SEPARATION_LINE = "    ____________________________________________________________";

    private static String SPACES = "       ";

    private static String GREET_MESSAGE = logo + "\n" + SEPARATION_LINE + "\n" + SPACES + "Hello! I'm Duke\n" +
            SPACES + "What can I do for you?\n" + SEPARATION_LINE + "\n";
    private static String EXIT_MESSAGE = SEPARATION_LINE + "\n" + "     Bye. Hope to see you again soon!\n" +
            SEPARATION_LINE;

    private static char NOT_DONE_SYMBOL = '\u2718';


    public static void main(String[] args) {
        greet();

        Scanner in = new Scanner(System.in);
        String userInput = "";
        boolean isInvalid = true;

        while (isInvalid) {
            userInput = in .nextLine();
            if (!userInput.equals("list")) {
                isInvalid = false;
            } else {
                printSeparationLine();
                System.out.println("You do not have any task to do.");
                printSeparationLine();
            }
        }

        while (true) {
            if (userInput.startsWith("todo ")) {
                Task newTask = new Todo(userInput.substring(5));
                addTask(newTask);
            } else if (userInput.startsWith("deadline ")) {
                Task newTask = new Deadline(userInput.substring(9, userInput.indexOf("/")),
                        userInput.substring(userInput.indexOf("/by") + 4));
                addTask(newTask);
            } else if (userInput.startsWith("event ")) {
                Task newTask = new Event(userInput.substring(6, userInput.indexOf("/")),
                        userInput.substring(userInput.indexOf("/at") + 4));
                addTask(newTask);
            } else if (userInput.startsWith("done ")) {
                int selectedTask = Integer.parseInt(userInput.substring(5)) - 1;
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
                if (numberOfTasks == 1) {
                    System.out.println("     Here is the task in your list:");
                } else {
                    System.out.println("     Here are the tasks in your list:");
                }
                for (int i = 0; i < numberOfTasks; i++) {
                    System.out.println("     " + (i + 1) + "." + tasks[i]);
                }
                printSeparationLine();
                System.out.println();
            }
            userInput = in .nextLine();
        }
    }


    static void greet() {
        System.out.println(GREET_MESSAGE);
    }


    static void printSeparationLine() {
        System.out.println(SEPARATION_LINE);
    }


    public static void addTask(Task t) {
        tasks[numberOfTasks] = t;
        numberOfTasks++;
        echo(t);
    }


    static void echo(Task newTask) {
        printSeparationLine();
        System.out.println(SPACES + "Got it. I've added this task:");

        System.out.println(SPACES + newTask);

        if (numberOfTasks == 1) {
            System.out.println(SPACES + "Now you have " + numberOfTasks + " task in the list.");
        } else {
            System.out.println(SPACES + "Now you have " + numberOfTasks + " tasks in the list.");
        }

        printSeparationLine();
        System.out.println();
    }


    static void exit() {
        System.out.println(EXIT_MESSAGE);
    }
}