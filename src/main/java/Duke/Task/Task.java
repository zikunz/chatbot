package Duke.Task;

import Duke.Constant.Symbol;
import Duke.Constant.Number;

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

    public String getStatusIcon() {
        return (isDone ? Symbol.DONE_SYMBOL : Symbol.NOT_DONE_SYMBOL);
    }

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

    public String toString() {
        return "";
    }

    public String toPrintedFormat() {
        return "";
    }
}