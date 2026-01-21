// Nazuna Cypher
// by Vincent Banks
// 1 / 21 / 2026

import CommandLine.CommandLine;
import Exceptions.Exceptions.CommandNotFound;

public class NazunaCypher {

    public static void runCommandLine() throws CommandNotFound {
        final CommandLine commandLine = CommandLine.getInstance();

        commandLine.listen();
    }

    public static void main(String[] args) throws CommandNotFound {
        if (args.length < 1) {
            runCommandLine();
            return;
        }



    }

}
