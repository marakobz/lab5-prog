package commandManager;

import exceptions.IncorrectScriptException;
import exceptions.NoFileAccessException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    static int recurs = 0;
    static int recurs_max = 2;
    CommandManager commandManager;
    OrganizationAsker organizationAsker;

    private Scanner scanner;
    private HashSet<String> scriptsInProcess = new HashSet<String>();

    public Console(Scanner scanner, CommandManager commandManager, OrganizationAsker organizationAsker) {
        this.scanner = scanner;
        this.commandManager = commandManager;
        this.organizationAsker = organizationAsker;
    }

    public void interectiveMode() {
        String[] command;
        try {
            while (true) {
                System.out.println("Enter a command: ");
                command = (scanner.nextLine().trim() + " ").split(" ", 2);
                command[1] = command[1].trim();
                runCommand(command);
            }
        } catch (NoSuchElementException e) {
            System.out.println("The end of file has been entered, program is finished");
            System.exit(0);
        } catch (IncorrectScriptException e) {
            System.out.println("Error is happened while trying to read the file");
        }

    }

    public void scriptMode(String argument) {
        String[] command;
        boolean isReadable = true;
        Scanner temp = organizationAsker.getUserScanner();

        try {
            File file = new File(argument);
            if (file.exists() && !file.canRead()) {
                isReadable = false;
                throw new NoFileAccessException();
            }
        } catch (NoFileAccessException e) {
            System.out.println("Do some magic to the file and try again");
        }
        if (isReadable) {
            try (Scanner scriptScanner = new Scanner(new File(argument))) {
                if (!scriptScanner.hasNext()) throw new NoSuchElementException();
                organizationAsker.setUserScanner(scriptScanner);
                organizationAsker.setScriptMode(true);
                do {
                    command = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    command[1] = command[1].trim();
                    while (scriptScanner.hasNextLine() && command[0].isEmpty()) {
                        command = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                        command[1] = command[1].trim();
                    }
                    System.out.println(String.join(" ", command));
                    try {
                        if (scriptsInProcess.contains(command[1]) && command[0].equals("execute_script")) {
                            recurs++;
                        } else if (command[0].equals("execute_script")){
                            scriptsInProcess.add(command[1]);
                            recurs++;
                        }
                        if (command[0].equals("execute_script")) {
                            if (scriptsInProcess.contains(command[1]) && recurs >= recurs_max) {
                                System.out.println("В вашем скрипте присутствует бесконечная рекурсия. Продолжить выполнение? yes/no");
                                try {
                                    Scanner scanner = new Scanner(System.in);
                                    if (scanner.hasNextLine()) {
                                        String line = scanner.nextLine();
                                        if (line.equals("yes"))
                                            recurs = -1000000;
                                        else continue;
                                    }
                                } catch (NoSuchElementException e) {
                                    System.exit(0);
                                }
                            }
                        }
                        runCommand(command);
                    } catch (Error e) {
                        System.out.println("В вашем скрипте присутствует бесконечная рекурсия. Скрипт продолжит выполняться со следующей команды.");
                    }
                } while (scriptScanner.hasNextLine());
            } catch (FileNotFoundException exception) {
                System.out.println("Script file has't found");
            } catch (NoSuchElementException exception) {
                System.out.println("Script file is empty");
            } catch (IncorrectScriptException e) {
                System.out.println("Error in script, script file is closed");
            } catch (Exception e) {
                System.out.println("Error, try again");
            }
        }
        recurs = 0;
        organizationAsker.setUserScanner(temp);
        organizationAsker.setScriptMode(false);
    }

    public void runCommand(String[] userCommand) throws IncorrectScriptException {
        try {
            switch (userCommand[0]) {
                case "update":
                    commandManager.update(userCommand[1]);
                    break;
                case "show":
                    commandManager.show(userCommand[1]);
                    break;
                case "help":
                    commandManager.help(userCommand[1]);
                    break;
                case "info":
                    commandManager.info(userCommand[1]);
                    break;
                case "add element":
                    commandManager.addElement(userCommand[1]);
                    break;
                case "remove by id":
                    commandManager.remove(userCommand[1]);
                    break;
                case "clear":
                    commandManager.clear(userCommand[1]);
                    break;
                case "head":
                    commandManager.head(userCommand[1]);
                    break;
                case "add min element":
                    commandManager.addmin(userCommand[1]);
                    break;
                case "average discount":
                    commandManager.averageDis(userCommand[1]);
                    break;
                case "group count":
                    commandManager.groupCount(userCommand[1]);
                    break;
                case "save":
                    commandManager.save(userCommand[1]);
                    break;
                case "execute_script":
                    commandManager.executeScipt(userCommand[1]);
                    break;
                case "exit":
                    commandManager.exit(userCommand[1]);
                    break;
                case "removeGreater":
                    commandManager.removeGreater(userCommand[1]);
                    break;
                case "print":
                    commandManager.print(userCommand[1]);
                    break;
                default:
                    System.out.println("Try to enter a command again ot enter a 'help' command for list of usable commands");
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println("Error, have no idea how did it happen");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Console class is for executing your fucking program";
    }
}
