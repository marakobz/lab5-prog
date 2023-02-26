package commandManager;

import exceptions.IncorrectScriptException;

public interface ICommand {
    String getDescripition();

    String getName();

    boolean execute(String argument);
}