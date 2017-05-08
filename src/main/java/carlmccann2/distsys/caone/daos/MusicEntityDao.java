package carlmccann2.distsys.caone.daos;

import java.util.List;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
public interface MusicEntityDao {
    void persistAll(List<Object> entities);
}
