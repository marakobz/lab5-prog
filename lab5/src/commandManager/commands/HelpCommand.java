package commandManager.commands;

import exceptions.WrongArgumentException;

public class HelpCommand extends AbstractCommand{
    public HelpCommand(){
        super("help", "show all commands");
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
