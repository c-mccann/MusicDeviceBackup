package carlmccann2.distsys.caone;

import carlmccann2.distsys.caone.entities.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by carlmccann2 on 06/04/2017.
 */

public class SimpleXMLParser {
    public List<Object> parse(String path, Integer userId) {
        path = "/Volumes/Data/Users/carlmccann2/IdeaProjects/MusicDeviceBackup/res/" + path;
        System.out.println("Parsing xml: " + path + "\n");

        List<Object> toBePersisted = new ArrayList<>();


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(path);
            Document doc = builder.parse(file);
            ///////////

            doc.getDocumentElement().normalize();


            // new new code

            // Root
            Node root = doc.getDocumentElement();
//            System.out.println("Root: " + root.getNodeName());
//            System.out.println("No of children nodes: " + root.getChildNodes().getLength());

            //
            Node outer_Dict = root.getFirstChild();
//            System.out.println("Only Child: " + outer_Dict.getNodeName());
//            System.out.println("No of children nodes: " + outer_Dict.getChildNodes().getLength());
//            System.out.println();

            //
            NodeList backupKeyValueList = outer_Dict.getChildNodes();


            LibraryEntity libraryEntity = new LibraryEntity();

            for (int i = 0; i < backupKeyValueList.getLength() ; i+=2) {

                Node keyNode = backupKeyValueList.item(i).getFirstChild();
                Node valueNode = backupKeyValueList.item(i+1).getFirstChild();

                //System.out.println("key: " + keyNode.getNodeValue());

                switch (keyNode.getNodeValue()){
                    case "Major Version":
                        //System.out.println("value: " + valueNode.getNodeValue());
                        libraryEntity.setMajorVersion(Integer.parseInt(valueNode.getNodeValue()));
                        break;

                    case "Minor Version":
                        //System.out.println("value: " + valueNode.getNodeValue());
                        libraryEntity.setMinorVersion(Integer.parseInt(valueNode.getNodeValue()));
                        break;

                    case "Date":
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                        try{
                            Date d = simpleDateFormat.parse(valueNode.getNodeValue());
                            libraryEntity.setDate(new Timestamp(d.getTime()));
                        }
                        catch(ParseException e){}

                    case "Application Version":
                        //System.out.println("value: " + valueNode.getNodeValue());
                        libraryEntity.setApplicationVersion(valueNode.getNodeValue());
                        break;

                    case "Features":
                        //System.out.println("value: " + valueNode.getNodeValue());
                        libraryEntity.setFeatures(Integer.parseInt(valueNode.getNodeValue()));
                        break;

                    case "Show Content Ratings":
                        //System.out.println("value: " + backupKeyValueList.item(i+1).getNodeName());
                        libraryEntity.setShowContentRatings(
                                // this is the wrapper tag around the value usually but true is a single tag
                                Boolean.parseBoolean(backupKeyValueList.item(i+1).getNodeName()));
                        break;

                    case "Music Folder":
                        //System.out.println("value: " + valueNode.getNodeValue());
                        libraryEntity.setMusicFolder(valueNode.getNodeValue());
                        break;

                    case "Library Persistent ID":
                        //System.out.println("value: " + valueNode.getNodeValue());
                        libraryEntity.setLibraryPersistentId(valueNode.getNodeValue());
                        break;

                    case "Tracks":
//                        System.out.println("value: dict"); // because it is
                        toBePersisted.addAll(trackParser(backupKeyValueList.item(i+1).getChildNodes()));
                        break;

                    case "Playlists":
//                        System.out.println("value: " + backupKeyValueList.item(i+1).getNodeName());
                        toBePersisted.addAll(playlistParser(backupKeyValueList.item(i+1).getChildNodes(), userId));

                    default:
//                        System.out.println("value: " + valueNode.getNodeValue());
                        break;
                }

            }
            toBePersisted.add(0,libraryEntity); // insert at beginning to avoid foreign key constraint failures



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Badly Formed XML! Could not parse!");
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toBePersisted;
    }

