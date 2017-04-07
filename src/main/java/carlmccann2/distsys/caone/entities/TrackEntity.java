package carlmccann2.distsys.caone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by carlmccann2 on 07/04/2017.
 */
@Entity
@Table(name="tracks")
public class TrackEntity implements Serializable {
    @Id
    @Column(name="track_id")
    private Integer trackId;
    @Column(name="name")    private String name;
    @Column(name="artist")  private String artist;
    @Column(name="album")   private String album;
    @Column(name="genre")   private String genre;
    @Column(name="kind")    private String kind;
    @Column(name="size")    private Integer size;
    @Column(name="total_time")  private Integer totalTime;
    @Column(name="date_modified") private Timestamp dateModified;
    @Column(name="date_added")  private Timestamp dateAdded;
    @Column(name="bit_rate")    private Integer bitRate;
    @Column(name="sample_rate") private Integer sampleRate;
    @Column(name="persistent_id")   private String persistentId;
    @Column(name="track_type")  private String trackType;
    @Column(name="location")    private String location;
    @Column(name="file_folder_count")   private Integer fileFolderCount;
    @Column(name="library_folder_count")    private Integer libraryFolderCount;

    public TrackEntity() {
    }

    public TrackEntity(Integer trackId, String name, String artist, String album, String genre, String kind,
                       Integer size, Integer totalTime, Timestamp dateModified, Timestamp dateAdded, Integer bitRate,
                       Integer sampleRate, String persistentId, String trackType, String location,
                       Integer fileFolderCount, Integer libraryFolderCount) {
        this.trackId = trackId;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.kind = kind;
        this.size = size;
        this.totalTime = totalTime;
        this.dateModified = dateModified;
        this.dateAdded = dateAdded;
        this.bitRate = bitRate;
        this.sampleRate = sampleRate;
        this.persistentId = persistentId;
        this.trackType = trackType;
        this.location = location;
        this.fileFolderCount = fileFolderCount;
        this.libraryFolderCount = libraryFolderCount;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified) {
        this.dateModified = dateModified;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Integer getBitRate() {
        return bitRate;
    }

    public void setBitRate(Integer bitRate) {
        this.bitRate = bitRate;
    }

    public Integer getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(Integer sampleRate) {
        this.sampleRate = sampleRate;
    }

    public String getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(String persistentId) {
        this.persistentId = persistentId;
    }

    public String getTrackType() {
        return trackType;
    }

    public void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getFileFolderCount() {
        return fileFolderCount;
    }

    public void setFileFolderCount(Integer fileFolderCount) {
        this.fileFolderCount = fileFolderCount;
    }

    public Integer getLibraryFolderCount() {
        return libraryFolderCount;
    }

    public void setLibraryFolderCount(Integer libraryFolderCount) {
        this.libraryFolderCount = libraryFolderCount;
    }
}
