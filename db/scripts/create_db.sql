# create tables for musicBackupDevice database
# Thu 6th Apr 2017. examined Itunes Music Library 3.xml. wrote out on paper the DOM/DB/Entity structure

DROP DATABASE musicDeviceBackup;
CREATE DATABASE musicDeviceBackup;
USE musicDeviceBackup;


CREATE TABLE libraries(
  major_version INT,
  minor_version INT,
  date DATETIME,
  application_version VARCHAR(10),
  features INT,
  show_content_ratings BOOL,
  music_folder VARCHAR(200),
  library_persistent_id VARCHAR(20) NOT NULL,

  PRIMARY KEY(library_persistent_id)
);

CREATE TABLE users(
  user_id INT NOT NULL AUTO_INCREMENT,     # equivalent to Library Persistent ID
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  library_persistent_id VARCHAR(20) NOT NULL,

  PRIMARY KEY(user_id),
  FOREIGN KEY(library_persistent_id) REFERENCES libraries(library_persistent_id)
);

CREATE TABLE tracks(
  track_id INT NOT NULL,
  name VARCHAR(100),
  artist VARCHAR(80),
  album VARCHAR(80),
  genre VARCHAR(40),
  kind VARCHAR(40),
  size INT,
  total_time INT,
  date_modified DATETIME,
  date_added DATETIME,
  bit_rate INT,
  sample_rate INT,
  persistent_id VARCHAR(20),
  track_type VARCHAR(20),
  location VARCHAR(300),
  file_folder_count INT,
  library_folder_count INT,
  year INT,
  play_count INT,

  PRIMARY KEY(track_id)
);

CREATE TABLE playlists(
  name VARCHAR(80),
  master BOOL,
  playlist_id INT,
  playlist_persistent_id VARCHAR(20),
  visible BOOL,
  all_items BOOL,
  user_id INT NOT NULL,

  PRIMARY KEY(playlist_id),
  FOREIGN KEY(user_id) REFERENCES users(user_id)

);

CREATE TABLE library_items(
  id INT NOT NULL AUTO_INCREMENT,
  track_id INT NOT NULL,
  library_persistent_id VARCHAR(20) NOT NULL,

  PRIMARY KEY(id),
  FOREIGN KEY(track_id) REFERENCES tracks(track_id),
  FOREIGN KEY(library_persistent_id) REFERENCES libraries(library_persistent_id)
);


CREATE TABLE playlist_items(
  id INT NOT NULL AUTO_INCREMENT,
  track_id INT NOT NULL,
  playlist_id INT NOT NULL,

  PRIMARY KEY(id),
  FOREIGN KEY(playlist_id) REFERENCES playlists(playlist_id),
  FOREIGN KEY(track_id) REFERENCES tracks(track_id)
);


INSERT INTO libraries(library_persistent_id) VALUES("carl");

INSERT INTO users(username,password,library_persistent_id) VALUES('carl','carl','carl');