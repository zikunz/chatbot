package Duke.Command;

import Duke.Constant.Message;
import Duke.Constant.SpaceAndLine;
import Duke.Exception.DukeException;
import Duke.Storage.Storage;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

import java.io.IOException;

/**
 * Represents the command call when the user mark a task as done.
 */
public class DoneCommand extends Command {
    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public boolean shouldExit() {
        return false;
    }

    /**
     * Mark a specific task as done and update the Duke file.
     *
     * @param tasks the list of tasks
     * @param ui outputs to be printed
     * @param storage store data into Duke.txt
     * @throws DukeException the exceptions which can happen
     * */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage, TaskList matchedTasks) throws DukeException {
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
