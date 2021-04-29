
/**
 * demonic creature
 *
 * @author Kyle Balao
 * @version 04/28/21
 */
public class Balrog extends Demon
{
    
    
    // instance variables - replace the example below with your own
    private static final int MAX_BALROG_HP = 200;
    private static final int MIN_BALROG_HP = 80;
    private static final int MAX_BALROG_STR = 100;
    private static final int MIN_BALROG_STR = 50;
public Balrog()
    {
        super(
            Randomizer.nextInt(MAX_BALROG_STR-MIN_BALROG_STR)+MIN_BALROG_STR,
            Randomizer.nextInt(MAX_BALROG_HP-MIN_BALROG_HP)+MIN_BALROG_HP
        );
          
    }
    
    public int damage() {

            return super.damage() + super.damage();
    }
}
