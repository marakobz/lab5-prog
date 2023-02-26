package commandManager.commands;

import commandManager.ICommand;
import exceptions.IncorrectScriptException;

public abstract class AbstractCommand implements ICommand {
    private String name;
    private String description;

    public AbstractCommand(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public String getDescripition() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + description;
    };

    @Override
    public int hashCode() {
        return name.hashCode() + description.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AbstractCommand other = (AbstractCommand) obj;
        return name.equals(other.name) && description.equals(other.description);
    }
}
