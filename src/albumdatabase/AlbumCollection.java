/*
 * File:        AlbumCollection.java
 * Created by:  Matthew Taylor
 * Description: Stores a set of albums, has methods for reading files and operations
                that affect the whole album collection
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
    public AlbumCollection albumSubset(String artist)
    {
        AlbumCollection subset = new AlbumCollection();
        
        // for each album in the collection
        for(int i = 0; i < albumCollection.size(); i++)
        {
            // if the album artist matches the string we're looking for
            if(albumCollection.get(i).getArtist().equals(artist))
            {
                subset.albumCollection.add(albumCollection.get(i));
            }
        }
        
        return subset; 
    }
    
    public Track getLongestTrackInCollection()
    {
        Track longestTrack = new Track();
        int duration = 0;
        
        // loop through each album in collection
        for (int i = 0; i < albumCollection.size(); i++)
        {
            // for each album, get the longest track
            Track currentTrack = albumCollection.get(i).getLongestTrack();
            
            // if longest track duration is longer than prev. found, save Track
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
    
    public int getCollectionDuration()
    {
        int playtime = 0;
        
        for(int i = 0; i < albumCollection.size(); i++)
        {
            playtime = playtime + albumCollection.get(i).getAlbumPlaytimeInSeconds();
        }
        
        return playtime;
    };
    
    
    public void sortCollection()
    {
        Collections.sort(albumCollection);
    }
    
    // prints all albums from collection
    public void printAlbum()
    {
        System.out.printf("%-30s %-30s\n", "Artist", "Title");
        System.out.println("-------------------------------------------------------------");
        for(int i = 0; i < albumCollection.size(); i++)
        {
            System.out.printf("%-30s %-30s\n", albumCollection.get(i).getArtist(), albumCollection.get(i).getAlbumTitle());
        }
    }

    // prints individual album passed to it
    public void printAlbum(Album album)
    {
        System.out.printf("%-30s %-30s\n", "Artist", "Title");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-30s %-30s\n", album.getArtist(), album.getAlbumTitle());
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
