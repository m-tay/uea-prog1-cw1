/*
 * File:        AlbumCollection.java
 * Created by:  Matthew Taylor
 */
package albumdatabase;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

public class AlbumCollection 
{
    ArrayList<Album> albumCollection = new ArrayList<Album>();
    
    public void readAlbumList()
    {
        // create empty reference to be used later
        Album album = new Album();
        
        try
        {
            // create a buffered file reader
            File inFile = new File("albums.txt");
            FileReader fileReader = new FileReader(inFile);
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line = null;
            
            // get next line from buffer until EOF reached
            while ((line = reader.readLine()) != null)
            {
                
                // if line doesn't start with 0, it is artist / album title line
                if(line.charAt(0) != '0')
                {                    
                    album = new Album(line);
                    albumCollection.add(album);
                }
                
                // ... otherwise, add track to current album
                else
                {
                    // split duration and track title from line
                    String[] splitLine = line.split(" - ");
                                        
                    Duration duration = new Duration(splitLine[0]);
                    String trackTitle = splitLine[1];
                    
                    Track newTrack = new Track(trackTitle, duration, album);
                    album.addTrack(newTrack);
                }
            }
            
            // close buffered file reader when done!
            reader.close();
        }
        catch (Exception exception)
        {
            System.out.println("Error reading file");
            exception.printStackTrace();
        }
    };

    // returns arraylist of albums where the artist matches the artist string
    public ArrayList<Album> albumSubset(String artist)
    {
        ArrayList<Album> subset = new ArrayList<Album>();
        
        // for each album in the collection
        for(int i = 0; i < this.albumCollection.size(); i++)
        {
            if(this.albumCollection.get(i).getArtist().equals(artist))
            {
                subset.add(this.albumCollection.get(i));
            }
        }
        
        return subset; 
    }
    
    public Track getLongestTrackInCollection()
    {
        Track longestTrack = new Track();
        int duration = 0;
        
        for (int i = 0; i < albumCollection.size(); i++)
        {
            Track currentTrack = albumCollection.get(i).getLongestTrack();
            if (currentTrack.trackDurationInSeconds() > duration)
            {
                duration = currentTrack.trackDurationInSeconds();
                longestTrack = currentTrack;
            }
        }
        
        return longestTrack;
    }
    
    public Album getAlbumWithMostTracks()
    {
        int albumIndex = -1;
        int numTracks = 0;
        
        // loop through album collection
        for(int i = 0; i < albumCollection.size(); i++)
        {
            // if number of tracks is greater than previous album
            if(albumCollection.get(i).getNumberOfTracks() > numTracks)
            {
                // save number of tracks found
                numTracks = albumCollection.get(i).getNumberOfTracks();
                
                // store index of largest album (so it can be retrieved later)
                albumIndex = i;
            }
        }
        
        return albumCollection.get(albumIndex);
    }
    
    
    
    // test harness
    public static void main(String[] args) 
    {
    
    // test creating AlbumCollection
    System.out.println("Program starting...");
    AlbumCollection myAlbums = new AlbumCollection();

    myAlbums.readAlbumList();
    System.out.println("Album list read (hopefully)...");
        
    // test printing Album ollection
    for(int i = 0; i < myAlbums.albumCollection.size(); i++)
    {
        System.out.println(myAlbums.albumCollection.get(i).getArtist());
    }
    
    // test sorting and printing AlbumCollection
    System.out.println("Sorted list: ");
      
    Collections.sort(myAlbums.albumCollection);

    for(int i = 0; i < myAlbums.albumCollection.size(); i++)
    {
        System.out.println(myAlbums.albumCollection.get(i).getArtist());
    }

    }
    
    
}
