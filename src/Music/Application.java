package Music;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {

        String dataFile = System.getProperty("user.dir") + File.separator + "albums.txt";
        File albumsFile = new File(dataFile);
        Scanner fileScanner = new Scanner(albumsFile);
        String data = "";

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            data = data.concat(line).concat("\n");
        }

        ArrayList<Album> albumObjects = new ArrayList<>();
        String[] split = data.split("\\n----------------------------------------------------------------------------------\\r?\\n|\\n----------------------------------------------------------------------------------");
        String[] split1;
        /*splitting the first lines of each album of the text so that the titles info will be seprate and the tracks sperate */
        for (String string : split) {
            String fline = string.substring(0, string.indexOf("\n"));
            String tracks = string.substring(string.indexOf("\n") + 1).concat("--");
            /* storing each of the titles into an array */
            split1 = fline.split(":");
            
            String rank = split1[0];
            String title = split1[1];
            String artist = split1[2];
            String year = split1[3];
            String sales = split1[4];

            String[] split2 = tracks.split("--");
//            String song = split2[0].concat("\n");
            albumObjects.add(new Album(title, artist, year, sales, rank, split2));

        }
        Collections.sort(albumObjects);
        
//        System.out.println(albumObjects.get(0).getRank());

        Scanner choice = new Scanner(System.in);
        boolean quit = true;
        while (quit) {
            System.out.print("\n"
                    + "List albums.............1" + "\n"
                    + "Select albums...........2" + "\n"
                    + "Search song titles......3" + "\n"
                    + "Exit....................0" + "\n" + "\n"
                    + "Enter choice:>");

            String inpt = choice.nextLine();

            switch (inpt) {
                case "0":
                    System.out.println("Exited");
                    quit = false;
                    break;

                case "1":
                    listAlbumsTable();
                    for (int i = 0; i < albumObjects.size(); i++) {
                        String titlesHeader;
                        titlesHeader = String.format("%1s %3s %2s %-45s %6s %-23s %2s %2s %2s %5s %1s ", "|", albumObjects.get(i).getRank(), "|", albumObjects.get(i).getTitle(),
                                "|", albumObjects.get(i).getArtist(), "|", albumObjects.get(i).getYear(), "|", albumObjects.get(i).getSales(), "|");
                        System.out.println(titlesHeader);
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------" + "\n");

                    break;
                case "2":

                    Scanner slecetAlbum = new Scanner(System.in);
                    System.out.print("Enter album rank from list [1 - 20] :>");
                    int selectAlbum = slecetAlbum.nextInt();
                    System.out.println("Album Title :         " + albumObjects.get(selectAlbum - 1).getTitle());
                    System.out.println("Artist :              " + albumObjects.get(selectAlbum - 1).getArtist());
                    System.out.println("Year of release :     " + albumObjects.get(selectAlbum - 1).getYear());
                    System.out.println("Sales to date :       " + albumObjects.get(selectAlbum - 1).getSales());
                    System.out.println("Track List: \n");
                    selectAlbumsTable();
                    System.out.println(albumObjects.get(selectAlbum - 1).toString());

                    break;
                case "3":

                    System.out.print("Enter Search word or phrase > ");
                    Scanner search = new Scanner(System.in);
                    String searchTitle = search.nextLine();
                    int counter = 0;

                    for (int i = 0; i < albumObjects.size(); i++) {
                        String[] songs = albumObjects.get(i).getTracks();

                        for (String track : songs) {
                            String[] splitSongsList = track.split("\n");

                            for (String eachSong : splitSongsList) {
                                String S1 = eachSong.replaceAll("\\)", "");
                                String S2 = S1.replaceAll("\\(", ":");
                                String[] songsSplit = S2.split(":".concat("\n"));
                                counter++;

                                /**
                                 * this if statement checks if the songs has the
                                 * search word it prints out the result even if
                                 * the user searches using small latter or upper
                                 * then it prints out the details of the search
                                 * using the get methods of the albumObjcts *
                                 */
                                if (songsSplit[0].toUpperCase().contains(searchTitle.toLowerCase().toUpperCase())) {
                                    System.out.println("-------" + "\n" + "Artist: " + albumObjects.get(i).getArtist() + "\t" + "Album: " + albumObjects.get(i).getTitle());
                                    System.out.println("Matching song title(s):" + "\n" + "-------");
                                    System.out.println("Track " + counter + "." + songsSplit[0] + "\n" + searchTitle.toUpperCase());
                                }
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /* this class is to print out the layout for the first option which its the list albums (1)*/
    public static void listAlbumsTable() {

        String titlesHeader;
        String bordersHeader;
        titlesHeader = String.format("%1s %1s %1s %-45s %6s %-24s %1s %4s %6s ", "|", "Rank", "|", "Title", "|", "Artist", "|", "Year ", "|" + " Sales " + "|");
        bordersHeader = String.format("--------------------------------------------------------------------------------------------------------");
        System.out.printf(bordersHeader + "\n");
        System.out.printf(titlesHeader + "\n");
        System.out.printf(bordersHeader + "\n");

    }

    /* this class is print out the layout for the second option (2)*/
    public static void selectAlbumsTable() {

        String selectAlbumsHeader;
        String bordersHeader;
        selectAlbumsHeader = String.format("%1s %1s %1s %-35s %6s %-4s %1s %1s %1s  ", "|", "No.", "|", "Title", "|", "Mins", "|", "Secs", "|");
        bordersHeader = String.format("----------------------------------------------------------------");
        System.out.printf(bordersHeader + "\n");
        System.out.printf(selectAlbumsHeader + "\n");
        System.out.printf(bordersHeader + "\n");

    }

}
