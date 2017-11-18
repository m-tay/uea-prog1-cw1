/*
 * File:        Duration.java
 * Created by:  Matthew Taylor
 */

package albumdatabase;

public class Track 
{
    private String trackTitle;
    private Duration duration;
    public Album album; // holds public reference back to album containing track
    
    // default constructor
    public Track()
    {
        
    }
    
    // constructor
    public Track(String title, Duration dur, Album containingAlbum)
    {
        trackTitle = title;
        duration = dur;
        album = containingAlbum;
    }
    
    public int trackDurationInSeconds()
    {
        return duration.getDurationInSeconds();
    }
    
    public String toString()
    {
        return trackTitle;
    }
    
    
    
}
