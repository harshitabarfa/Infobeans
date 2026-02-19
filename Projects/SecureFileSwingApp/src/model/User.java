
package model;
import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private String role; // "ADMIN" or "USER"

    public User() {}
    public User(String username, String password, String role) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public String getId(){return id;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public String getRole(){return role;}
    public void setId(String id){this.id=id;}
    public void setUsername(String u){this.username=u;}
    public void setPassword(String p){this.password=p;}
    public void setRole(String r){this.role=r;}
}
