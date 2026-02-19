
package repo;
import model.Activity;
import java.util.*;

public class ActivityRepo {
    private static final String KEY = "activities";
    private static List<Activity> cache = null;

    private static List<Activity> all(){
        if(cache==null) cache = JsonStore.loadList(KEY);
        return cache;
    }
    private static void flush(){
        JsonStore.saveList(KEY, all());
    }
    public static void add(Activity a){ all().add(a); flush(); }
    public static List<Activity> listForUser(String userId){
        List<Activity> res = new ArrayList<>();
        for(Activity a: all()) if(a.getUserId().equals(userId)) res.add(a);
        return res;
    }
    public static List<Activity> listAll(){ return new ArrayList<>(all()); }
}
