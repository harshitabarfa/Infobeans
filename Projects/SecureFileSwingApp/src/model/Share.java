
package model;
import java.io.Serializable;
import java.util.UUID;

public class Share implements Serializable {
    private String id;
    private String fileId;
    private String toUserId;
    private String fromUserId;

    public Share(){}
    public Share(String fileId, String toUserId, String fromUserId){
        this.id = UUID.randomUUID().toString();
        this.fileId = fileId;
        this.toUserId = toUserId;
        this.fromUserId = fromUserId;
    }
    public String getId(){return id;}
    public String getFileId(){return fileId;}
    public String getToUserId(){return toUserId;}
    public String getFromUserId(){return fromUserId;}
}
