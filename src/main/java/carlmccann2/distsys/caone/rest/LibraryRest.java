package carlmccann2.distsys.caone.rest;

import carlmccann2.distsys.caone.ejb.TracksService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
@Path("/library.js")
public class LibraryRest {
    @EJB
    TracksService tracksService;

    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/getTracks")
    public List<?> getTracks(){
        return tracksService.getTracks();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/getUserSpecificTracks/{userId}")
    public List<?> getUserSpecificTracks(@PathParam("userId") Integer userId){
        return tracksService.getTracks();
    }
}
