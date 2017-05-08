package carlmccann2.distsys.caone.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlmccann2 on 07/05/2017.
 */

@Stateless
@Local
public class XmlFileListerServiceEjb implements XmlFileListerService {
    @Override
    public List<String> getAllFilenames() {
        System.out.println("in files/getAll (Rest) -> XmlFileListerServiceEjb.getAll()");
        String directory = "/Volumes/Data/Users/carlmccann2/IdeaProjects/MusicDeviceBackup/res";

        List<String> filenames = new ArrayList<>();
        File[] files = new File(directory).listFiles();
        if(files.length > 0){
            for(File file: files){
                filenames.add(file.getName());
            }
        }
        return filenames;
    }
}
