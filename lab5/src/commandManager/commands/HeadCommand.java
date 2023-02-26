package commandManager.commands;

import commandManager.CollectionManager;
import exceptions.WrongArgumentException;

public class HeadCommand extends AbstractCommand{
    CollectionManager collectionManager;

    public HeadCommand(CollectionManager collectionManager){
        super("head", " show first element of collection");
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
