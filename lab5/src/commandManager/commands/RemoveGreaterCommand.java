package commandManager.commands;

import commandManager.CollectionManager;
import commandManager.ICommand;
import commandManager.OrganizationAsker;
import exceptions.*;
import models.Ticket;

public class RemoveGreaterCommand extends AbstractCommand implements ICommand {
    CollectionManager collectionManager;
    OrganizationAsker organizationAsker;

    public RemoveGreaterCommand(CollectionManager collectionManager, OrganizationAsker organizationAsker){
        super("remove greater", "remove all items from the collection that exceed the specified");
        this.collectionManager = collectionManager;
        this.organizationAsker = organizationAsker;
    }

    @Override
    public boolean execute(String arguemnt){
        try {
            if (!arguemnt.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize()==0) throw new EmptyCollectionException();
            var ticket = new Ticket(
                    organizationAsker.askName(),
                    organizationAsker.askCoordinates(),
                    organizationAsker.askDate(),
                    organizationAsker.askHeight(),
                    organizationAsker.askWeight(),
                    organizationAsker.askNationality());
            if (ticket == null) throw new TicketNotFoundException();
            System.out.println("Ticket is deleted");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            System.out.println("Used: '" + getName() + "'");
        } catch (EmptyCollectionException exception) {
            System.out.println("Collection is empty");
        } catch (TicketNotFoundException exception) {
            System.out.println("Ticket doesn't exist");
        } catch (IncorrectScriptException exception) {}
        return false;
    }
}
