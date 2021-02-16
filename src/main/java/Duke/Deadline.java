package Duke;

public class Deadline extends Task {
    protected String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public char getType() {
        return 'D';
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + "[" + getStatusIcon() + "] " +
                description + " (by: " + getDeadline() + ")";
    }
}