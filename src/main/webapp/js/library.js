/**
 * Created by carlmccann2 on 07/05/2017.
 */
$( document ).ready(function() {
    $.ajax({
        type: "GET",
        url: "MusicDeviceBackup/files/getAll", // XmlFileListerRest.getAll()
        success: function (data) {
            // fill the combobox
            var filenameArray = data.toString().split(',');

            var fileSelector = document.getElementById('fileSelector');

            for (var i = 0; i < filenameArray.length; i++){

                if(filenameArray[i] !== ".DS_Store"){
                    var option = document.createElement('option');
                    option.innerHTML = filenameArray[i];
                    fileSelector.appendChild(option);
                }
            }
        },
        error: function () {
            alert("failure filling combo box");
        }
    });
});

function persistFile(){
    var fileSelector = document.getElementById('fileSelector');
    var filename = fileSelector.options[fileSelector.selectedIndex].text;
    var userId = "";

    $.get('/music-device-backup-1.0/UserSessionServlet', function (data) {
        if (data) {
            userId = data.toString().split(',')[0].split(':')[1];
            $.ajax({
                type: "POST",
                url: "MusicDeviceBackup/files/persist/" + filename + "/" + userId,
                success: function () {
                    alert("Success: persistFile in library.js");

                },
                error: function () {
                    alert("Error: persistFile in library.js");
                }
            });
        }
    });



}

function loadData(){
    $.ajax({
        type: "GET",
        url: "MusicDeviceBackup/library/getTracks",
        success: function (data) {
            $.each(data, function (index,value) {
                var row = document.createElement('tr');
                row.setAttribute('align','center');

                var trackId = document.createElement('td');
                var name = document.createElement('td');
                var artist = document.createElement('td');
                var album = document.createElement('td');
                var genre = document.createElement('td');
                var kind = document.createElement('td');
                var size = document.createElement('td');
                var totalTime = document.createElement('td');
                var dateModified = document.createElement('td');
                var dateAdded = document.createElement('td');
                var bitRate = document.createElement('td');
                var sampleRate = document.createElement('td');
                var persistentId = document.createElement('td');
                var trackType = document.createElement('td');
                var locationLocation = document.createElement('td');
                var fileFolderCount = document.createElement('td');
                var libraryFolderCount = document.createElement('td');
                var year = document.createElement('td');
                var playCount = document.createElement('td');

                trackId.innerHTML = value.trackId;
                name.innerHTML = value.name;
                artist.innerHTML = value.artist;
                album.innerHTML = value.album;
                genre.innerHTML = value.genre;
                kind.innerHTML = value.kindKind;

                var sizeInMb = parseInt(value.sizeSize);
                sizeInMb = sizeInMb / 1024 / 1024;


                size.innerHTML = sizeInMb.toPrecision(3) + "Mb";

                var ms = parseInt(value.totalTime);
                ms = 1000*Math.round(ms/1000); // round to nearest second
                var d = new Date(ms);
                var seconds = String(d.getUTCSeconds());
                if(seconds.length === 1){
                    seconds += '0';
                }
                totalTime.innerHTML = d.getUTCMinutes() + ':' + seconds;

                dateModified.innerHTML = Date(value.dateModified).toString().substr(0, Date(value.dateModified).toString().length - 15);


                dateAdded.innerHTML = Date(value.dateAdded).toString().substr(0, Date(value.dateAdded).toString().length - 15);
                bitRate.innerHTML = value.bitRate;
                sampleRate.innerHTML = value.sampleRate;
                persistentId.innerHTML = value.persistentId;
                trackType.innerHTML = value.trackType;
                locationLocation.innerHTML = value.locationLocation;
                fileFolderCount.innerHTML = value.fileFolderCount;
                libraryFolderCount.innerHTML = value.libraryFolderCount;
                year.innerHTML = value.year;
                playCount.innerHTML = value.playCount;


                row.appendChild(trackId);
                row.appendChild(name);
                row.appendChild(artist);
                row.appendChild(album);
                row.appendChild(genre);
                row.appendChild(kind);
                row.appendChild(size);
                row.appendChild(totalTime);
                row.appendChild(dateModified);
                row.appendChild(dateAdded);
                row.appendChild(bitRate);
                row.appendChild(sampleRate);
                // row.appendChild(persistentId);
                // row.appendChild(trackType);
                // row.appendChild(locationLocation);
                // row.appendChild(fileFolderCount);
                // row.appendChild(libraryFolderCount);
                row.appendChild(year);
                row.appendChild(playCount);

                document.getElementById('libraryTableBody').appendChild(row);


            });
            document.getElementById('libraryTable').style.display = 'block';
        },
        error: function () {
            alert("Error: loadData in library.js");
        }
    });
}

function showHideTracks(){
    var table = document.getElementById('libraryTable');
    if(table.style.display === 'none') table.style.display = 'block';
    else table.style.display = 'none';
}