    public static List<Object> trackParser(NodeList tracksKeyValueList){
        List<Object> tracks = new ArrayList<>();
        List<Object> libraryItems = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");


        for (int j = 0; j < tracksKeyValueList.getLength(); j+= 2) {
            Node trackKeyNode = tracksKeyValueList.item(j).getFirstChild();
            NodeList trackValueNodeList = tracksKeyValueList.item(j+1).getChildNodes();
//            System.out.println("\t\t\t\tTrack key: " + trackKeyNode.getNodeValue());
            // see because it is above similar situation
//            System.out.println("\t\t\t\tTrack value: " + tracksKeyValueList.item(j+1).getNodeName());


            TrackEntity trackEntity = new TrackEntity();


            for (int k = 0; k < trackValueNodeList.getLength(); k+=2) {
                Node kNode = trackValueNodeList.item(k).getFirstChild();
                Node vNode = trackValueNodeList.item(k+1).getFirstChild();
//                System.out.println("\t\t\t\t\t\t\t\t\t\tkNode: " + kNode.getNodeValue());



                switch(kNode.getNodeValue()){
                    case "Track ID":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setTrackId(Integer.parseInt(vNode.getNodeValue()));
                        LibraryItemEntity libraryItemEntity = new LibraryItemEntity();
                        libraryItemEntity.setTrackId(Integer.parseInt(vNode.getNodeValue()));
                        libraryItemEntity.setLibraryPersistentId(libraryItemEntity.getLibraryPersistentId());
                        libraryItems.add(libraryItemEntity);
                        break;

                    case "Name":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setName(vNode.getNodeValue());
                        break;

                    case "Artist":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setArtist(vNode.getNodeValue());
                        break;

                    case "Album":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setAlbum(vNode.getNodeValue());
                        break;

                    case "Genre":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setGenre(vNode.getNodeValue());
                        break;

                    case "Kind":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setKindKind(vNode.getNodeValue());
                        break;

                    case "Size":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setSizeSize(Integer.parseInt(vNode.getNodeValue()));
                        break;

                    case "Total Time":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setTotalTime(Integer.parseInt(vNode.getNodeValue()));
                        break;

                    case "Date Modified":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        try{
                            Date d = simpleDateFormat.parse(vNode.getNodeValue());
                            trackEntity.setDateModified(new Timestamp(d.getTime()));
                        }
                        catch (ParseException e){}

                        break;

                    case "Date Added":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        try{
                            Date d = simpleDateFormat.parse(vNode.getNodeValue());
                            trackEntity.setDateAdded(new Timestamp(d.getTime()));
                        }
                        catch (ParseException e){}
                        break;

                    case "Bit Rate":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setBitRate(Integer.parseInt(vNode.getNodeValue()));
                        break;

                    case "Sample Rate":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setSampleRate(Integer.parseInt(vNode.getNodeValue()));
                        break;

                    case "Persistent ID":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setPersistentId(vNode.getNodeValue());
                        break;

                    case "Track Type":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setTrackType(vNode.getNodeValue());
                        break;

                    case "Location":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setLocationLocation(vNode.getNodeValue());
                        break;

                    case "File Folder Count":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setFileFolderCount(Integer.parseInt(vNode.getNodeValue()));
                        break;

                    case "Library Folder Count":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setLibraryFolderCount(Integer.parseInt(vNode.getNodeValue()));
                        break;

                    case "Year":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setYear(Integer.parseInt(vNode.getNodeValue()));
                        break;

                    case "Play Count":
//                        System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                        trackEntity.setPlayCount(Integer.parseInt(vNode.getNodeValue()));
                        break;


                }

                    // for getting boolean tag value etc.
                  //  System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + trackValueNodeList.item(k+1).getNodeName());

            }
            tracks.add(trackEntity);
        }
        tracks.addAll(libraryItems);
        return tracks;
    }


