package commandManager;

import commandManager.commands.*;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<ICommand> commands = new ArrayList<>();
    private HelpCommand helpCommand;
    private InfoCommand infoCommand;
    private ShowCommand showCommand;
    private AddElementCommand addElementCommand;
    private UpdateCommand updateID;
    private RemoveByIdCommand removeByIdCommand;
    private ClearCommand clearCommand;
    private SaveCommand saveCommand;
    private ExecuteScriptCommand executeScriptCommand;
    private ExitCommand exitCommand;
    private HeadCommand headCommand;
    private AddIfMinCommand addIfMinCommand;
    private RemoveGreaterCommand removeGreaterCommand;
    private AverageOfDiscountCommand averageOfDiscountCommand;
    private GroupCountingCommand groupCountingCommand;
    private PrintUniqiePersonCommand printUniqiePersonCommand;
    private HistoryCommand historyCommand;


        public CommandManager(HelpCommand helpCommand,
                              InfoCommand infoCommand,
                              ShowCommand showCommand,
                              AddElementCommand addElementCommand,
                              UpdateCommand updateID,
                              SaveCommand saveCommand,
                              ExecuteScriptCommand executeScriptCommand,
                              ExitCommand exitCommand,
                              HeadCommand headCommand,
                              AddIfMinCommand addIfMinCommand,
                              RemoveGreaterCommand removeGreaterCommand,
                              AverageOfDiscountCommand averageOfDiscountCommand,
                              GroupCountingCommand groupCountingCommand,
                              RemoveByIdCommand removeByIdCommand, PrintUniqiePersonCommand printUniqiePersonCommand) {
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.addElementCommand = addElementCommand;
        this.updateID = updateID;
        this.removeByIdCommand = this.removeByIdCommand;
        this.clearCommand = clearCommand;
        this.saveCommand = saveCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.exitCommand = exitCommand;
        this.headCommand = headCommand;
        this.addIfMinCommand = addIfMinCommand;
        this.removeGreaterCommand = removeGreaterCommand;
        this.averageOfDiscountCommand = averageOfDiscountCommand;
        this.groupCountingCommand = groupCountingCommand;
        this.printUniqiePersonCommand = printUniqiePersonCommand;
        this.historyCommand = historyCommand;

        commands.add(helpCommand);
        commands.add(infoCommand);
        commands.add(showCommand);
        commands.add(addElementCommand);
        commands.add(updateID);
        commands.add(clearCommand);
        commands.add(this.removeByIdCommand);
        commands.add(saveCommand);
        commands.add(executeScriptCommand);
        commands.add(exitCommand);
        commands.add(headCommand);
        commands.add(addIfMinCommand);
        commands.add(removeGreaterCommand);
        commands.add(averageOfDiscountCommand);
        commands.add(groupCountingCommand);
        commands.add(printUniqiePersonCommand);
        commands.add(historyCommand);
    }

    public boolean help(String argument) {
        if (helpCommand.execute(argument)) {
            for (ICommand command : commands) {
                System.out.println(command.getName() + command.getDescripition());
            }
            return true;
        } else {
            helpCommand.execute(argument);
        }
        return false;
    }

    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }

    public boolean show(String argument){
        return showCommand.execute(argument);
    }

    public boolean addElement(String argument){
        return addElementCommand.execute(argument);
    }

    public boolean update(String argument){
        return updateID.execute(argument);
    }

    public boolean clear(String argument){
        return clearCommand.execute(argument);
    }

    public boolean remove(String argument){
        return removeByIdCommand.execute(argument);
    }

    public boolean save(String argument){
        return saveCommand.execute(argument);
    }

    public boolean executeScipt(String argument){
        return executeScriptCommand.execute(argument);
    }

    public boolean exit(String argument){
        return exitCommand.execute(argument);
    }

    public boolean head(String argument){
        return headCommand.execute(argument);
    }

    public boolean addmin(String argument){
        return addIfMinCommand.execute(argument);
    }

    public boolean removeGreater(String argument){
        return removeGreaterCommand.execute(argument);
    }

    public void averageDis(String argument){
        averageOfDiscountCommand.execute(argument);
    }

    public boolean groupCount(String argument){
        return groupCountingCommand.execute(argument);
    }

    public boolean print(String argument){
        return printUniqiePersonCommand.execute(argument);
    }
    public List<ICommand> getCommands(){
        return commands;
    }
    /** public String[] getCommandHistory(){
        return commandHistory;
    }



    public void addToHistory(String commandToStore) {

        for (ICommand command : commands) {
            if (command.getName().split(" ")[0].equals(commandToStore)) {
                for (int i = COMMAND_HISTORY_SIZE-1; i>0; i--) {
                    commandHistory[i] = commandHistory[i-1];
                }
                commandHistory[0] = commandToStore;
            }
        }
    }
    public boolean history(String argument) {
        if (historyCommand.execute(argument)) {
            try {
                if (commandHistory.length == 0) throw new EmptyHistoryException();

                Console.println("Last used commands:");
                for (int i=0; i<commandHistory.length; i++) {
                    if (commandHistory[i] != null) Console.println(" " + commandHistory[i]);
                }
                return true;
            } catch (EmptyHistoryException exception) {
                Console.println("No commands have been used");
            }
        }
        return false;
    }
*/
    /**
    public boolean noSuchCommand(String command){
        Console.println("Command '" + command + "' is not found. Print 'help' for list of commands");
        return false;
    }
     */
    @Override
    public String toString() {
        return "CommandManager for working with commands";
    }
}

