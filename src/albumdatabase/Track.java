/*
 * File:        Duration.java
 * Created by:  Matthew Taylor
 * Description: Holds details of tracks (inc. reference back to containing
                album). Provides method to get duration of track.
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
