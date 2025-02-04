package datavault.server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Files")  // This maps to a "files" table in the DB
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //TODO: make an specific ID for each file?
    private Long id;
    @Column(unique = true, nullable = false)  // Ensure fileId is unique
    private String fileId;

    @Column(nullable = false)
    private String hash;

    // Constructors
    public FileEntity() {}
    public FileEntity(String fileId, String hash) {
        this.fileId = fileId;
        this.hash = hash;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
