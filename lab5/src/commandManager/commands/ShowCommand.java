package commandManager.commands;

import commandManager.CollectionManager;
import exceptions.WrongArgumentException;

public class ShowCommand extends AbstractCommand{
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show", "show all collection's elements");
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
