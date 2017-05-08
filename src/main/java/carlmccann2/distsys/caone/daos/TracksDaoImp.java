package carlmccann2.distsys.caone.daos;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
@Stateless
@Local
public class TracksDaoImp implements TracksDao {
    @PersistenceContext
    EntityManager em;
    @Override
    public List<?> getTracks() {
        Query query = em.createNamedQuery("getTracks");
        return query.getResultList();
    }

    @Override
    public List<?> getUserSpecificTracks(Integer userId) {
//        Query query = em.createQuery("FROM UserEntity as u INNER JOIN LibraryItemEntity AS l " +
//                "ON u.libraryPersistentId = l.libraryPersistentId left JOIN TrackEntity as t on l.trackId = t.trackId " +
//        "WHERE u.id=:id")
        Query query = em.createQuery("FROM PlaylistItemEntity ");
//                .setParameter("id", userId);
        return query.getResultList();

    }
}
