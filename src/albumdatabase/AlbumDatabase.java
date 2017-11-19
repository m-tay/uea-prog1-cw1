/*
 * File:        AlbumDatabase.java
 * Created by:  Matthew Taylor
 * Description: Main function, that demonstrates the coursework tasks
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
            System.out.println(myAlbums.albumCollection.get(i));
        }

        
        
        System.out.println("\n\n");
        System.out.println("Task 3: Display total play time of Pink Floyd albums");
        System.out.println("----------------------------------------------------");
        
        // get arraylist of "Pink Floyd" albums
        ArrayList<Album> subset = myAlbums.albumSubset("Pink Floyd");
        
        int playtime = 0;
        
        for(int i = 0; i < subset.size(); i++)
        {
            playtime = playtime + subset.get(i).getAlbumPlaytimeInSeconds();
        }
        
        System.out.println(Duration.convertSecsToString(playtime));
        
        
        
        System.out.println("\n\n");
        System.out.println("Task 4: Display album with largest number of tracks");
        System.out.println("---------------------------------------------------");
        
        System.out.println(myAlbums.getAlbumWithMostTracks());
        
        
        
        System.out.println("\n\n");
        System.out.println("Task 5: Display details of longest track in collection");
        System.out.println("------------------------------------------------------");
        Track longestTrack = myAlbums.getLongestTrackInCollection();
        System.out.println("From:\t\t" + longestTrack.album);
        System.out.println("Longest track:\t" + longestTrack);
        
    }
    
}
