
/**
 * Extends from Creature. Has higher HP and strength. 
 * 
 * When doing damage, has a 1/30 chance of dealing Magic damage
 * which triples the damage done.
 * 
 * When taking damage, has a 1/50 chance of casting Healing spell
 * which adds 15 to health.
 * 
 * @author Kyle Balao
 * @version 04/28/21
 */
public class Wizard extends Creature
{
    // instance variables - replace the example below with your own
    private static final int MAX_WIZARD_HP = 70;
    private static final int MIN_WIZARD_HP = 35;
    private static final int MAX_WIZARD_STR = 27;
    private static final int MIN_WIZARD_STR = 10;

    /**
     * Constructor for objects of class WIZARD
     */
    public Wizard()
    {
        super(
            Randomizer.nextInt(MAX_WIZARD_STR-MIN_WIZARD_STR)+MIN_WIZARD_STR,
            Randomizer.nextInt(MAX_WIZARD_HP-MIN_WIZARD_HP)+MIN_WIZARD_HP
        );
          
    }
    
    public int damage() {
           int tempdamage;
           tempdamage = super.damage();
           
           if (Randomizer.nextInt(20)==0) {
               System.err.println("Wizard Powers!");
               tempdamage *=3;              
            }
           
            return tempdamage;
    }
    
    public void takeDamage(int damage)
    {
        super.takeDamage(damage);
        
        if (Randomizer.nextInt(50)==0) {
            super.takeDamage(-15);
            System.err.println("Healing Spell!");
        }
    }
}