package commandManager.commands;

import commandManager.CollectionManager;
import commandManager.ICommand;
import exceptions.IncorrectScriptException;

public class InfoCommand extends AbstractCommand implements ICommand{

    public InfoCommand(CollectionManager collectionManager){
        super("info", "output information about the collection to the standard output stream");
    }
    @Override
    public boolean execute(String argument){
        return false;
    }
}

