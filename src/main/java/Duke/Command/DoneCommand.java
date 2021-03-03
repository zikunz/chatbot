package Duke.Command;

import Duke.Constant.Message;
import Duke.Constant.SpaceAndLine;
import Duke.Exception.DukeException;
import Duke.Storage.Storage;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

import java.io.IOException;

public class DoneCommand extends Command {
    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public boolean shouldExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.setTaskToBeDone(index);

        ui.printMessage(SpaceAndLine.SEPARATION_LINE);
        ui.printMessage(Message.MARK_AS_DONE_MESSAGE);
        System.out.println(SpaceAndLine.LONG_SPACE + tasks.getTask(index));
        ui.printMessage(SpaceAndLine.SEPARATION_LINE);

        try {
            storage.writeToFile(tasks);
        } catch (IOException ioException) {
            throw new DukeException("File not found");
        }
    }
}
