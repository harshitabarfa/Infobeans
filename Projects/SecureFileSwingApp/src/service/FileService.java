
package service;
import repo.FileRepo;
import repo.ShareRepo;
import repo.NotificationRepo;
import repo.ActivityRepo;
import repo.JsonStore;
import model.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class FileService {
    public List<FileItem> myFiles(String userId){
        return FileRepo.listByOwner(userId);
    }
    public Optional<FileItem> upload(String userId, File srcFile) throws IOException {
        Path storageDir = JsonStore.baseDir().resolve("storage");
        Files.createDirectories(storageDir);
        Path dest = storageDir.resolve(System.currentTimeMillis() + "_" + srcFile.getName());
        Files.copy(srcFile.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
        FileItem item = new FileItem(userId, srcFile.getName(), dest.toString(), srcFile.length());
        FileRepo.add(item);
        ActivityRepo.add(new Activity(userId, "Uploaded: " + srcFile.getName()));
        return Optional.of(item);
    }
    public boolean share(String fromUserId, String toUsername, String fileId){
        java.util.Optional<User> toUser = repo.UserRepo.findByUsername(toUsername);
        java.util.Optional<FileItem> file = FileRepo.findById(fileId);
        if(toUser.isEmpty() || file.isEmpty()) return false;
        ShareRepo.add(new Share(fileId, toUser.get().getId(), fromUserId));
        NotificationRepo.add(new Notification(toUser.get().getId(), "File shared with you: " + file.get().getOriginalName()));
        ActivityRepo.add(new Activity(fromUserId, "Shared file " + file.get().getOriginalName() + " to " + toUsername));
        return true;
    }
    public List<Share> incomingShares(String userId){
        return ShareRepo.listToUser(userId);
    }
}
