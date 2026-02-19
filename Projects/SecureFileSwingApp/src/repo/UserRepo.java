
package repo;
import model.User;
import java.util.*;

public class UserRepo {
    private static final String KEY = "users";
    private static List<User> cache = null;

    private static List<User> all(){
        if(cache==null) cache = JsonStore.loadList(KEY);
        return cache;
    }
    private static void flush(){
        JsonStore.saveList(KEY, all());
    }
    public static Optional<User> findByUsername(String username){
        return all().stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst();
    }
    public static Optional<User> findById(String id){
        return all().stream().filter(u -> u.getId().equals(id)).findFirst();
    }
    public static List<User> list(){ return new ArrayList<>(all()); }
    public static void add(User u){
        all().add(u);
        flush();
    }
}
