package Exceptions;

public final class Exceptions {
    public static final class CommandNotFound extends Exception{
        public CommandNotFound(){
            System.out.println("Command Not Found");
        }
    }
}
