package Duke.TaskList;

import Duke.Constant.SpaceAndLine;
import Duke.Task.Task;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static ArrayList<Task> matchedTasks = new ArrayList<>();

    public TaskList() {

    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

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
}
