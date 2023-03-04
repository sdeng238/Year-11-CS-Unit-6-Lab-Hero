import java.sql.SQLOutput;
import java.util.Random;

public class Hero {
    String name;
    int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void attack(Hero opponent)
    {
        Random rand = new Random();
        double randomNum = rand.nextDouble();
        if(randomNum < 0.5)
        {
            opponent.setHitPoints(opponent.getHitPoints() - 10);
        }
        else if(randomNum >= 0.5)
        {
            hitPoints = hitPoints - 10;
        }
    }

    public void senzuBean()
    {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent)
    {
        while(hitPoints > 0 && opponent.getHitPoints() > 0)
        {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent)
    {
        senzuBean();
        opponent.senzuBean();

        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "         " + opponent.getName() + ": " + opponent.getHitPoints();
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n)
    {
        int[] numOfWins = new int[2];


        for(int num = 0; num < n; num++)
        {
            fightUntilTheDeathHelper(opponent);
            if(hitPoints == 0)
            {
                numOfWins[1]++;
            }
            else if(opponent.getHitPoints() == 0)
            {
                numOfWins[0]++;
            }

            senzuBean();
            opponent.senzuBean();
        }

        return numOfWins;
    }

    public String nFightsToTheDeath(Hero opponent, int n)
    {
        String winString = "";

        int[] numOfWins = nFightsToTheDeathHelper(opponent, n);

        if(numOfWins[0] > numOfWins[1])
        {
            winString = name + " wins!";
        }
        else if(numOfWins[0] < numOfWins[1])
        {
            winString = opponent.getName() + " wins!";
        }
        else
        {
            winString = "OMG! It was actually a draw!";
        }

        return name + ": " + numOfWins[0] + " wins\n" + opponent.getName() + ": " + numOfWins[1] + " wins\n" + winString;
    }

//    public void dramaticFightToTheDeath(Hero opponent)
//    {
//        while(hitPoints > 0 && opponent.getHitPoints() > 0)
//        {
//            attack(opponent);
//            System.out.println(name + ": " + hitPoints + "         " + opponent.getName() + ": " + opponent.getHitPoints() + "\n");
//        }
//
//        if(opponent.getHitPoints() == 0 && hitPoints != 0)
//        {
//            System.out.println(name + " wins!");
//        }
//        else if(hitPoints == 0 && opponent.getHitPoints() != 0)
//        {
//            System.out.println(opponent.getName() + " wins!");
//        }
//        else if(hitPoints == 0 && opponent.getHitPoints() == 0)
//        {
//            System.out.println("OMG! It was actually a draw!");
//        }
//    }
}
