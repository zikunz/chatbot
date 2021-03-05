package Duke.TaskList;

import Duke.Constant.SpaceAndLine;
import Duke.Task.Task;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Contains the list of tasks and provides methods to add / delete / mark as done.
 */
public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static ArrayList<Task> matchedTasks = new ArrayList<Task>();
    private static ArrayList<Task> sameDateTasks = new ArrayList<Task>();

    public TaskList() {

    }

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

    public static ArrayList<Task> getMatchedTasks() {
        return matchedTasks;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }


    public String getTaskDescription(Task task) {
        return task.getDescription();
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

    public void findKeyword(String keyword) {
        for (int i = 0; i < tasks.size(); i++) {
            String description = getTask(i).getDescription();
            if (keywordMatched(keyword, description)) {
                matchedTasks.add(getTask(i));
            }
        }
    }

    private boolean keywordMatched(String keyword, String description) {
        if (description.contains(keyword)) {
            return true;
        } else {
            return false;
        }
    }

    public void DisplayMatchedTasks() {
        for (int i = 0; i < matchedTasks.size(); i++) {
            System.out.println(SpaceAndLine.SHORT_SPACE + (i + 1) + "." + matchedTasks.get(i));
        }
    }

    public void findDate(LocalDate date) {
        for (int i = 0; i < tasks.size(); i++) {
            String dateString = getTask(i).getDate();
            LocalDate convertedDate = LocalDate.parse(dateString);
            if (date.equals(convertedDate)) {
                sameDateTasks.add(getTask(i));
            }
        }
    }

    public void DisplaySameDateTasks() {
        for (int i = 0; i < sameDateTasks.size(); i++) {
            System.out.println(SpaceAndLine.SHORT_SPACE + (i + 1) + "." + sameDateTasks.get(i));
        }
    }
}
