package Duke.Command;

import Duke.Constant.Message;
import Duke.Constant.SpaceAndLine;
import Duke.Exception.DukeException;
import Duke.Storage.Storage;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean shouldExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage, TaskList matchedTasks) throws DukeException {
        ui.printMessage(SpaceAndLine.SEPARATION_LINE);
        ui.printMessage(SpaceAndLine.SHORT_SPACE + Message.SHOW_MATCHING_TASKS_MESSAGE);

        tasks.findKeyword(keyword);
        ui.printMatchedTasks(matchedTasks);

        ui.printMessage(SpaceAndLine.SEPARATION_LINE);
    }
}
