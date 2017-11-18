/*
 * File:        Album.java
 * Created by:  Matthew Taylor
 */

package albumdatabase;

import java.util.*;

public class Album implements Comparable<Album> 
{
    private String albumArtist;
    private String albumTitle;
    private ArrayList<Track> trackList = new ArrayList<Track>();
   
    // constructor
    public Album(String input)
    {
        // split input line into artist / album title strings
        String[] splitInput = input.split(" : ");
        albumArtist = splitInput[0];
        albumTitle = splitInput[1];
    }
   
    public Album()
    {
       albumArtist = "empty album";
    }
   
    public void addTrack(Track newTrack)
    {
       trackList.add(newTrack);
    }
   
   public int compareTo(Album other)
    {
       int artistComparison = albumArtist.compareTo(other.albumArtist);

        // if artists are the same, then sort by title
        if (artistComparison != 0)
           return artistComparison;
        else
           return albumTitle.compareTo(other.albumTitle);
    }   
   
    public String getArtist()
    {
       return albumArtist;
    }
   
    public String getAlbumTitle()
    {
       return albumTitle;
    }
       
    public String toString()
    {
        return albumArtist + " - " + albumTitle;
    }
    
    // returns album playtime in seconds
    public int getAlbumPlaytimeInSeconds()
    {
        int albumDurationInSeconds = 0;
                
        for(int i = 0; i < trackList.size(); i++)
        {
            albumDurationInSeconds += trackList.get(i).trackDurationInSeconds();
        }
        
        return albumDurationInSeconds;
        
    }
    
    public int getNumberOfTracks()
    {
        return trackList.size();
    }
    
    public Track getLongestTrack()
    {
        int trackIndex = 0;
        int duration = 0;
        
        for (int i = 0; i < trackList.size(); i++)
        {
            if (trackList.get(i).trackDurationInSeconds() > duration)
            {
                duration = trackList.get(i).trackDurationInSeconds();
                trackIndex = i;
            }
        }
        
        return trackList.get(trackIndex);
    }
    
}
