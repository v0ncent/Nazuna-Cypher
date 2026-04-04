// Nazuna Cypher
// by Vincent Banks
// 1 / 21 / 2026

import CommandLine.CommandLine;
import Exceptions.Exceptions.CommandNotFound;
import NazunaCypher.EncryptionFunctions;

public class Main {
    private static final CommandLine commandLine = CommandLine.getInstance();

    public static void argumentParser(String[] args) throws CommandNotFound {

    }

    public static void main(String[] args) throws CommandNotFound {
//        if (args.length < 1) {
//            commandLine.listen();
//
//            return;
//        }
//
//        argumentParser(args);

        String input = "bruhxss";
        input = EncryptionFunctions.swapTopBottom(input);

        System.out.println(input);

        input = EncryptionFunctions.swapTopBottom(input);
        System.out.println(input);
    }

}
