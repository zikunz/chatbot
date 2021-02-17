package Duke;

public class Task {
    protected String description;
    protected boolean isDone;
    private static char NOT_DONE_SYMBOL = '\u2718';
    private static char DONE_SYMBOL = '\u2713';

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
        return (isDone ? DONE_SYMBOL : NOT_DONE_SYMBOL);
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