package commandManager.commands;

import commandManager.CollectionManager;
import commandManager.ICommand;
import exceptions.WrongArgumentException;

public class AverageOfDiscountCommand extends AbstractCommand implements ICommand {
    CollectionManager collectionManager;

    public AverageOfDiscountCommand(CollectionManager collectionManager){
        super("average of discount", "print the average value of the discount field for all items in the collection");
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
