package carlmccann2.distsys.caone.daos;

import carlmccann2.distsys.caone.entities.UserEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
@Stateless
@Local
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public UserEntity getUser(String username, String password) {
        Query query = em.createNamedQuery("getUser");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (UserEntity) query.getSingleResult();
    }

    @Override
    public void addUser(UserEntity userEntity) {
        em.persist(userEntity);
    }

    @Override
    public void updateLibraryPersistentIdForUser(Integer userId, String libraryPersistentId) {
        Query query = em.createNamedQuery("updateLibraryPersistentId");
        query.setParameter("libraryPersistentId",libraryPersistentId);
        query.setParameter("id", userId);
        query.executeUpdate();
    }
}
