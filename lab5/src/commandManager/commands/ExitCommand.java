package commandManager.commands;

import commandManager.CollectionManager;
import exceptions.WrongAmountOfElementsException;
import exceptions.WrongArgumentException;

public class ExitCommand extends AbstractCommand{

    public ExitCommand(CollectionManager collectionManager){
        super("exit", "end the program (without saving to a file)");
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            return true;
        } catch (WrongAmountOfElementsException exception) {
            System.out.println("Used: '" + getName() + "'");
        }
        return false;
    }
}
