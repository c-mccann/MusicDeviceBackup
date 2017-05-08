package carlmccann2.distsys.caone.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by carlmccann2 on 07/04/2017.
 */
@NamedQueries({
        @NamedQuery(name="getTracks", query="FROM TrackEntity"),
})

@Entity
@Table(name="tracks")
public class TrackEntity implements Serializable {
    @Id @Column(name="track_id")            private Integer trackId;
    @Column(name="name")                    private String name;
    @Column(name="artist")                  private String artist;
    @Column(name="album")                   private String album;
    @Column(name="genre")                   private String genre;
    @Column(name="kind")                    private String kindKind;
    @Column(name="size")                    private Integer sizeSize;
    @Column(name="total_time")              private Integer totalTime;
    @Column(name="date_modified")           private Timestamp dateModified;
    @Column(name="date_added")              private Timestamp dateAdded;
    @Column(name="bit_rate")                private Integer bitRate;
    @Column(name="sample_rate")             private Integer sampleRate;
    @Column(name="persistent_id")           private String persistentId;
    @Column(name="track_type")              private String trackType;
    @Column(name="location")                private String locationLocation;
    @Column(name="file_folder_count")       private Integer fileFolderCount;
    @Column(name="library_folder_count")    private Integer libraryFolderCount;
    @Column(name="year")                    private Integer year;
    @Column(name="play_count")              private Integer playCount;

    public TrackEntity() {
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public TrackEntity(Integer trackId, String name, String artist, String album, String genre, String kindKind,
                       Integer sizeSize, Integer totalTime, Timestamp dateModified, Timestamp dateAdded, Integer bitRate,
                       Integer sampleRate, String persistentId, String trackType, String locationLocation,
                       Integer fileFolderCount, Integer libraryFolderCount, Integer year, Integer playCount) {
        this.trackId = trackId;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.kindKind = kindKind;
        this.sizeSize = sizeSize;
        this.totalTime = totalTime;
        this.dateModified = dateModified;
        this.dateAdded = dateAdded;
        this.bitRate = bitRate;
        this.sampleRate = sampleRate;
        this.persistentId = persistentId;
        this.trackType = trackType;
        this.locationLocation = locationLocation;
        this.fileFolderCount = fileFolderCount;
        this.libraryFolderCount = libraryFolderCount;
        this.year = year;
        this.playCount = playCount;
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

    public String getKindKind() {
        return kindKind;
    }

    public void setKindKind(String kindKind) {
        this.kindKind = kindKind;
    }

    public Integer getSizeSize() {
        return sizeSize;
    }

    public void setSizeSize(Integer sizeSize) {
        this.sizeSize = sizeSize;
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

    public String getLocationLocation() {
        return locationLocation;
    }

    public void setLocationLocation(String locationLocation) {
        this.locationLocation = locationLocation;
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

    @Override
    public String toString() {
        return "TrackEntity{" +
                "trackId=" + trackId +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", genre='" + genre + '\'' +
                ", kind='" + kindKind + '\'' +
                ", size=" + sizeSize +
                ", totalTime=" + totalTime +
                ", dateModified=" + dateModified +
                ", dateAdded=" + dateAdded +
                ", bitRate=" + bitRate +
                ", sampleRate=" + sampleRate +
                ", persistentId='" + persistentId + '\'' +
                ", trackType='" + trackType + '\'' +
                ", location='" + locationLocation + '\'' +
                ", fileFolderCount=" + fileFolderCount +
                ", libraryFolderCount=" + libraryFolderCount +
                ", year=" + year +
                ", playCount=" + playCount +
                '}';
    }
}
