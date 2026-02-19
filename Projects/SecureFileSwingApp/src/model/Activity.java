
package model;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Activity implements Serializable {
    private String id;
    private String userId;
    private String action;
    private long ts;

    public Activity(){}
    public Activity(String userId, String action){
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.action = action;
        this.ts = Instant.now().toEpochMilli();
    }
    public String getId(){return id;}
    public String getUserId(){return userId;}
    public String getAction(){return action;}
    public long getTs(){return ts;}
}
