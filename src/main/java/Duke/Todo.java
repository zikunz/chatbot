package Duke;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
        isDone = false;
    }

    @Override
    public char getType() {
        return 'T';
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + "[" + getStatusIcon() + "] " + description;
    }
}