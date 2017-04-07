package carlmccann2.distsys.caone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 07/04/2017.
 */
@Entity
@Table(name="playlists")
public class PlaylistEntity implements Serializable {
    @Id
    @Column(name="playlist_id") private Integer playlistId;
    @Column(name="name") private String name;
    @Column(name="master")  private boolean master;
    @Column(name="playlist_persistent_id")  private String playlistPersistentId;
    @Column(name="visible") private boolean visible;
    @Column(name="all_items") private boolean allItems;

    public PlaylistEntity() {
    }

    public PlaylistEntity(Integer playlistId, String name, boolean master,
                          String playlistPersistentId, boolean visible, boolean allItems) {
        this.playlistId = playlistId;
        this.name = name;
        this.master = master;
        this.playlistPersistentId = playlistPersistentId;
        this.visible = visible;
        this.allItems = allItems;
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
}
