/**
 * Created by carlmccann2 on 07/05/2017.
 */
$( document ).ready(function() {
    $.ajax({
        type: "get",
        url: "/music-device-backup-1.0/UserSessionServlet",
        success: function (data) {
            if(data){
                var user = JSON.parse(data);
                // alert("username: " + user.username);
            }
            else{
                // alert("No one logged in");
            }


        },
        error: function () {
            alert("failure");
        }
    });
});