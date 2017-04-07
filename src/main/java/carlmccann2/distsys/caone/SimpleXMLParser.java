package carlmccann2.distsys.caone;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by carlmccann2 on 06/04/2017.
 */

public class SimpleXMLParser {
    public void parse(String path) {
        System.out.println("Parsing xml: " + path + "\n");

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
            System.out.println("Root: " + root.getNodeName());
            System.out.println("No of children nodes: " + root.getChildNodes().getLength());
            System.out.println();

            //
            Node outer_Dict = root.getFirstChild();
            System.out.println("Only Child: " + outer_Dict.getNodeName());
            System.out.println("No of children nodes: " + outer_Dict.getChildNodes().getLength());
            System.out.println();

            //
            NodeList backupKeyValueList = outer_Dict.getChildNodes();

            for (int i = 0; i < backupKeyValueList.getLength() ; i+=2) {


                Node keyNode = backupKeyValueList.item(i).getFirstChild();
                Node valueNode = backupKeyValueList.item(i+1).getFirstChild();
                System.out.println("key: " + keyNode.getNodeValue());


                if(keyNode.getNodeValue().equals("Show Content Ratings")){
                    // this is the wrapper tag around the value usually but true is a single tag
                    System.out.println("value: " +  backupKeyValueList.item(i+1).getNodeName());
                }


                else if(keyNode.getNodeValue().equals("Tracks")){

                    System.out.println("value: dict"); // because it is
                    NodeList tracksKeyValueList = backupKeyValueList.item(i+1).getChildNodes();


                    for (int j = 0; j < tracksKeyValueList.getLength(); j+= 2) {
                        Node trackKeyNode = tracksKeyValueList.item(j).getFirstChild();
                        NodeList trackValueNodeList = tracksKeyValueList.item(j+1).getChildNodes();
                        System.out.println("\t\t\t\tTrack key: " + trackKeyNode.getNodeValue());
                        // see because it is above similar situation
                        System.out.println("\t\t\t\tTrack value: " + tracksKeyValueList.item(j+1).getNodeName());


                        for (int k = 0; k < trackValueNodeList.getLength(); k+=2) {
                            Node kNode = trackValueNodeList.item(k).getFirstChild();
                            Node vNode = trackValueNodeList.item(k+1).getFirstChild();
                            System.out.println("\t\t\t\t\t\t\t\t\t\tkNode: " + kNode.getNodeValue());


                            if(kNode.getNodeValue().equals("Compilation") || kNode.getNodeValue().equals("Purchased")
                                    || kNode.getNodeValue().equals("Album Rating Computed")
                                    || kNode.getNodeValue().equals("Has Video") || kNode.getNodeValue().equals("HD")
                                    || kNode.getNodeValue().equals("Disabled")
                                    || kNode.getNodeValue().equals("Explicit")
                                    || kNode.getNodeValue().equals("Music Video")
                                    || kNode.getNodeValue().equals("Protected")){

                                System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + trackValueNodeList.item(k+1).getNodeName());
                            }else{
                                System.out.println("\t\t\t\t\t\t\t\t\t\tvNode: " + vNode.getNodeValue());
                            }
                        }
                    }
                }

                else if(keyNode.getNodeValue().equals("Playlists")){

                    System.out.println("value: " + backupKeyValueList.item(i+1).getNodeName());
                    NodeList playlistArrayList = backupKeyValueList.item(i+1).getChildNodes();
                    for (int j = 0; j < playlistArrayList.getLength(); j++) { // not +=2 this time as it is an array
                        Node playlistDictNode = playlistArrayList.item(j);
                        System.out.println("playlist: " + playlistDictNode.getNodeName());
                        NodeList playlistKeyValueList = playlistDictNode.getChildNodes();
                        for (int k = 0; k < playlistKeyValueList.getLength(); k+=2) {
                            Node pkNode = playlistKeyValueList.item(k).getFirstChild();
                            Node pvNode = playlistKeyValueList.item(k+1).getFirstChild();
                            System.out.println("\t\t\t\tplay k: " + pkNode.getNodeValue());

                            if(pkNode.getNodeValue().equals("Master") || pkNode.getNodeValue().equals("Visible")
                                    || pkNode.getNodeValue().equals("Music")
                                    || pkNode.getNodeValue().equals("Movies")
                                    || pkNode.getNodeValue().equals("TV Shows")
                                    || pkNode.getNodeValue().equals("Podcasts")
                                    || pkNode.getNodeValue().equals("Audiobooks")
                                    || pkNode.getNodeValue().equals("Purchased Music")
                                    || pkNode.getNodeValue().equals("Party Shuffle")
                                    || pkNode.getNodeValue().equals("All Items")){

                                System.out.println("\t\t\t\tplay v: " + playlistKeyValueList.item(k+1).getNodeName());
                            }
                            else if(pkNode.getNodeValue().equals("Playlist Items")){

                                System.out.println("\t\t\t\tplay v: " + playlistKeyValueList.item(k+1).getNodeName());

                                Node playlistItemsArray = playlistKeyValueList.item(k+1);
                                NodeList playlistItemDictList = playlistItemsArray.getChildNodes();
                                for (int l = 0; l < playlistItemDictList.getLength(); l++) {
                                    Node tupleKeyNode = playlistItemDictList.item(l).getFirstChild();
                                    Node tupleValueNode  = playlistItemDictList.item(l).getLastChild();

                                    System.out.println("\t\t\t\t\t\t\t\t\t\ttuple key: " + tupleKeyNode.getFirstChild().getNodeValue());
                                    System.out.println("\t\t\t\t\t\t\t\t\t\ttuple value: " + tupleValueNode.getFirstChild().getNodeValue());
                                }
                            }
                            else{
                                System.out.println("\t\t\t\tplay v: " + pvNode.getNodeValue());
                            }

                        }
                    }
                }

                else{
                    System.out.println("value: " + valueNode.getNodeValue());
                }
            }

            //

            // end of new new code




        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Badly Formed XML! Could not parse!");
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        String path = "res/iTunes Music Library1.xml";
        SimpleXMLParser sxp = new SimpleXMLParser();
        sxp.parse(path);
    }
}
