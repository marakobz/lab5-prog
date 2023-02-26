package commandManager.commands;

import commandManager.CollectionManager;
import exceptions.WrongAmountOfElementsException;

public class ClearCommand extends AbstractCommand{
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "clear collection");
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.clearCollection();
            System.out.println("Collection is clear now");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            System.out.println("Used: '" + getName() + "'");
        }
        return false;
    }
}
