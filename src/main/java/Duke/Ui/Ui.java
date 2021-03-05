package Duke.Ui;

import Duke.Constant.SpaceAndLine;
import Duke.TaskList.TaskList;

import java.util.Scanner;

/**
 * Ui receives all inputs from the user before producing outputs show to him / her.
 */
public class Ui {
    private final Scanner userInput;

    public Ui() {
        userInput = new Scanner(System.in);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints the message telling the user how many tasks are there.
     *
     * @param numberOfTasks number of tasks
     */
    public static void printNumberOfTasksMessage(int numberOfTasks) {
        if (numberOfTasks == 0 || numberOfTasks == 1) {
            System.out.println(SpaceAndLine.SHORT_SPACE + "Now you have " + numberOfTasks + " task in the list.");
        } else {
            System.out.println(SpaceAndLine.SHORT_SPACE + "Now you have " + numberOfTasks + " tasks in the list.");
        }
    }

    /**
     * Reads the user input line by line.
     *
     * @return the string of the line.
     */
    public String readCommand() {
        return userInput.nextLine();
    }

    /**
     * Prints all tasks to the user.
     */
    public void printTasks(TaskList tasks) {
        tasks.displayList();
    }

    public void printMatchedTasks(TaskList matchedTasks) {
        matchedTasks.DisplayMatchedTasks();
    }

    public void printsameDateTasks(TaskList sameDateTasks) {
        sameDateTasks.DisplaySameDateTasks();
    }
}
