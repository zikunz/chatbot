package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Storage.Storage;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

public class ExitCommand extends Command {

    @Override
    public boolean shouldExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage, TaskList matchedTasks) throws DukeException {
        // Do nothing
    }
}
