# create tables for musicBackupDevice database
# Thu 6th Apr 2017. examined Itunes Music Library 3.xml. wrote out on paper the DOM/DB/Entity structure
USE musicDeviceBackup;

CREATE TABLE users(
  user_id INT NOT NULL,     # equivalent to Library Persistent ID
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  library_persistent_id VARCHAR(20) NOT NULL,
  PRIMARY KEY(user_id)
);

CREATE TABLE tracks(
  track_id INT NOT NULL,
  name VARCHAR(20),
  artist VARCHAR(20),
  album VARCHAR(20),
  genre VARCHAR(20),
  kind VARCHAR(20),
  size INT,
  total_time INT,
  date_modified DATETIME,
  date_added DATETIME,
  bit_rate INT,
  sample_rate INT,
  persistent_id VARCHAR(20),
  track_type VARCHAR(20),
  location VARCHAR(20),
  file_folder_count INT,
  library_folder_count INT,

  PRIMARY KEY(track_id)
);

CREATE TABLE playlists(
  name VARCHAR(20),
  master BOOL,
  playlist_id INT,
  playlist_persistent_id VARCHAR(20),
  visible BOOL,
  all_items BOOL,

  PRIMARY KEY(playlist_id)
);


CREATE TABLE playlist_items(
  id INT NOT NULL AUTO_INCREMENT,
  track_id INT NOT NULL,
  playlist_id INT NOT NULL,

  PRIMARY KEY(id),
  FOREIGN KEY(playlist_id) REFERENCES playlists(playlist_id),
  FOREIGN KEY(track_id) REFERENCES tracks(track_id)
);
