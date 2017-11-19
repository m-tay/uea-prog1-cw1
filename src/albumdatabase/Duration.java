/*
 * File:        Duration.java
 * Created by:  Matthew Taylor
 * Description: Holds the duration of a particular track, provides methods
                to get durations in seconds for adding durations and converting
                them back to hh:mm:ss
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

    // converts seconds input into an hh:mm:ss format for ease of reading
    public static String convertSecsToString(int secondsIn)
    {
        int hours = secondsIn / 3600;
        secondsIn = secondsIn % 3600;
        int minutes = secondsIn / 60;
        secondsIn = secondsIn % 60;
        int seconds = secondsIn;
        
        return hours + ":" + minutes + ":" + seconds;
    }
    
}
