package Duke.Command;


import Duke.Exception.DukeException;
import Duke.Storage.Storage;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

public abstract class Command {

    public abstract boolean shouldExit();

    public abstract void execute(TaskList tasks, Ui ui, Storage storage, TaskList matchedTasks) throws DukeException;
}
