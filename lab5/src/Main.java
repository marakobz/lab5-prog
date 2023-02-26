import commandManager.*;
import commandManager.commands.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = System.getenv("envVariable");

        Scanner userScanner = new Scanner(System.in);
        final String envVariable = path;


        var organizationAsker = new OrganizationAsker(userScanner);
        var csvReader = new CSVReader();
        var collectionManager = new CollectionManager(csvReader);
        var commandManager = new CommandManager(
                new HelpCommand(),
                new InfoCommand(collectionManager),
                new ShowCommand(collectionManager),
                new AddElementCommand(collectionManager, organizationAsker),
                new UpdateCommand(collectionManager, organizationAsker),
                new SaveCommand(collectionManager),
                new ExecuteScriptCommand(collectionManager),
                new ExitCommand(collectionManager),
                new HeadCommand(collectionManager),
                new AddIfMinCommand(collectionManager, organizationAsker),
                new RemoveGreaterCommand(collectionManager,organizationAsker),
                new AverageOfDiscountCommand(collectionManager),
                new GroupCountingCommand(collectionManager),
                new RemoveByIdCommand(collectionManager),
                new PrintUniqiePersonCommand(collectionManager));

        var console = new Console(userScanner, commandManager, organizationAsker);
        console.interectiveMode();
    }


}
