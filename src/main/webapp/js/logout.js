/**
 * Created by carlmccann2 on 07/05/2017.
 */

function logout(){
    $.ajax({
        type: "post",
        url: "/music-device-backup-1.0/UserSessionServlet",
        success: function () {
            alert("success");
            window.location.replace("/music-device-backup-1.0/");


        },
        error: function () {
            alert("failure");
        }
    });
}