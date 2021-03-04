package Duke.Task;

import Duke.Constant.Symbol;
import Duke.Constant.Number;

/**
 * Represents the task objects.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Provides the status of the task.
     *
     * @return returns a tick if the task is done, and returns a cross if the task is not done
     */
    public String getStatusIcon() {
        return (isDone ? Symbol.DONE_SYMBOL : Symbol.NOT_DONE_SYMBOL);
    }

    /**
     * Set a task's status as done.
     */
    public void setAsDone() {
        this.isDone = true;
    }

    public String getType() {
        return "";
    }

    public String getIntegerType() {
        if (isDone) {
            return Number.DONE_STATUS;
        } else {
            return Number.NOT_DONE_STATUS;
        }
    }

    /**
     * Returns the string to be printed in the list.
     *
     * @return the task's details
     */
    public String toString() {
        return "";
    }

    public String toPrintedFormat() {
        return "";
    }
}