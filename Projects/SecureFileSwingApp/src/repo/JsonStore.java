
package repo;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class JsonStore {
    private static final String BASE = "app_data";

    public static Path baseDir(){
        Path p = Paths.get(BASE);
        try { Files.createDirectories(p.resolve("storage")); } catch(Exception ignored){}
        return p;
    }

    public static <T> void saveList(String name, List<T> list) {
        Path p = baseDir().resolve(name + ".ser");
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(p))){
            oos.writeObject(list);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> loadList(String name){
        Path p = baseDir().resolve(name + ".ser");
        if(!Files.exists(p)) return new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(p))){
            return (List<T>) ois.readObject();
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
