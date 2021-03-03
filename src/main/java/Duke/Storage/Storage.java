package Duke.Storage;

import Duke.Constant.Message;
import Duke.Exception.DukeException;
import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;
import Duke.TaskList.TaskList;
import Duke.Constant.Number;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static final String LETTER_T = "T";
    private static final String LETTER_D = "D";
    private static final String LETTER_E = "E";

    private static File dataDirectory;
    private static String fullPath;
    private static File dukeFile;

    public Storage(String folderName, String fileName) {
        dataDirectory = new File(folderName);
        dataDirectory.mkdir();
        fullPath = folderName + "/" + fileName;
        dukeFile = new File(fullPath);
    }

    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            dukeFile.createNewFile();
            File file = new File(fullPath);
            Scanner sentence = new Scanner(file);

            while (sentence.hasNext()) {
                String[] sentences = sentence.nextLine().split("( \\| )");

                boolean isDone;
                if (sentences[1].equals(Number.DONE_STATUS)) {
                    isDone = true;
                } else {
                    isDone = false;
                }

                Task task = new Task("");

                switch (sentences[0]) {
                case LETTER_T:
                    task = new Todo(sentences[2], isDone);
                    break;
                case LETTER_D:
                    task = new Deadline(sentences[2], sentences[3], isDone);
                    break;
                case LETTER_E:
                    task = new Event(sentences[2], sentences[3], isDone);
                    break;
                default:
                    System.out.println(Message.NON_EXISTING_LETTER_WRONG_MESSAGE);
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            throw new DukeException(Message.LOADING_ERROR_MESSAGE);
        }
        return tasks;
    }

    public void writeToFile(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(fullPath);
        fw.write(tasks.toPrintedFormat());
        fw.close();
    }
}
