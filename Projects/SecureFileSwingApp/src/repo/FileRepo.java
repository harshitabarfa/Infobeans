
package repo;
import model.FileItem;
import java.util.*;

public class FileRepo {
    private static final String KEY = "files";
    private static List<FileItem> cache = null;

    private static List<FileItem> all(){
        if(cache==null) cache = JsonStore.loadList(KEY);
        return cache;
    }
    private static void flush(){
        JsonStore.saveList(KEY, all());
    }
    public static List<FileItem> listByOwner(String ownerId){
        List<FileItem> res = new ArrayList<>();
        for(FileItem f: all()) if(f.getOwnerUserId().equals(ownerId)) res.add(f);
        return res;
    }
    public static Optional<FileItem> findById(String id){
        return all().stream().filter(f -> f.getId().equals(id)).findFirst();
    }
    public static void add(FileItem f){
        all().add(f);
        flush();
    }
    public static List<FileItem> listAll(){ return new ArrayList<>(all()); }
}
