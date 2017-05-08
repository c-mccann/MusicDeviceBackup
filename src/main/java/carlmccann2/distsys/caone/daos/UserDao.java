package carlmccann2.distsys.caone.daos;

import carlmccann2.distsys.caone.entities.UserEntity;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
public interface UserDao {
    UserEntity getUser(String username, String password);
    void addUser(UserEntity userEntity);
    void updateLibraryPersistentIdForUser(Integer userId, String libraryPersistentId);
}
