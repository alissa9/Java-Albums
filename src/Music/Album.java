package Music;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Issa
 */
public class Album implements Comparable<Album> {
//   instance variables 

    String rank;
    String title;
    String artist;
    String year;
    String sales;
    String[] tracks;

/// Constructor for objects of class Album
    public Album(String title, String artist, String year, String sales, String rank, String[] tracks) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.sales = sales;
        this.rank = rank;
        this.tracks = tracks;

    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getYear() {
        return year;
    }

    public String getSales() {
        return sales;
    }

    public String[] getTracks() {

        return tracks;
    }

    public String getRank() {

        return rank;
    }

    @Override
    public int compareTo(Album other) {
//        int Rank = Integer.parseInt(other.getRank());

        if (Integer.parseInt(other.getRank()) > Integer.parseInt(this.getRank())) {
            return -1;
        }
        if (Integer.parseInt(other.getRank()) < Integer.parseInt(this.getRank())) {
            return 1;
        }
        return 0;
    }

    /*  A toString method that return the value given in a string format 
    to return the objects as a string object */
    @Override
    public String toString() {
        int counter = 0;
        String selectAlbumsHeader = ("----------------------------------------------------------------" + "\n");
        for (String track : tracks) {
            String[] split = track.split("\n");
            for (String eachSong : split) {
                String S1 = eachSong.replaceAll("\\)", "");
                String S2 = S1.replaceAll("\\(", ":");
                String[] songsSplit = S2.split(":");
                System.out.println(String.format("%1s %3s %1s %-35s %6s %-4s %1s %1s %3s  ", "|", counter++, "|", songsSplit[0], "|", songsSplit[1], "|", songsSplit[2], "|"));
            }
        }
        return selectAlbumsHeader;
    }

}
