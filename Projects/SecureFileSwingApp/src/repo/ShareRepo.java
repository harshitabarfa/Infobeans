
package repo;
import model.Share;
import java.util.*;

public class ShareRepo {
    private static final String KEY = "shares";
    private static List<Share> cache = null;

    private static List<Share> all(){
        if(cache==null) cache = JsonStore.loadList(KEY);
        return cache;
    }
    private static void flush(){
        JsonStore.saveList(KEY, all());
    }
    public static void add(Share s){ all().add(s); flush(); }
    public static List<Share> listToUser(String userId){
        List<Share> res = new ArrayList<>();
        for(Share s: all()) if(s.getToUserId().equals(userId)) res.add(s);
        return res;
    }
    public static List<Share> listFromUser(String userId){
        List<Share> res = new ArrayList<>();
        for(Share s: all()) if(s.getFromUserId().equals(userId)) res.add(s);
        return res;
    }
}
