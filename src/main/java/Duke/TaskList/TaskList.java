package Duke.TaskList;

import Duke.Constant.SpaceAndLine;
import Duke.Task.Task;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int getSize() {
        return tasks.size();
    }

    public void setTaskToBeDone(int index) {
        tasks.get(index).setAsDone();
    }

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
