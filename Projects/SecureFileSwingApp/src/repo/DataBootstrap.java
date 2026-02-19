
package repo;
import model.User;

public class DataBootstrap {
    public static void ensureBootstrap(){
        JsonStore.baseDir(); // create folders
        // create default admin if missing
        boolean hasAdmin = UserRepo.list().stream().anyMatch(u -> u.getUsername().equalsIgnoreCase("admin"));
        if(!hasAdmin){
            User admin = new User("admin","admin123","ADMIN");
            UserRepo.add(admin);
        }
    }
}
