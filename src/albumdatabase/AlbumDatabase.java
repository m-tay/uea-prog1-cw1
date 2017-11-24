/*
 * File:        AlbumDatabase.java
 * Created by:  Matthew Taylor
 * Description: Main function, that demonstrates the coursework tasks
 */
package albumdatabase;

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
        
        myAlbums.sortCollection();
        myAlbums.printAlbum();

        
        
        System.out.println("\n\n");
        System.out.println("Task 3: Display total play time of Pink Floyd albums");
        System.out.println("----------------------------------------------------");
        
        // get sub-collection of "Pink Floyd" albums
        AlbumCollection subset = myAlbums.albumSubset("Pink Floyd");
        
        // print subset of albums
        subset.printAlbum();
        
        System.out.println("-----------------------");                          
        // get playtime in seconds
        int playtime = subset.getCollectionDuration();
        System.out.println("Total duration: " + Duration.convertSecsToString(playtime));
        
        
        
        System.out.println("\n\n");
        System.out.println("Task 4: Display album with largest number of tracks");
        System.out.println("---------------------------------------------------");
        
        myAlbums.printAlbum(myAlbums.getAlbumWithMostTracks());
        System.out.println("Number of tracks: " + myAlbums.getAlbumWithMostTracks().getNumOfTracks());
        
        
        
        System.out.println("\n\n");
        System.out.println("Task 5: Display details of longest track in collection");
        System.out.println("------------------------------------------------------");
        Track longestTrack = myAlbums.getLongestTrackInCollection();
        System.out.println("From:\t\t" + longestTrack.album);
        System.out.println("Longest track:\t" + longestTrack);
        
    }
    
}
