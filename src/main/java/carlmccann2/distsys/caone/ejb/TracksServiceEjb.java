package carlmccann2.distsys.caone.ejb;

import carlmccann2.distsys.caone.daos.TracksDao;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
@Stateless
@Local
public class TracksServiceEjb implements TracksService {
    @EJB
    TracksDao tracksDao;

    @Override
    public List<?> getTracks() {
        return tracksDao.getTracks();
    }

    @Override
    public List<?> getUserSpecificTracks(Integer userId) {
        return tracksDao.getUserSpecificTracks(userId);
    }
}
