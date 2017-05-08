package carlmccann2.distsys.caone.ejb;

import carlmccann2.distsys.caone.entities.UserEntity;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
public interface UserService {
    UserEntity getUser(String username, String password);
    void addUser(UserEntity userEntity);
    void updateLibraryPersistentIdForUser(Integer userId, String libraryPersistentId);

}
