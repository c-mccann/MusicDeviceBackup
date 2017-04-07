package carlmccann2.distsys.caone.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 07/04/2017.
 */
@Entity
@Table(name="playlist_items")
public class PlaylistItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")  private Integer id;
    @Column(name="track_id")    private Integer trackId;
    @Column(name="playlist_id") private Integer playlistId;

    public PlaylistItemEntity() {
    }

    public PlaylistItemEntity(Integer trackId, Integer playlistId) {
        this.trackId = trackId;
        this.playlistId = playlistId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }
}
