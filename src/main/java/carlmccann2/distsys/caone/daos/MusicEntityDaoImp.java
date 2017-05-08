package carlmccann2.distsys.caone.daos;

import carlmccann2.distsys.caone.entities.LibraryEntity;
import carlmccann2.distsys.caone.entities.LibraryItemEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
@Stateless
@Local
public class MusicEntityDaoImp implements MusicEntityDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public void persistAll(List<Object> entities) {
        boolean first = true;
        String libraryPersistentId = null;

        for(Object entity: entities){
            if(first){
                libraryPersistentId = ((LibraryEntity) entity).getLibraryPersistentId();
                first = false;
            }
            System.out.println("Ultimo: ");
            System.out.println(entity.getClass().getName());

            if (entity.getClass().getName().equals("carlmccann2.distsys.caone.entities.LibraryItemEntity")){
                ((LibraryItemEntity) entity).setLibraryPersistentId(libraryPersistentId);
            }
            em.persist(entity);
        }
    }
}
