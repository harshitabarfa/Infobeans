
package model;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class FileItem implements Serializable {
    private String id;
    private String ownerUserId;
    private String originalName;
    private String storedPath;
    private long size;
    private long uploadedAt;

    public FileItem(){}
    public FileItem(String ownerUserId, String originalName, String storedPath, long size){
        this.id = UUID.randomUUID().toString();
        this.ownerUserId = ownerUserId;
        this.originalName = originalName;
        this.storedPath = storedPath;
        this.size = size;
        this.uploadedAt = Instant.now().toEpochMilli();
    }
    public String getId(){return id;}
    public String getOwnerUserId(){return ownerUserId;}
    public String getOriginalName(){return originalName;}
    public String getStoredPath(){return storedPath;}
    public long getSize(){return size;}
    public long getUploadedAt(){return uploadedAt;}
}
