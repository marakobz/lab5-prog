package commandManager.commands;

import commandManager.CollectionManager;
import commandManager.Console;
import commandManager.OrganizationAsker;
import exceptions.IncorrectScriptException;
import exceptions.WrongAmountOfElementsException;
import exceptions.WrongArgumentException;
import models.Ticket;

import java.time.LocalDateTime;

public class AddElementCommand extends AbstractCommand{
    CollectionManager collectionManager;
    OrganizationAsker organizationAsker;

    public AddElementCommand(CollectionManager collectionManager, OrganizationAsker organizationAsker){
        super("add element","add a new item to the collection");
        this.organizationAsker = organizationAsker;
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(String argument){
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.addToCollection(new Ticket(
                    organizationAsker.askName(),
                    organizationAsker.askCoordinates(),
                    organizationAsker.askDate(),
                    organizationAsker.askHeight(),
                    organizationAsker.askWeight(),
                    organizationAsker.askNationality()
            ));
            System.out.println("Ticket is created");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            System.out.println("Used: '" + getName() + "'");
        } catch (IncorrectScriptException exception) {
            throw new RuntimeException(exception);
        }
        return false;
    }
}
