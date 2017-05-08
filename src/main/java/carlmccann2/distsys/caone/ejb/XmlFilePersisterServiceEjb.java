package carlmccann2.distsys.caone.ejb;

import carlmccann2.distsys.caone.SimpleXMLParser;
import carlmccann2.distsys.caone.daos.MusicEntityDao;
import carlmccann2.distsys.caone.daos.UserDao;
import carlmccann2.distsys.caone.entities.LibraryEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Scanner;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
@Stateless
@Local
public class XmlFilePersisterServiceEjb implements XmlFilePersisterService{
    @EJB
    MusicEntityDao musicEntityDao;
    @EJB
    UserDao userDao;
    @Override
    public void persistFile(String filename, Integer userId) {
        SimpleXMLParser simpleXMLParser = new SimpleXMLParser();
        List<Object> toBePersisted = simpleXMLParser.parse(filename, userId);

        System.out.println("updating lib pers id");
        musicEntityDao.persistAll(toBePersisted);
        userDao.updateLibraryPersistentIdForUser(userId, ((LibraryEntity) toBePersisted.get(0)).getLibraryPersistentId());

    }
}
