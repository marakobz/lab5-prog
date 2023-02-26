package commandManager.commands;

import commandManager.CollectionManager;
import exceptions.WrongArgumentException;

public class PrintUniqiePersonCommand extends AbstractCommand{
    CollectionManager collectionManager;

    public PrintUniqiePersonCommand(CollectionManager collectionManager){
        super("print", "output the unique values of the person field of all items in the collection");
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
        } catch (WrongArgumentException e) {
            System.out.println("Use: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Mistake. Try again");
        }
        return false;
    }
}
