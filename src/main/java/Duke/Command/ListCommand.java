package Duke.Command;

import Duke.Constant.Message;
import Duke.Constant.SpaceAndLine;
import Duke.Exception.DukeException;
import Duke.Storage.Storage;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

public class ListCommand extends Command {

    @Override
    public boolean shouldExit() {
        return false;
    }

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
