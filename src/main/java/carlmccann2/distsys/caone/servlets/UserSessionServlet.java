package carlmccann2.distsys.caone.servlets;

/**
 * Created by carlmccann2 on 06/05/2017.
 */


import carlmccann2.distsys.caone.ejb.UserService;
import carlmccann2.distsys.caone.entities.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;

public class UserSessionServlet extends HttpServlet{
    HttpSession session;

    @EJB
    UserService userService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        log("servlet time");

        if(session.getAttribute("userEntity") == null){ //login.js
            System.out.println("login.js");
            String username = request.getParameter("username");
            String password = request.getParameter("password");


            //TODO: full stack needed to fetch user.js from db with username and password and store in session.js
            UserEntity userEntity = null;

            try{
                userEntity = userService.getUser(username, password);
                session.setAttribute("userEntity", userEntity);
                response.sendRedirect("library.js.html");
            }
            catch (Exception e){
                response.sendRedirect("index.html");
            }
        }
        else{                                               //logout.js
            session.removeAttribute("userEntity");
            System.out.println("logout.js");
            response.sendRedirect("library.js.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");
            if(userEntity != null){
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");

                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(userEntity);
                response.getWriter().print(json);
            }
        }
        catch(NullPointerException e){

        }
    }
}
