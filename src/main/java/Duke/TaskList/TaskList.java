package Duke.TaskList;

import Duke.Constant.SpaceAndLine;
import Duke.Task.Task;

import java.util.ArrayList;

/**
 * Contains the list of tasks and provides methods to add / delete / mark as done.
 */
public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<Task>();

    /**
     * Construct the tasks of an ArrayList type.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gives the the list of tasks.
     *
     * @return the list of tasks
     */
    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Adds a task to the task list.
     *
     * @param task task to be added
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Returns number of task(s) are in the list.
     *
     * @return the size of the number og tasks
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Mark a task as done.
     *
     * @param index index of the task to be marked as done
     */
    public void setTaskToBeDone(int index) {
        tasks.get(index).setAsDone();
    }

    /**
     * Remove the task indicated by the user.
     * @param index index of the task to be deleted
     */
    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public static void displayList() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(SpaceAndLine.SHORT_SPACE + (i + 1) + "." + tasks.get(i));
        }
    }

    public String toPrintedFormat() {
        String text = "";
        for (int i = 0; i < tasks.size(); i++) {
            text = text + getTask(i).toPrintedFormat() + "\n";
        }
        return text;
    }
}
