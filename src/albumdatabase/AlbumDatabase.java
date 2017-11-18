/*
 * File:        AlbumDatabase.java
 * Created by:  Matthew Taylor
 */
package albumdatabase;

import java.util.Collections;
import java.util.ArrayList;

public class AlbumDatabase 
{

    public static void main(String[] args) 
    {        
        System.out.println("Task 1: Read in AlbumCollection");
        System.out.println("-------------------------------");
                
        AlbumCollection myAlbums = new AlbumCollection();
        myAlbums.readAlbumList();
        System.out.println(" * Completed");
        
        
        
        System.out.println("\n\n");        
        System.out.println("Task 2: Display albums alphabetically");
        System.out.println("-------------------------------------");
        
        Collections.sort(myAlbums.albumCollection);

        for(int i = 0; i < myAlbums.albumCollection.size(); i++)
        {
            System.out.println(myAlbums.albumCollection.get(i).getArtist() + " - " + myAlbums.albumCollection.get(i).getAlbumTitle());
        }

        
        
        
        System.out.println("\n\n");
        System.out.println("Task 3: Display total play time of Pink Floyd albums");
        System.out.println("----------------------------------------------------");
        
        // get arraylist of pink floyd albums
        ArrayList<Album> subset = myAlbums.albumSubset("Pink Floyd");
        
        int playtime = 0;
        
        for(int i = 0; i < subset.size(); i++)
        {
            playtime = playtime + subset.get(i).getAlbumPlaytimeInSeconds();
        }
        
        int hours = playtime / 3600;
        playtime = playtime % 3600;
        int minutes = playtime / 60;
        playtime = playtime % 60;
        int seconds = playtime;
        
        System.out.println("Total playtime is " + hours + ":" + minutes + ":" + seconds);
        
        
        
        System.out.println("\n\n");
        System.out.println("Task 4: Display album with largest number of tracks");
        System.out.println("---------------------------------------------------");
        
        int albumIndex = -1;
        int numTracks = 0;
        
        for(int i = 0; i < myAlbums.albumCollection.size(); i++)
        {
            if(myAlbums.albumCollection.get(i).getNumberOfTracks() > numTracks)
            {
                numTracks = myAlbums.albumCollection.get(i).getNumberOfTracks();
                albumIndex = i;
            }
        }
        
        System.out.println(myAlbums.albumCollection.get(albumIndex).getArtist() + " - " + myAlbums.albumCollection.get(albumIndex).getAlbumTitle());
        
        
        
        System.out.println("\n\n");
        System.out.println("Task 5: Display details of longest track in collection");
        System.out.println("------------------------------------------------------");
        Track longestTrack = myAlbums.getLongestTrackInCollection();
        System.out.println(longestTrack.album.getArtist() + " - " + longestTrack.getTrackTitle() + " (from album: " + longestTrack.album.getAlbumTitle() + ")");
        
        
        
        
    }
    
}
