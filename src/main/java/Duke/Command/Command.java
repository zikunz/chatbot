package Duke.Command;


import Duke.Exception.DukeException;
import Duke.Storage.Storage;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

/**
 * Represents the command to be executed.
 */
public abstract class Command {

    public abstract boolean shouldExit();

    /**
     * Execute the command based on the specific command type.
     *
     * @param tasks the list of tasks
     * @param ui do outputs
     * @param storage store the data
     * @throws DukeException the exceptions which can happen
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}
