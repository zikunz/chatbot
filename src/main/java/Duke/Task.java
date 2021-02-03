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


    public String getDescription() {
        return description;
    }


    public char getStatusIcon() {
        return (isDone ? DONE_SYMBOL : NOT_DONE_SYMBOL);
    }


    public void setAsDone() {
        this.isDone = true;
    }


    public String getType() {
        return "\u2718";
    }

}