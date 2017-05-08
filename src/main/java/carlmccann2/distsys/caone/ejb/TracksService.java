package carlmccann2.distsys.caone.ejb;

import java.util.List;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
public interface TracksService {
    List<?> getTracks();
    List<?> getUserSpecificTracks(Integer userId);

}
