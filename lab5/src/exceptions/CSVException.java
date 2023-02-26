package exceptions;

public class CSVException extends RuntimeException{
    protected CSVException(String message){
        super("\nError happened while trying to parse" + message);
    }
}
