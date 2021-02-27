package Duke;

public class Message {
    public static final String logo = "     ____        _        \n" +
            "    |  _ \\ _   _| | _____ \n" +
            "    | | | | | | | |/ / _ \\\n" +
            "    | |_| | |_| |   <  __/\n" +
            "    |____/ \\__,_|_|\\_\\___|\n";

    public static final String SEPARATION_LINE = "    ____________________________________________________________";

    public static final String SHORT_SPACE = "     ";
    public static final String LONG_SPACE = "       ";

    public static final String GREET_MESSAGE = logo + "\n" + SEPARATION_LINE + "\n" + LONG_SPACE +
            "Hello! I'm Duke\n" + LONG_SPACE + "What can I do for you?\n" + SEPARATION_LINE + "\n";
    public static final String EMPTY_LIST_MESSAGE = SHORT_SPACE + "You do not have any task to do.";
    public static final String MARK_AS_DONE_MESSAGE = SHORT_SPACE + "Nice! I've marked this task as done:";
    public static final String ONE_TASK_IN_LIST_MESSAGE = SHORT_SPACE + "Here is the task in your list:";
    public static final String MORE_THAN_ONE_TASK_IN_LIST_MESSAGE = SHORT_SPACE + "Here are the tasks in your list:";
    public static final String WRONG_COMMAND_ERROR_MESSAGE = SEPARATION_LINE + "\n" + SHORT_SPACE +
            "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" + SEPARATION_LINE + "\n";
    public static final String MISSING_TODO_CONTENT_MESSAGE = SEPARATION_LINE + "\n" +
            SHORT_SPACE + "☹ OOPS!!! The description of a todo cannot be empty.\n" + SEPARATION_LINE + "\n";
    public static final String MISSING_DEADLINE_CONTENT_MESSAGE = SEPARATION_LINE + "\n" +
            SHORT_SPACE + "☹ OOPS!!! The description of a deadline cannot be empty.\n" + SEPARATION_LINE + "\n";
    public static final String MISSING_EVENT_CONTENT_MESSAGE = SEPARATION_LINE + "\n" +
            SHORT_SPACE + "☹ OOPS!!! The description of a event cannot be empty.\n" + SEPARATION_LINE + "\n";
    public static final String MISSING_DELETE_INDEX_MESSAGE = SEPARATION_LINE + "\n" +
            SHORT_SPACE + "☹ OOPS!!! The index of the deletion cannot be empty.\n" + SEPARATION_LINE + "\n";
    public static final String WRONG_DELETE_INDEX_MESSAGE = SEPARATION_LINE + "\n" +
            SHORT_SPACE + "☹ OOPS!!! The index of the deletion is out of bound.\n" + SEPARATION_LINE + "\n";
    public static final String ADD_TASK_MESSAGE = SHORT_SPACE + "Got it. I've added this task:";
    public static final String REMOVE_TASK_MESSAGE = SHORT_SPACE + "Noted. I've removed this task:";
    public static final String EXIT_MESSAGE = SEPARATION_LINE + "\n" + "     Bye. Hope to see you again soon!\n" +
            SEPARATION_LINE;
    public static final String NON_EXISTING_LETTER_WRONG_MESSAGE = "Something wrong happened!";

    public static void printAddOrRemoveTaskMessage(boolean isAdded) {
        if (isAdded) {
            System.out.println(Message.ADD_TASK_MESSAGE);
        } else {
            System.out.println(Message.REMOVE_TASK_MESSAGE);
        }
    }

    public static void printNumberOfTasksMessage(int numberOfTasks) {
        if (numberOfTasks == 1) {
            System.out.println(Message.SHORT_SPACE + "Now you have " + numberOfTasks + " task in the list.");
        } else {
            System.out.println(Message.SHORT_SPACE + "Now you have " + numberOfTasks + " tasks in the list.");
        }
    }
}
