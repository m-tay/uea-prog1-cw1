/*
 * File:        Duration.java
 * Created by:  Matthew Taylor
 */

package albumdatabase;

public class Duration 
{
    private int hours, minutes, seconds;    
    
    public Duration(String input)
    {
        // split duration into h / m / s
        String[] durationValues = input.split(":");

        // get the values out of duration array
        hours = Integer.parseInt(durationValues[0]);
        minutes = Integer.parseInt(durationValues[1]);
        seconds = Integer.parseInt(durationValues[2]);
    }

    // returns duration in seconds
    public int getDurationInSeconds()
    {
        return seconds + (minutes * 60) + (hours * 60 * 60);
    }

}
