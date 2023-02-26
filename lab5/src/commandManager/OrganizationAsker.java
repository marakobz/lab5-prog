package commandManager;

import exceptions.IncorrectScriptException;
import exceptions.MustBeNotEmptyException;
import exceptions.WrongArgumentException;
import models.Coordinates;
import models.Country;
import models.TicketType;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class OrganizationAsker {
    static private Scanner scanner;
    static private boolean scriptMode = false;
    static private boolean fileMode = false;

    public OrganizationAsker(Scanner scanner) {
        OrganizationAsker.scanner = scanner;
    }

    public void setUserScanner(Scanner userScanner) {
        scanner = userScanner;
    }

    public Scanner getUserScanner() {
        return scanner;
    }

    public static boolean isFileMode() {
        return fileMode;
    }

    public void setFileMode(boolean fileMode) {
        OrganizationAsker.fileMode = fileMode;
    }

    public boolean isScriptMode() {
        return scriptMode;
    }

    public void setScriptMode(boolean b) {
        scriptMode = b;
    }
    public String askName() throws IncorrectScriptException {
        String name;
        if (!isFileMode())
            System.out.println("Enter name of lab: ");
        while (true) {
            try {
                name = scanner.nextLine();
                if (!isFileMode() && isScriptMode())
                    System.out.println(name);
                if (name.equals(""))
                    throw new MustBeNotEmptyException();
                if (name.contains(";"))
                    throw new WrongArgumentException();
                break;
            } catch (MustBeNotEmptyException e) {
                if (!isScriptMode())
                    System.out.println("Name is empty. Try again");
                else throw new IncorrectScriptException();
            } catch (WrongArgumentException e) {
                System.out.println("Name can't have symbol ';'. Try again");
            } catch (NoSuchElementException exception) {
                System.out.println("There is nothing, you are an idiot");
                if (isFileMode())
                    throw new IncorrectScriptException();
                else
                    System.exit(0);
            } catch (Exception e) {
                if (!isScriptMode())
                    System.out.println("Try again and think over about your life decisions, better to regret everything");
                else throw new IncorrectScriptException();
            }
        }
        return name;
    }
    public Coordinates askCoordinates() throws IncorrectScriptException {
        return (new Coordinates(askCoordX(), askCoordY()));
    }

    private Float askCoordX() throws IncorrectScriptException {
        String temp;
        Float x;
        while (true) {
            try {
                if (!isFileMode())
                    System.out.println("Enter coordinate x: ");
                temp = scanner.nextLine().trim();
                if (!isFileMode() && isScriptMode())
                    System.out.println(temp);
                x = Float.parseFloat(temp);
                if (x > -534)
                    throw new WrongArgumentException();
                break;
            } catch (NumberFormatException e) {
                if (!isScriptMode())
                    System.out.println("Incorrect format, try again idiot.");
                else throw new IncorrectScriptException();

            }catch (WrongArgumentException exception) {
                if (!isScriptMode())
                    System.out.println("Max element for this is -534, try again");
                else throw new IncorrectScriptException();
            } catch (NoSuchElementException exception) {
                System.out.println("There is nothing, regret you life decisions");
                if (isFileMode())
                    throw new IncorrectScriptException();
                else
                    System.exit(0);
            } catch (Exception e) {
                if (!isScriptMode())
                    System.out.println("Try again");
                else throw new IncorrectScriptException();
            }
        }
        return x;
    }

    private float askCoordY() throws IncorrectScriptException {
        String temp;
        float y;
        while (true) {
            try {
                if (!isFileMode())
                    System.out.println("Enter coordinate y: ");
                temp = scanner.nextLine().trim();
                if (!isFileMode() && isScriptMode())
                    System.out.println(temp);
                y = Float.parseFloat(temp);
                break;
            } catch (NumberFormatException exception) {
                if (!isScriptMode())
                    System.out.println("Incorrect format, try again idiot");
                else throw new IncorrectScriptException();
            } catch (NoSuchElementException exception) {
                System.out.println("There is nothing, regret you life decisions");
                if (isFileMode())
                    throw new IncorrectScriptException();
                else
                    System.exit(0);
            } catch (Exception exception) {
                if (!isScriptMode())
                    System.out.println("Try again");
                else throw new IncorrectScriptException();
            }
        }
        return y;
    }
    public Float askHeight() throws IncorrectScriptException {
        String temp;
        Float height;
        while (true) {
            try {
                if (!isFileMode())
                    System.out.println("Enter height of a person: ");
                temp = scanner.nextLine().trim();
                if (!isFileMode() && isScriptMode())
                    System.out.println(temp);
                height = Float.parseFloat(temp);
                if (height <= 0)
                    throw new WrongArgumentException();
                break;
            } catch (NumberFormatException e) {
                if (!isScriptMode())
                    System.out.println("Incorrect format, try again");
                else throw new IncorrectScriptException();
            } catch (WrongArgumentException e) {
                if (!isScriptMode())
                    System.out.println("Height has to be more than 0, try again");
                else throw new IncorrectScriptException();
            } catch (NoSuchElementException exception) {
                System.out.println("There is nothing, regret you life decisions");
                if (isFileMode())
                    throw new IncorrectScriptException();
                else
                    System.exit(0);
            } catch (Exception e) {
                if (!isScriptMode())
                    System.out.println("Try again");
                else throw new IncorrectScriptException();
            }
        }
        return height;
    }

    public Float askWeight() throws IncorrectScriptException {
        String temp;
        Float height;
        while (true) {
            try {
                if (!isFileMode())
                    System.out.println("Enter weight of a person: ");
                temp = scanner.nextLine().trim();
                if (!isFileMode() && isScriptMode())
                    System.out.println(temp);
                height = Float.parseFloat(temp);
                if (height <= 0)
                    throw new WrongArgumentException();
                break;
            } catch (NumberFormatException e) {
                if (!isScriptMode())
                    System.out.println("Incorrect format, try again");
                else throw new IncorrectScriptException();
            } catch (WrongArgumentException e) {
                if (!isScriptMode())
                    System.out.println("Weight has to be more than 0, try again");
                else throw new IncorrectScriptException();
            } catch (NoSuchElementException exception) {
                System.out.println("There is nothing, regret you life decisions");
                if (isFileMode())
                    throw new IncorrectScriptException();
                else
                    System.exit(0);
            } catch (Exception e) {
                if (!isScriptMode())
                    System.out.println("Try again");
                else throw new IncorrectScriptException();
            }
        }
        return height;
    }

    public Country askNationality() throws IncorrectScriptException{
        Country nationality;
        String temp;
        while (true) {
            try {
                if (!isFileMode())
                    System.out.println("Choose nationality of a person from the list. \n List:\n" + " RUSSIA\n" + " UK\n" + " USA\n" + " FRANCE\n" + " SPAIN");
                temp = scanner.nextLine().trim();
                if (!isFileMode() && isScriptMode())
                    System.out.println(temp);
                if (temp.equals("")) {
                    throw new MustBeNotEmptyException();
                } else
                    nationality = Country.valueOf(temp.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("There is nothing, regret you life decisions");
                if (isFileMode())
                    throw new IncorrectScriptException();
                else
                    System.exit(0);
            }catch (MustBeNotEmptyException exception) {
                if (!isScriptMode())
                    System.out.println("Nationality can't be an empty element, try again");
                else throw new IncorrectScriptException();
            }catch (IllegalArgumentException e) {
                if (!isScriptMode())
                    System.out.println("Incorrect format, try again");
                else throw new IncorrectScriptException();
            } catch (Exception e) {
                if (!isScriptMode())
                    System.out.println("Try again");
                else throw new IncorrectScriptException();
            }
        }
        return nationality;
    }

    public Date askDate() throws IncorrectScriptException {
        return new Date();
    }

    private TicketType askTicketType() throws IncorrectScriptException{
        TicketType ticketType;
        String temp;
        while (true) {
            try {
                if (!isFileMode())
                    System.out.println("Choose ticket type from the list. \n List:\n" + " VIP\n" + " USUAL\n" + " BUDGETARY\n" + " CHEAP");
                temp = scanner.nextLine().trim();
                if (!isFileMode() && isScriptMode())
                    System.out.println(temp);
                if (temp.equals("")) {
                    throw new MustBeNotEmptyException();
                } else
                    ticketType = TicketType.valueOf(temp.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("There is nothing, regret you life decisions");
                if (isFileMode())
                    throw new IncorrectScriptException();
                else
                    System.exit(0);
            }catch (MustBeNotEmptyException exception) {
                if (!isScriptMode())
                    System.out.println("Ticket type can't be an empty element, try again");
                else throw new IncorrectScriptException();
            }catch (IllegalArgumentException e) {
                if (!isScriptMode())
                    System.out.println("Incorrect format, try again");
                else throw new IncorrectScriptException();
            } catch (Exception e) {
                if (!isScriptMode())
                    System.out.println("Try again");
                else throw new IncorrectScriptException();
            }
        }
        return ticketType;
    }

    @Override
    public String toString(){
        return "Organisation Asker is helper class for human's mad fantasy";
    }
}
