
package service;
import repo.UserRepo;
import model.User;
import java.util.Optional;

public class AuthService {
    public Optional<User> login(String username, String password){
        return UserRepo.findByUsername(username).filter(u -> u.getPassword().equals(password));
    }
    public boolean signup(String username, String password){
        if(UserRepo.findByUsername(username).isPresent()) return false;
        repo.UserRepo.add(new User(username, password, "USER"));
        return true;
    }
}
