package Duke;

public class Event extends Task {
    protected String period;

    public Event(String description, String period) {
        super(description);
        this.period = period;
    }

    public Event(String description, String period, boolean isDone) {
        super(description, isDone);
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    @Override
    public char getType() {
        return 'E';
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + "[" + getStatusIcon() + "] " +
                description + " (at: " + getPeriod() + ")";
    }

    @Override
    public String toPrintedFormat() {
        return "E | " + super.getIntegerType() + " | " + description + " | " + getPeriod();
    }
}