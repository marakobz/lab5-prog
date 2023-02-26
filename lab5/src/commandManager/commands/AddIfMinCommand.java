package commandManager.commands;

import commandManager.CollectionManager;
import commandManager.Console;
import commandManager.OrganizationAsker;
import exceptions.IncorrectScriptException;
import exceptions.WrongAmountOfElementsException;
import exceptions.WrongArgumentException;
import models.Ticket;

public class AddIfMinCommand extends AbstractCommand {
    CollectionManager collectionManager;
    OrganizationAsker organizationAsker;

    public AddIfMinCommand(CollectionManager collectionManager, OrganizationAsker organizationAsker) {
        super("add min element", "add a new item to the collection if its value is less than that of the smallest item in this collection");
        this.organizationAsker = organizationAsker;
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            var ticket = new Ticket(
                    organizationAsker.askName(),
                    organizationAsker.askCoordinates(),
                    organizationAsker.askDate(),
                    organizationAsker.askHeight(),
                    organizationAsker.askWeight(),
                    organizationAsker.askNationality());
            if (collectionManager.collectionSize() == 0 || ticket.compareTo(collectionManager.getFirst()) < 0) {
                collectionManager.addToCollection(ticket);
                System.out.println("Ticket is added successfully");
                return true;
            } else
                System.out.println("The value of the ticket is greater than the value of the smallest of the tickets");
        } catch (WrongAmountOfElementsException exception) {
            System.out.println("Used: '" + getName() + "'");
        } catch (IncorrectScriptException exception) {
        }
        return false;
    }
}
