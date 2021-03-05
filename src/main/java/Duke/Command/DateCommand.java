package Duke.Command;

import Duke.Constant.Message;
import Duke.Constant.SpaceAndLine;
import Duke.Exception.DukeException;
import Duke.Storage.Storage;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

import java.time.LocalDate;

public class DateCommand extends Command {
    private final String dateString;
    private LocalDate date;

    public DateCommand(String dateString) {
        this.dateString = dateString;
    }

    @Override
    public boolean shouldExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage, TaskList matchedTasks, TaskList sameDateTasks)
            throws DukeException {
        ui.printMessage(SpaceAndLine.SEPARATION_LINE);
        ui.printMessage(SpaceAndLine.SHORT_SPACE + Message.SHOW_SAME_DATE_TASKS_MESSAGE);

        date = LocalDate.parse(dateString);
        tasks.findDate(date);

        ui.printsameDateTasks(sameDateTasks);
        ui.printMessage(SpaceAndLine.SEPARATION_LINE);

    }
}
