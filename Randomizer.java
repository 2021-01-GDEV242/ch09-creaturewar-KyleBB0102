import java.util.Random;

/**
 * A static utility class Singleton that maps random number generation 
 * from the range 0..limit -1
 * to the range 1..limit
 * 
 * @author Kyle Balao
 * @version 04/28/21
 */
public class Randomizer
{
    private static Random rand;
    /**
     * Constructor for objects of class Randomizer
     */
    public Randomizer()
    {
        rand = new Random();
    }

    /**
     * Creates a random integer like a dice
     * 
     * @return integer
     */
    public static int nextInt(int y)
    {
        return rand.nextInt(y);
    }
}
