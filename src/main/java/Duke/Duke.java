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

    private static String NOT_DONE_SYMBOL = "\u2718";

    //public static int WRONG_COMMAND_ERROR = 0;
    //private static int TODO_ERROR = 1;




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
            try {
                processCommand(userInput);
            } catch(DukeException e) {
                System.out.println(e.getMessage());
            } finally {
                userInput = in.nextLine();
            }

        }
    }

    static void processCommand(String userInput) throws DukeException {
        if (userInput.startsWith("todo")) {
            try {
                addTodo(userInput);
            } catch (DukeException e){
                System.out.println(e.getMessage());
            }
        } else if (userInput.startsWith("deadline ")) {
            addDeadline(userInput);
        } else if (userInput.startsWith("event ")) {
            addEvent(userInput);
        } else if (userInput.startsWith("done ")) {
            setTaskToBeDone(userInput);
        } else if (userInput.equals("bye")) {
            exit();
        } else if (userInput.equals("list")) {
            addList();
        }
        else {
            throw new DukeException("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

    }

    static void addTodo(String userInput) throws DukeException {
        String todo = userInput.substring(4);
        todo = todo.replace(" ", "");

        if (todo.isEmpty()) {
            throw new DukeException("     ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        
        else {
            Task newTask = new Todo(userInput.substring(5));
            addTask(newTask);
        }
    }

    static void addDeadline(String userInput) {
            Task newTask = new Deadline(userInput.substring(9, userInput.indexOf("/")),
                    userInput.substring(userInput.indexOf("/by") + 4));
            addTask(newTask);
    }

    static void setTaskToBeDone(String userInput) {
        int selectedTask = Integer.parseInt(userInput.substring(5)) - 1;
        tasks[selectedTask].setAsDone();
        printSeparationLine();
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("       [" + tasks[selectedTask].getStatusIcon() + "] " +
                tasks[selectedTask].getDescription());
        printSeparationLine();
    }

    static void addList() {
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

    static void addEvent(String userInput) {
        Task newTask = new Event(userInput.substring(6, userInput.indexOf("/")),
                userInput.substring(userInput.indexOf("/at") + 4));
        addTask(newTask);
    }

    /*static void printErrorMessage(int errorNumber) {
        if (errorNumber == WRONG_COMMAND_ERROR) {
            System.out.println("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        } else if (errorNumber == TODO_ERROR) {
            System.out.println("     ☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }*/

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
        System.exit(0);
    }
}