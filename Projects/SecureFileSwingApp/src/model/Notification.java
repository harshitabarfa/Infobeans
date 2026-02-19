
package model;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Notification implements Serializable {
    private String id;
    private String userId;
    private String message;
    private boolean read;
    private long createdAt;

    public Notification(){}
    public Notification(String userId, String message){
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.message = message;
        this.read = false;
        this.createdAt = Instant.now().toEpochMilli();
    }
    public String getId(){return id;}
    public String getUserId(){return userId;}
    public String getMessage(){return message;}
    public boolean isRead(){return read;}
    public long getCreatedAt(){return createdAt;}
    public void setRead(boolean r){this.read=r;}
}
