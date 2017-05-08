package carlmccann2.distsys.caone.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by carlmccann2 on 17/04/2017.
 */
@Entity
@Table(name="libraries")
public class LibraryEntity implements Serializable {

    @Column(name="major_version")               private Integer majorVersion;
    @Column(name="minor_version")               private Integer minorVersion;
    @Column(name="date")                        private Timestamp date;
    @Column(name="application_version")         private String applicationVersion;
    @Column(name="features")                    private Integer features;
    @Column(name="show_content_ratings")        private Boolean showContentRatings;
    @Column(name="music_folder")                private String musicFolder;
    @Id @Column(name="library_persistent_id") private String libraryPersistentId;

    public LibraryEntity() {
    }

    public LibraryEntity(Integer majorVersion, Integer minorVersion, Timestamp date, String applicationVersion, Integer features, Boolean showContentRatings, String musicFolder, String libraryPersistentId) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.date = date;
        this.applicationVersion = applicationVersion;
        this.features = features;
        this.showContentRatings = showContentRatings;
        this.musicFolder = musicFolder;
        this.libraryPersistentId = libraryPersistentId;
    }

    public Integer getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(Integer majorVersion) {
        this.majorVersion = majorVersion;
    }

    public Integer getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(Integer minorVersion) {
        this.minorVersion = minorVersion;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public Integer getFeatures() {
        return features;
    }

    public void setFeatures(Integer features) {
        this.features = features;
    }

    public Boolean getShowContentRatings() {
        return showContentRatings;
    }

    public void setShowContentRatings(Boolean showContentRatings) {
        this.showContentRatings = showContentRatings;
    }

    public String getMusicFolder() {
        return musicFolder;
    }

    public void setMusicFolder(String musicFolder) {
        this.musicFolder = musicFolder;
    }

    public String getLibraryPersistentId() {
        return libraryPersistentId;
    }

    public void setLibraryPersistentId(String libraryPersistentId) {
        this.libraryPersistentId = libraryPersistentId;
    }

    @Override
    public String toString() {
        return "LibraryEntity{" +
                ", majorVersion=" + majorVersion +
                ", minorVersion=" + minorVersion +
                ", date=" + date +
                ", applicationVersion='" + applicationVersion + '\'' +
                ", features=" + features +
                ", showContentRatings=" + showContentRatings +
                ", musicFolder='" + musicFolder + '\'' +
                ", libraryPersistentId='" + libraryPersistentId + '\'' +
                '}';
    }
}
