package Duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static int numberOfTasks;
    private static boolean isAdded;

    // Constants only used in Duke class
    private static final String LETTER_T = "T";
    private static final String LETTER_D = "D";
    private static final String LETTER_E = "E";

    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DELETE = "delete";

    private static final int TODO_COMMAND_LENGTH = 4;
    private static final int TODO_COMMAND_LENGTH_ADD_ONE = 5;
    private static final int DEADLINE_COMMAND_LENGTH = 8;
    private static final int DEADLINE_COMMAND_LENGTH_ADD_ONE = 9;
    private static final int BY_KEYWORD_LENGTH = 4;
    private static final int EVENT_COMMAND_LENGTH = 5;
    private static final int EVENT_COMMAND_LENGTH_ADD_ONE = 5;
    private static final int AT_KEYWORD_LENGTH = 5;

    public static void main(String[] args) {
        File dataDirectory = new File("data");
        dataDirectory.mkdir();
        File dukeFile = new File("data/duke.txt");

        try {
            dukeFile.createNewFile();
            readFileContents("data/duke.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

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
        case COMMAND_TODO:
            addTodo(userInput);
            break;
        case COMMAND_DEADLINE:
            addDeadline(userInput);
            break;
        case COMMAND_EVENT:
            addEvent(userInput);
            break;
        case COMMAND_DONE:
            setTaskToBeDone(userInput);
            break;
        case COMMAND_BYE:
            exit();
            break;
        case COMMAND_LIST:
            displayList();
            break;
        case COMMAND_DELETE:
            deleteTask(userInput);
            break;
        default:
            throw new DukeException(Message.WRONG_COMMAND_ERROR_MESSAGE);
        }
    }

    public static void addTask(Task task) {
        tasks.add(numberOfTasks, task);
        numberOfTasks++;
        isAdded = true;
        echo(task, isAdded);
    }

    static void addTodo(String userInput) throws DukeException {
        String todo = userInput.substring(TODO_COMMAND_LENGTH);
        todo = todo.replace(" ", "");

        if (todo.isEmpty()) {
            throw new DukeException(Message.MISSING_TODO_CONTENT_MESSAGE);
        } else {
            Task newTask = new Todo(userInput.substring(TODO_COMMAND_LENGTH_ADD_ONE));
            addTask(newTask);
        }
        try {
            writeToFile("data/duke.txt", tasks);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    static void addDeadline(String userInput) throws DukeException {
        String deadline = userInput.substring((DEADLINE_COMMAND_LENGTH));
        deadline = deadline.replace(" ", "");

        if (deadline.isEmpty()) {
            throw new DukeException(Message.MISSING_DEADLINE_CONTENT_MESSAGE);
        } else {
            Task newTask = new Deadline(userInput.substring(DEADLINE_COMMAND_LENGTH_ADD_ONE, userInput.indexOf(" /")),
                    userInput.substring(userInput.indexOf("/by") + BY_KEYWORD_LENGTH));
            addTask(newTask);
        }
        try {
            writeToFile("data/duke.txt", tasks);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    static void addEvent(String userInput) throws DukeException {
        String event = userInput.substring((EVENT_COMMAND_LENGTH));
        event = event.replace(" ", "");

        if (event.isEmpty()) {
            throw new DukeException(Message.MISSING_EVENT_CONTENT_MESSAGE);
        } else {
            Task newTask = new Event(userInput.substring(EVENT_COMMAND_LENGTH_ADD_ONE, userInput.indexOf(" /")),
                    userInput.substring(userInput.indexOf("/at") + AT_KEYWORD_LENGTH));
            addTask(newTask);
        }
        try {
            writeToFile("data/duke.txt", tasks);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    static void setTaskToBeDone(String userInput) {
        int selectedTask = Integer.parseInt(userInput.substring(5)) - 1;
        Task thisTask = tasks.get(selectedTask);
        thisTask.setAsDone();
        tasks.set(selectedTask, thisTask);
        printSeparationLine();
        System.out.println(Message.MARK_AS_DONE_MESSAGE);
        System.out.println(Message.LONG_SPACE + "[" + thisTask.getStatusIcon() + "] " +
                thisTask.getDescription());
        printSeparationLine();
    }

    static void deleteTask(String userInput) {
        int selectedTask = Integer.parseInt(userInput.substring(7)) - 1;
        Task thisTask = tasks.get(selectedTask);
        System.out.println(Message.REMOVE_TASK_MESSAGE);

        tasks.remove(selectedTask);
        numberOfTasks--;
        isAdded = false;
        echo(thisTask, isAdded);
    }

    static void displayList() {
        printSeparationLine();
        switch (numberOfTasks) {
        case 0:
            System.out.println(Message.EMPTY_LIST_MESSAGE);
            break;
        case 1:
            System.out.println(Message.ONE_TASK_IN_LIST_MESSAGE);
            break;
        default:
            System.out.println(Message.MORE_THAN_ONE_TASK_IN_LIST_MESSAGE);
        }

        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println(Message.SHORT_SPACE + (i + 1) + "." + tasks.get(i));
        }
        printSeparationLine();
        System.out.println();
    }

    static void greet() {
        System.out.println(Message.GREET_MESSAGE);
    }

    static void printSeparationLine() {
        System.out.println(Message.SEPARATION_LINE);
    }

    static void echo(Task newTask, boolean isAdded) {
        printSeparationLine();

        Message.printAddOrRemoveTaskMessage(isAdded);

        System.out.println(Message.LONG_SPACE + newTask);

        Message.printNumberOfTasksMessage(numberOfTasks);

        printSeparationLine();
    }

    static void exit() {
        System.out.println(Message.EXIT_MESSAGE);
        System.exit(0);
    }

    private static void readFileContents(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sentence = new Scanner(file);


        while (sentence.hasNext()) {
            String[] sentences = sentence.nextLine().split("( \\| )");

            boolean isDone;
            if (sentences[1] == "1") {
                isDone = true;
            } else {
                isDone = false;
            }
            Task task = new Task("");
            switch (sentences[0]) {
            case LETTER_T:
                task = new Todo(sentences[2], isDone);
                break;
            case LETTER_D:
                task = new Deadline(sentences[2], sentences[3], isDone);
                break;
            case LETTER_E:
                task = new Event(sentences[2], sentences[3], isDone);
                break;
            default:
                System.out.println(Message.NON_EXISTING_LETTER_WRONG_MESSAGE);
            }
            tasks.add(task);
            numberOfTasks++;
        }
    }

    private static void writeToFile(String filePath, ArrayList<Task>tasksToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        String text = "";

        for (int i = 0; i < tasksToAdd.size(); i++) {
            text = text + tasksToAdd.get(i).toPrintedFormat() + "\n";
        }

        fw.write(text);
        fw.close();
    }
}