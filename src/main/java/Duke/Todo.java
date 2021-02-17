package Duke;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public char getType() {
        return 'T';
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + "[" + getStatusIcon() + "] " + description;
    }

    @Override
    public String toPrintedFormat() {
        return "T | " + super.getIntegerType() + " | " + description;
    }
}