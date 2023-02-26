package commandManager;

import commandManager.commands.History;
import models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.PriorityQueue;

public class CSVReader {
    String command, dataName;
    String[] values, historyData;
    PriorityQueue<Ticket> ticket;
    PriorityQueue<History> history;
    File base;
    Ticket number;
    SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
    public CSVReader() throws IOException{
        ticket = new PriorityQueue<>();
        history = new PriorityQueue<>();
        dataName = "test.csv";
        base = new File(dataName);

        try {
            BufferedReader reader = new BufferedReader((new FileReader(dataName)));
            String line;
            while((line = reader.readLine()) != null){
                int index = line.lastIndexOf(';');
                if (index == -1){
                    System.err.println("File is empty");
                } else {
                    values = line.split(";");
                    int id = Integer.parseInt(values[0]);
                    String name = values[1];
                    Float x = Float.parseFloat(values[2]);
                    float y = Float.parseFloat(values[3]);
                    var coordinates = new Coordinates(x, y);
                    int price = Integer.parseInt(values[4]);
                    long discount = Long.parseLong(values[5]);
                    boolean refund = Boolean.getBoolean(values[6]);
                    TicketType type = TicketType.valueOf(values[7]);
                    Date birthday = parser.parse(values[8]);
                    Float height = Float.parseFloat(values[9]);
                    Float weight = Float.parseFloat(values[10]);
                    Country nationality = Country.valueOf(values[11]);
                    var  person = new Person(birthday, height, weight, nationality);
                    LocalDate creationDate = LocalDate.parse(values[13]);
                    var ticket = new Ticket(id, name, coordinates, creationDate, price, discount, refund, type, person);

                    //ticket.add(new )
                }
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

       /** try {
            BufferedReader reader = new BufferedReader(new FileReader("history.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                int index = line.lastIndexOf(';');
                if (index == -1) {
                    System.err.println("Файл с историей пустой");
                } else {
                    historyData = line.split(";");
                    String whatAct = historyData[1];

                    history.add(new History(whatAct));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }



}
