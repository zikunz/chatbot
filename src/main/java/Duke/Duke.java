package Duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static ArrayList <Task> tasks = new ArrayList <Task>();
    private static int numberOfTasks;

    private static String logo = "     ____        _        \n" +
            "    |  _ \\ _   _| | _____ \n" +
            "    | | | | | | | |/ / _ \\\n" +
            "    | |_| | |_| |   <  __/\n" +
            "    |____/ \\__,_|_|\\_\\___|\n";

    private static String SEPARATION_LINE = "    ____________________________________________________________";

    private static String SHORT_SPACE = "     ";
    private static String LONG_SPACE = "       ";

    private static String GREET_MESSAGE = logo + "\n" + SEPARATION_LINE + "\n" + LONG_SPACE + "Hello! I'm Duke\n" +
            LONG_SPACE + "What can I do for you?\n" + SEPARATION_LINE + "\n";
    private static String EMPTY_LIST_MESSAGE = SHORT_SPACE + "You do not have any task to do.";
    private static String MARK_AS_DONE_MESSAGE = SHORT_SPACE + "Nice! I've marked this task as done:";
    private static String ONE_TASK_IN_LIST_MESSAGE = SHORT_SPACE + "Here is the task in your list:";
    private static String MORE_THAN_ONE_TASK_IN_LIST_MESSAGE = SHORT_SPACE + "Here are the tasks in your list:";
    private static String WRONG_COMMAND_ERROR_MESSAGE = SHORT_SPACE +
            "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" + SEPARATION_LINE + "\n";
    private static String MISSING_TODO_CONTENT_MESSAGE = SEPARATION_LINE + "\n" +
            SHORT_SPACE + "☹ OOPS!!! The description of a todo cannot be empty.\n" + SEPARATION_LINE + "\n";
    private static String MISSING_DEADLINE_CONTENT_MESSAGE = SEPARATION_LINE + "\n" +
            SHORT_SPACE + "☹ OOPS!!! The description of a deadline cannot be empty.\n" + SEPARATION_LINE + "\n";
    private static String MISSING_EVENT_CONTENT_MESSAGE = SEPARATION_LINE + "\n" +
            SHORT_SPACE + "☹ OOPS!!! The description of a event cannot be empty.\n" + SEPARATION_LINE + "\n";
    private static String EXIT_MESSAGE = SEPARATION_LINE + "\n" + "     Bye. Hope to see you again soon!\n" +
            SEPARATION_LINE;

    private static char NOT_DONE_SYMBOL = '\u2718';

    public static void main(String[] args) {
        greet();

        Scanner in = new Scanner(System.in);
        String userInput;
        userInput = in.nextLine();

        while (true) {
            try {
                processCommand(userInput);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            } finally {
                userInput = in.nextLine();
            }
        }
    }

    static void processCommand(String userInput) throws DukeException {
        String command = userInput.split(" ")[0];

        switch (command) {
        case "todo":
            addTodo(userInput);
            break;
        case "deadline":
            addDeadline(userInput);
            break;
        case "event":
            addEvent(userInput);
            break;
        case "done":
            setTaskToBeDone(userInput);
            break;
        case "bye":
            exit();
            break;
        case "list":
            displayList();
            break;
        default:
            throw new DukeException(WRONG_COMMAND_ERROR_MESSAGE);
        }
    }

    public static void addTask(Task t) {
        tasks.add(numberOfTasks, t);
        numberOfTasks++;
        echo(t);
    }

    static void addTodo(String userInput) throws DukeException {
        String todo = userInput.substring(4);
        todo = todo.replace(" ", "");

        if (todo.isEmpty()) {
            throw new DukeException(MISSING_TODO_CONTENT_MESSAGE);
        } else {
            Task newTask = new Todo(userInput.substring(5));
            addTask(newTask);
        }
    }

    static void addDeadline(String userInput) throws DukeException {
        String deadline = userInput.substring((8));
        deadline = deadline.replace(" ", "");

        if (deadline.isEmpty()) {
            throw new DukeException(MISSING_DEADLINE_CONTENT_MESSAGE);
        } else {
            Task newTask = new Deadline(userInput.substring(9, userInput.indexOf("/")),
                    userInput.substring(userInput.indexOf("/by") + 4));
            addTask(newTask);
        }
    }

    static void addEvent(String userInput) throws DukeException {
        String event = userInput.substring((5));
        event = event.replace(" ", "");

        if (event.isEmpty()) {
            throw new DukeException(MISSING_EVENT_CONTENT_MESSAGE);
        } else {
            Task newTask = new Event(userInput.substring(6, userInput.indexOf("/")),
                    userInput.substring(userInput.indexOf("/at") + 4));
            addTask(newTask);
        }
    }

    static void setTaskToBeDone(String userInput) {
        int selectedTask = Integer.parseInt(userInput.substring(5)) - 1;
        Task thisTask = tasks.get(selectedTask);
        thisTask.setAsDone();
        tasks.set(selectedTask, thisTask);
        printSeparationLine();
        System.out.println(MARK_AS_DONE_MESSAGE);
        System.out.println("       [" + thisTask.getStatusIcon() + "] " +
                thisTask.getDescription());
        printSeparationLine();
    }

    static void displayList() {
        printSeparationLine();
        switch (numberOfTasks) {
        case 0:
            System.out.println(EMPTY_LIST_MESSAGE);
            break;
        case 1:
            System.out.println(ONE_TASK_IN_LIST_MESSAGE);
            break;
        default:
            System.out.println(MORE_THAN_ONE_TASK_IN_LIST_MESSAGE);
        }

        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println("     " + (i + 1) + "." + tasks.get(i));
        }
        printSeparationLine();
        System.out.println();
    }

    static void greet() {
        System.out.println(GREET_MESSAGE);
    }

    static void printSeparationLine() {
        System.out.println(SEPARATION_LINE);
    }

    static void echo(Task newTask) {
        printSeparationLine();
        System.out.println(LONG_SPACE + "Got it. I've added this task:");

        System.out.println(LONG_SPACE + newTask);

        if (numberOfTasks == 1) {
            System.out.println(LONG_SPACE + "Now you have " + numberOfTasks + " task in the list.");
        } else {
            System.out.println(LONG_SPACE + "Now you have " + numberOfTasks + " tasks in the list.");
        }

        printSeparationLine();
        System.out.println();
    }

    static void exit() {
        System.out.println(EXIT_MESSAGE);
        System.exit(0);
    }
}