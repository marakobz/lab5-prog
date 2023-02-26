package commandManager;

import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Queue;
import models.Ticket;

public class CollectionManager {
    private Queue<Ticket> collection = new PriorityQueue<Ticket>();
    private LocalDateTime creationDate;
    private CSVReader csvReader;

    public CollectionManager(CSVReader csvReader){
        this.creationDate = null;
        this.csvReader = csvReader;
    }

    public Queue<Ticket> getCollection(){
        return collection;
    }

    public LocalDateTime getTime(){
        return creationDate;
    }

    public String collectionType(){
        return collection.getClass().getName();
    }

    public int collectionSize(){
        return collection.size();
    }

   public Ticket getFirst(){
        if (collection.isEmpty()) return null;
        return collection.peek();
    }

    public Ticket getLast(){
        if(collection.isEmpty()) return null;
        return collection.poll();
    }

    public Ticket getById(int id) {
        for (Ticket element : collection) {
            if (element.getId() == id) return element;
        }
        return null;
    }

    public void addToCollection(Ticket element) {
        collection.add(element);
    }

    public void removeFromCollection(Ticket element) {
        collection.remove(element);
    }

    public void clearCollection() {
        collection.clear();
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) return "There is nothing in collection";
        var last = getLast();

       String info = "";
       for (Ticket ticket : collection){
           info+= ticket;
           if (ticket!= collection.poll()) info += "\n\n";
       }
        return info;
    }

    public void showInfo() {
        System.out.println(
                "Информация о коллекции:"
                        + "  Тип: Priority Queue <Ticket>\n"
                        + "  Дата создания:" + creationDate + " \n"
                        + "  Количество элементов:" + collection.size()
        );
    }

}
