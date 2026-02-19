
package repo;
import model.Notification;
import java.util.*;

public class NotificationRepo {
    private static final String KEY = "notifications";
    private static List<Notification> cache = null;

    private static List<Notification> all(){
        if(cache==null) cache = JsonStore.loadList(KEY);
        return cache;
    }
    private static void flush(){
        JsonStore.saveList(KEY, all());
    }
    public static void add(Notification n){ all().add(n); flush(); }
    public static List<Notification> listForUser(String userId){
        List<Notification> res = new ArrayList<>();
        for(Notification n: all()) if(n.getUserId().equals(userId)) res.add(n);
        return res;
    }
    public static void markRead(String id){
        for(Notification n: all()) if(n.getId().equals(id)) n.setRead(true);
        flush();
    }
    public static void delete(String id){
        all().removeIf(n -> n.getId().equals(id));
        flush();
    }
}
