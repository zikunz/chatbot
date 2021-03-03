package Duke.Parser;

import Duke.Command.AddCommand;
import Duke.Command.Command;
import Duke.Command.DeleteCommand;
import Duke.Command.DoneCommand;
import Duke.Command.ExitCommand;
import Duke.Command.ListCommand;
import Duke.Constant.Message;
import Duke.Constant.TaskType;
import Duke.Exception.DukeException;
import Duke.Constant.Number;

public class Parser {
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DELETE = "delete";

    public Command processInput(String userInput) throws DukeException {
        String command = userInput.split(" ")[0];

        switch (command) {
        case COMMAND_TODO:
            String description = userInput.substring(Number.TODO_COMMAND_LENGTH);
            description = description.replace(" ", "");

            if (description.isEmpty()) {
                throw new DukeException(Message.MISSING_TODO_CONTENT_MESSAGE);
            }

            return new AddCommand(TaskType.TODO_TYPE, userInput.substring(Number.TODO_COMMAND_LENGTH_ADD_ONE));
        case COMMAND_DEADLINE:
            String deadline = userInput.substring((Number.DEADLINE_COMMAND_LENGTH));
            deadline = deadline.replace(" ", "");

            if (deadline.isEmpty()) {
                throw new DukeException(Message.MISSING_DEADLINE_CONTENT_MESSAGE);
            }

            return new AddCommand(TaskType.DEADLINE_TYPE, userInput.substring(Number.DEADLINE_COMMAND_LENGTH_ADD_ONE));
        case COMMAND_EVENT:
            String event = userInput.substring((Number.EVENT_COMMAND_LENGTH));
            event = event.replace(" ", "");

            if (event.isEmpty()) {
                throw new DukeException(Message.MISSING_EVENT_CONTENT_MESSAGE);
            }

            return new AddCommand(TaskType.EVENT_TYPE, userInput.substring(Number.EVENT_COMMAND_LENGTH_ADD_ONE));
        case COMMAND_DONE:
            return new DoneCommand(Integer.parseInt(userInput.substring(Number.DONE_COMMAND_LENGTH_ADD_ONE)) - 1);
        case COMMAND_BYE:
            return new ExitCommand();
        case COMMAND_LIST:
            return new ListCommand();
        case COMMAND_DELETE:
            return new DeleteCommand
                    (Integer.parseInt(userInput.substring(Number.DELETE_COMMAND_LENGTH_ADD_ONE)) - 1);
        default:
            throw new DukeException(Message.WRONG_COMMAND_ERROR_MESSAGE);
        }
    }
}
