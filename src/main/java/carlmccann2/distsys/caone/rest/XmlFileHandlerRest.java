package carlmccann2.distsys.caone.rest;

import carlmccann2.distsys.caone.ejb.XmlFileListerService;
import carlmccann2.distsys.caone.ejb.XmlFilePersisterService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlmccann2 on 07/05/2017.
 */

@Path("/files")
public class XmlFileHandlerRest {
    @EJB
    XmlFileListerService xmlFileListerService;
    @EJB
    XmlFilePersisterService xmlFilePersisterService;


    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/getAll")
    public List<String> getAll(){
        return xmlFileListerService.getAllFilenames();

    }

    @POST @Path("/persist/{filename}/{userId}")
    public void persistFile(@PathParam("filename") String filename, @PathParam("userId") Integer userId){
        xmlFilePersisterService.persistFile(filename, userId);
    }
}
