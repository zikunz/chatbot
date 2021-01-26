import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        */
        ArrayList < String > texts = new ArrayList < String > ();

        greet();
        Scanner myObj = new Scanner(System.in);
        String userInput = myObj.nextLine();
        texts.add(userInput);

        while (true) {
            if (userInput.equals("bye")) {
                exit();
                System.exit(0);
            } else if (userInput.equals("list")) {
                printSeparationLine();
                for (int i = 0; i < texts.size(); ++i) {
                    System.out.println("     " + (i + 1) + ". " + texts.get(i));
                }
                printSeparationLine();
                userInput = myObj.nextLine();
                texts.add(userInput);
            } else {
                echo(userInput);
                userInput = myObj.nextLine();
                if (!userInput.equals("list")) {
                    texts.add(userInput);
                }
            }
        }
    }

    static void greet() {
        String greet = "    ____________________________________________________________\n" +
                "     Hello! I'm Duke\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________\n";
        System.out.println(greet);
    }

    static void printSeparationLine() {
        System.out.println("    ____________________________________________________________");
    }

    static void echo(String userInput) {
        printSeparationLine();
        System.out.println("     added: " + userInput);
        printSeparationLine();
        System.out.println();
    }

    static void exit() {
        String exit = "    ____________________________________________________________\n" +
                "     Bye. Hope to see you again soon!\n" +
                "    ____________________________________________________________";
        System.out.println(exit);
    }

}
