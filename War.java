import java.util.ArrayList;
/**
 * The war is huge and terrible and for now is being fought in a very narrow passageway where 
 * only one participant from each army can engage with the each other.
 *
 * @author Kyle Balao
 * @version 4/28/21
 */
public class War
{
    private ArrayList<Creature> goodArmy = new ArrayList<Creature>();
    private ArrayList<Creature> evilArmy = new ArrayList<Creature>();
    
    private Randomizer r = new Randomizer();
    
    
    public War() {
        CreateGoodArmy(575);
        CreateEvilArmy(200);
        Fight();
    }
    
    private void  CreateGoodArmy(int numberOfSoldiers) {
        for (int i = 0; i < numberOfSoldiers; i++) {
            int temp = Randomizer.nextInt(11);
            if (temp < 7) {
                goodArmy.add(new Human());
            } else if (temp < 9){
                goodArmy.add(new Elf());
            }
            else{
                goodArmy.add(new Wizard());
                System.out.println("A wizard has joined battle");
            }
        }   
    }
    
    private void  CreateEvilArmy(int numberOfSoldiers) {
        for (int i = 0; i < numberOfSoldiers; i++) {
            int temp = Randomizer.nextInt(26);
            if (temp < 7) {
                evilArmy.add(new Human());
            } else if (temp < 25) {
                evilArmy.add(new CyberDemon());
            } else {
                evilArmy.add(new Balrog());
                System.out.println("The Balrog has been summoned");
            }
            }
    }   
    
    public void Fight() {
        
        Creature goodWarrior=null;
        Creature evilWarrior=null;
        boolean goodAlive = false;
        boolean evilAlive = false;
        do {
            System.out.println("--------");
            if ((goodWarrior == null) && (goodArmy.size() > 0)) {goodWarrior = goodArmy.remove(0); goodAlive = goodWarrior.isAlive();}
            if ((evilWarrior == null) && (evilArmy.size() > 0)) {evilWarrior = evilArmy.remove(0); evilAlive = evilWarrior.isAlive();}
            while (goodWarrior.isAlive() && evilWarrior.isAlive()){
                evilWarrior.takeDamage(goodWarrior.damage());
                goodWarrior.takeDamage(evilWarrior.damage());
                String s= "\t";
                s += goodWarrior.getClass();
                s += (goodWarrior.isAlive()? " is standing (":" has died (");
                s += ("HP: " + goodWarrior.getHP() + ")");
                s += "\t" + "::" + "\t";
                s += evilWarrior.getClass();
                s += (evilWarrior.isAlive()? " is standing (":" has died (");
                s += ("HP: " + evilWarrior.getHP() + ")");
                System.out.println(s);
            }
            if(goodWarrior.isKnockedOut()) {goodAlive = goodWarrior.isAlive(); goodWarrior = null;}
            if(evilWarrior.isKnockedOut()) {evilAlive = evilWarrior.isAlive(); evilWarrior = null;}
            System.out.println("Good: " + goodArmy.size() + "\t::\t" + "Evil: " + evilArmy.size());
                
        } while ((goodArmy.size() > 0 && evilArmy.size() > 0) || ((goodArmy.size() > 0 && evilAlive) || (evilArmy.size() > 0 && goodAlive)));
        
        if (goodArmy.size() > 0) {
            System.out.println ("-----------------------------");
            System.out.println ("Let us celebrate our victory!"); 
            System.out.println ("-----------------------------");
        } else if (evilArmy.size() > 0) {
            System.out.println("-----------------");
            System.out.println ("All Hope is lost");
            System.out.println("-----------------");
        } else {
            System.out.println("-------------------------");
            System.out.println("The only winner is DEATH!");
            System.out.println("-------------------------");
        }
        
        
    }
    
}
