package Duke.Ui;

import Duke.Constant.SpaceAndLine;
import Duke.TaskList.TaskList;

import java.util.Scanner;

public class Ui {
    private final Scanner userInput;

    public Ui() {
        userInput = new Scanner(System.in);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNumberOfTasksMessage(int numberOfTasks) {
        if (numberOfTasks == 0 || numberOfTasks == 1) {
            System.out.println(SpaceAndLine.SHORT_SPACE + "Now you have " + numberOfTasks + " task in the list.");
        } else {
            System.out.println(SpaceAndLine.SHORT_SPACE + "Now you have " + numberOfTasks + " tasks in the list.");
        }
    }

    public String readCommand() {
        return userInput.nextLine();
    }

    public void printTasks(TaskList tasks) {
        tasks.displayList();
    }

    public void printMatchedTasks(TaskList matchedTasks) {
        matchedTasks.DisplayMatchedTasks();
    }
}
