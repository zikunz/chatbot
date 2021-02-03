package Duke;

public class Event extends Task {
    protected String period;


    public Event(String description, String period) {
        super(description);
        this.period = period;
    }


    public String getPeriod() {
        return period;
    }


    @Override
    public String getType() {
        return "E";
    }


    @Override
    public String toString() {
        return "[" + getType() + "]" + "[" + getStatusIcon() + "] " +
                description + " (at: " + getPeriod() + ")";
    }
}