    public static List<Object> playlistParser(NodeList playlistArrayList, Integer userId){
        List<Object> playlists = new ArrayList<>();
        List<Object> playlistItems = new ArrayList<>();


        for (int j = 0; j < playlistArrayList.getLength(); j++) { // not +=2 this time as it is an array
            Node playlistDictNode = playlistArrayList.item(j);
//            System.out.println("playlist: " + playlistDictNode.getNodeName());
            NodeList playlistKeyValueList = playlistDictNode.getChildNodes();

            PlaylistEntity playlistEntity = new PlaylistEntity();

            for (int k = 0; k < playlistKeyValueList.getLength(); k+=2) {
                Node pkNode = playlistKeyValueList.item(k).getFirstChild();
                Node pvNode = playlistKeyValueList.item(k+1).getFirstChild();
//                System.out.println("\t\t\t\tplay k: " + pkNode.getNodeValue());



                switch(pkNode.getNodeValue()){
                    case "Name":
//                        System.out.println("\t\t\t\tplay v: " + pvNode.getNodeValue());
                        playlistEntity.setName(pvNode.getNodeValue());
                        break;

                    case "Master":
//                        System.out.println("\t\t\t\tplay v: " + playlistKeyValueList.item(k+1).getNodeName());

                        playlistEntity.setMaster(Boolean.parseBoolean(playlistKeyValueList.item(k+1).getNodeName()));
                        break;

                    case "Playlist ID":
//                        System.out.println("\t\t\t\tplay v: " + pvNode.getNodeValue());
                        playlistEntity.setPlaylistId(Integer.parseInt(pvNode.getNodeValue()));
                        break;

                    case "Playlist Persistent ID":
//                        System.out.println("\t\t\t\tplay v: " + pvNode.getNodeValue());
                        playlistEntity.setPlaylistPersistentId(pvNode.getNodeValue());
                        break;

                    case "Visible":
//                        System.out.println("\t\t\t\tplay v: " + playlistKeyValueList.item(k+1).getNodeName());
                        playlistEntity.setVisible(Boolean.parseBoolean(playlistKeyValueList.item(k+1).getNodeName()));
                        break;

                    case "All Items":
//                        System.out.println("\t\t\t\tplay v: " + playlistKeyValueList.item(k+1).getNodeName());
                        playlistEntity.setAllItems(Boolean.parseBoolean(playlistKeyValueList.item(k+1).getNodeName()));
                        break;

                    case "Playlist Items":
//                        System.out.println("\t\t\t\tplay v: " + playlistKeyValueList.item(k+1).getNodeName());
                        Node playlistItemsArray = playlistKeyValueList.item(k+1);
                        NodeList playlistItemDictList = playlistItemsArray.getChildNodes();

                        for (int l = 0; l < playlistItemDictList.getLength(); l++) {
                            PlaylistItemEntity playlistItemEntity = new PlaylistItemEntity();
                            Node tupleKeyNode = playlistItemDictList.item(l).getFirstChild();
                            Node tupleValueNode  = playlistItemDictList.item(l).getLastChild();

//                            System.out.println("\t\t\t\t\t\t\t\t\t\ttuple key: " + tupleKeyNode.getFirstChild().getNodeValue());
//                            System.out.println("\t\t\t\t\t\t\t\t\t\ttuple value: " + tupleValueNode.getFirstChild().getNodeValue());

                            switch(tupleKeyNode.getFirstChild().getNodeValue()){
                                case "Track ID":
                                    playlistItemEntity.setTrackId(Integer.parseInt(tupleValueNode.getFirstChild().getNodeValue()));
                                    playlistItemEntity.setPlaylistId(playlistEntity.getPlaylistId());
                                    playlistItems.add(playlistItemEntity);
                            }

                        }

                        break;


                }

                // TODO: Need to set userId from Session here before it is added to the entity list
                playlistEntity.setUserId(userId);

            }
            playlists.add(playlistEntity);
        }

        playlists.addAll(playlistItems);
        return playlists;
    }


    public static void main(String[] args) {
        String path = "iTunes Music Library1.xml";
        SimpleXMLParser sxp = new SimpleXMLParser();
        sxp.parse(path,3);
    }
}