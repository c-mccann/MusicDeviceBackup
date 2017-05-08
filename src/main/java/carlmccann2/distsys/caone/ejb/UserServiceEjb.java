package carlmccann2.distsys.caone.ejb;

import carlmccann2.distsys.caone.daos.UserDao;
import carlmccann2.distsys.caone.entities.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
@Stateless
@Local
public class UserServiceEjb implements UserService {
    @EJB
    private UserDao userDao;

    @Override
    public UserEntity getUser(String username, String password) {
        return  userDao.getUser(username, password);
    }

    @Override
    public void addUser(UserEntity userEntity) {
        userDao.addUser(userEntity);
    }

    @Override
    public void updateLibraryPersistentIdForUser(Integer userId, String libraryPersistentId) {
        userDao.updateLibraryPersistentIdForUser(userId, libraryPersistentId);
    }
}
