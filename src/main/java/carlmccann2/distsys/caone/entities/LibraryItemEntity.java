package carlmccann2.distsys.caone.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
@Entity
@Table(name="library_items")
public class LibraryItemEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") private Integer id;
    @Column(name="track_id") private Integer trackId;
    @Column(name="library_persistent_id") private String libraryPersistentId;

    public LibraryItemEntity() {
    }

    public LibraryItemEntity(Integer trackId, String libraryPersistentId) {
        this.trackId = trackId;
        this.libraryPersistentId = libraryPersistentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getLibraryPersistentId() {
        return libraryPersistentId;
    }

    public void setLibraryPersistentId(String libraryPersistentId) {
        this.libraryPersistentId = libraryPersistentId;
    }

    @Override
    public String toString() {
        return "LibraryItemEntity{" +
                "id=" + id +
                ", trackId=" + trackId +
                ", libraryPersistentId=" + libraryPersistentId +
                '}';
    }
}
