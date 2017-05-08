package carlmccann2.distsys.caone.rest;

import carlmccann2.distsys.caone.ejb.UserService;
import carlmccann2.distsys.caone.entities.UserEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by carlmccann2 on 07/05/2017.
 */
@Path("/user.js")
public class UserRest {
    @EJB
    UserService userService;

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/{username}/{password}")
    public UserEntity getUser(@PathParam("username") String username, @PathParam("password") String password){
        return userService.getUser(username, password);
    }

    @POST @Consumes(MediaType.APPLICATION_JSON)
        public void addUser(UserEntity userEntity){
        userService.addUser(userEntity);
    }

    @PUT @Consumes(MediaType.APPLICATION_JSON) @Path("/updateLibraryPersistentId/{userId}/{libPersId}")
    public void updateLibraryPersistentIdForUser(@PathParam("userId") Integer userId, @PathParam("libPersId")String libraryPersistentId){
            userService.updateLibraryPersistentIdForUser(userId, libraryPersistentId);
    }


}
