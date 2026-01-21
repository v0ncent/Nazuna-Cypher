package CommandLine;

import java.util.Locale;
import java.util.Scanner;

import Exceptions.Exceptions;
import Util.Util;
import Exceptions.Exceptions.CommandNotFound;

public final class CommandLine {
    private static CommandLine instance = null;

    public static CommandLine getInstance() {
        if (instance == null) {
            instance = new CommandLine();
        }

        return instance;
    }

    public void listen() throws CommandNotFound {
        System.out.println("  _   _                                _____            _               \n" +
                " | \\ | |                              / ____|          | |              \n" +
                " |  \\| | __ _ _____   _ _ __   __ _  | |    _   _ _ __ | |__   ___ _ __ \n" +
                " | . ` |/ _` |_  / | | | '_ \\ / _` | | |   | | | | '_ \\| '_ \\ / _ \\ '__|\n" +
                " | |\\  | (_| |/ /| |_| | | | | (_| | | |___| |_| | |_) | | | |  __/ |   \n" +
                " |_| \\_|\\__,_/___|\\__,_|_| |_|\\__,_|  \\_____\\__, | .__/|_| |_|\\___|_|   \n" +
                "                                             __/ | |                    \n" +
                "                                            |___/|_|            ");

        Util.printSoftwareVersion();

        while (true) {
            try {
                System.out.print("c>: ");
                Scanner scnr = new Scanner(System.in);

                String[] args = scnr.nextLine().strip().split(" ");
                handle(args);

            } catch (CommandNotFound ignored) {}
            catch (Exception e) {
                e.printStackTrace();
                listen();
            }

        }

    }

    private void handle(String[] args) throws CommandNotFound {
        switch (args[0].toLowerCase(Locale.ROOT)){


            default: throw new CommandNotFound();
        }
    }

    // Exception Manager
    static final class CMLineExceptionHandler {
        public static void handle(Class<?> clazz, Exception e ){
            if(e.getClass().equals(ArrayIndexOutOfBoundsException.class)){
                System.out.println("You have not provided a necessary argument");
                return;
            }
            if(e.getClass().getDeclaringClass().equals(Exceptions.class)){ //if member of custom exceptions ignore they handle themselves
                return;
            }

            System.out.println((String.format("UH OH: there was an error @ %s\n%s",clazz.getName(),e)));

            e.printStackTrace();
        }
    }

}
