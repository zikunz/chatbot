package Duke.Command;

import Duke.Constant.Message;
import Duke.Constant.SpaceAndLine;
import Duke.Exception.DukeException;
import Duke.Storage.Storage;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

/**
 * Represents the command call when the user wants to see the whole list of tasks.
 */
public class ListCommand extends Command {

    @Override
    public boolean shouldExit() {
        return false;
    }

    /**
     * Prints the list of tasks.
     *
     * @param tasks the list of tasks
     * @param ui outputs to be printed
     * @param storage store data into Duke.txt
     * @throws DukeException the exceptions which can happen in this function
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ui.printMessage(SpaceAndLine.SEPARATION_LINE);
        switch (tasks.getSize()) {
        case 0:
            System.out.println(Message.EMPTY_LIST_MESSAGE);
            break;
        case 1:
            System.out.println(Message.ONE_TASK_IN_LIST_MESSAGE);
            break;
        default:
            System.out.println(Message.MORE_THAN_ONE_TASK_IN_LIST_MESSAGE);
        }
        ui.printTasks(tasks);
        ui.printMessage(SpaceAndLine.SEPARATION_LINE);
    }
}
