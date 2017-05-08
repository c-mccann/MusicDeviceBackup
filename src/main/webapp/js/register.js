/**
 * Created by carlmccann2 on 07/05/2017.
 */

function register() {
    alert('register');

    var username = $("#usernameInput").val();
    var password = $("#passwordInput").val();

    if(username && password){
        var libraryPersistentId = "carl";
        var user = new User(username, password, libraryPersistentId);

        $.ajax({
            type: "POST",
            url: "MusicDeviceBackup/user",
            success: function(){
                alert("User Added");
            },
            error: function () {
                alert("User creation failure");
            },
            data: JSON.stringify(user),
            contentType: "application/json"
        });

    }



}