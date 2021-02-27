package Duke;

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

    public char getStatusIcon() {
        return (isDone ? Symbol.DONE_SYMBOL : Symbol.NOT_DONE_SYMBOL);
    }

    public void setAsDone() {
        this.isDone = true;
    }

    public char getType() {
        return ' ';
    }

    public char getIntegerType() {
        if (isDone) {
            return '1';
        } else {
            return '0';
        }
    }

    public String toPrintedFormat() {
        return "";
    }
}