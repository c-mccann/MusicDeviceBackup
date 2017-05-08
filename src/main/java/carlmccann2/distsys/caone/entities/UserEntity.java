package carlmccann2.distsys.caone.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 17/04/2017.
 */

@NamedQueries({
        @NamedQuery(name="updateLibraryPersistentId", query ="UPDATE UserEntity as u SET libraryPersistentId =:libraryPersistentId WHERE u.id=:id"),
        @NamedQuery(name="getUser", query = "from UserEntity user where user.username = :username and user.password= :password")
})


@Entity
@Table(name="users")
public class UserEntity implements Serializable {
    @Id @Column(name="user_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="username")                private String username;
    @Column(name="password")                private String password;
    @Column(name="library_persistent_id")   private String libraryPersistentId;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String libraryPersistentId) {
        this.username = username;
        this.password = password;
        this.libraryPersistentId = libraryPersistentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLibraryPersistentId() {
        return libraryPersistentId;
    }

    public void setLibraryPersistentId(String libraryPersistentId) {
        this.libraryPersistentId = libraryPersistentId;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", libraryPersistentId='" + libraryPersistentId + '\'' +
                '}';
    }
}
