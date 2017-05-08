package carlmccann2.distsys.caone.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 07/04/2017.
 */
@Entity
@Table(name="playlists")
public class PlaylistEntity implements Serializable {
    @Column(name="name") private String name;
    @Column(name="master")  private boolean master;
    @Id
    @Column(name="playlist_id") private Integer playlistId;
    @Column(name="playlist_persistent_id")  private String playlistPersistentId;
    @Column(name="visible") private boolean visible;
    @Column(name="all_items") private boolean allItems;
    @Column(name="user_id") private Integer userId;

    public PlaylistEntity() {
    }

    public PlaylistEntity(Integer playlistId, String name, boolean master,
                          String playlistPersistentId, boolean visible, boolean allItems, Integer userId) {
        this.playlistId = playlistId;
        this.name = name;
        this.master = master;
        this.playlistPersistentId = playlistPersistentId;
        this.visible = visible;
        this.allItems = allItems;
        this.userId = userId;
    }

    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public String getPlaylistPersistentId() {
        return playlistPersistentId;
    }

    public void setPlaylistPersistentId(String playlistPersistentId) {
        this.playlistPersistentId = playlistPersistentId;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isAllItems() {
        return allItems;
    }

    public void setAllItems(boolean allItems) {
        this.allItems = allItems;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PlaylistEntity{" +
                "name='" + name + '\'' +
                ", master=" + master +
                ", playlistId=" + playlistId +
                ", playlistPersistentId='" + playlistPersistentId + '\'' +
                ", visible=" + visible +
                ", allItems=" + allItems +
                ", userId=" + userId +
                '}';
    }
}
