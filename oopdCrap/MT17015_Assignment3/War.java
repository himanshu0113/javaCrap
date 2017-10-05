import java.util.*;

class Rock{
  private int strength;
  private String name;
  private Random rand;

  public Rock()
  {
    this.name = "rock";
    this.rand = new Random();
    this.setstrength();
  }
  private void setstrength()
  {
    this.strength = rand.nextInt(100);
  }
  public int getstrength()
  {
    return this.strength;
  }
  public String getname()
  {
    return this.name;
  }

  private int compare(int s1, int s2)
  {
    if(s1==s2)
      return 0;
    else if(s1>s2)
      return 1;
    else
      return 2;
  }
  public int battle(Object w)
  {
    if(Rock.class.isInstance(w))
    {
      int s1 = this.strength;
      int s2 = ((Rock)w).getstrength();

      return compare(s1,s2);
    }
    else if(Paper.class.isInstance(w))
    {
      int s1 = this.strength/2;
      int s2 = ((Paper)w).getstrength()*2;

      return compare(s1,s2);
    }
    else    //scissors
    {
      int s1 = this.strength*2;
      int s2 = ((Scissors)w).getstrength()/2;

      return compare(s1,s2);
    }
  }
}

class Paper{
  int strength;
  String name;
  private Random rand;

  public Paper()
  {
    this.name = "paper";
    this.rand = new Random();
    this.setstrength();
  }
  public void setstrength()
  {
    this.strength = rand.nextInt(100);
  }
  public int getstrength()
  {
    return this.strength;
  }
  public String getname()
  {
    return this.name;
  }

  private int compare(int s1, int s2)
  {
    if(s1==s2)
      return 0;
    else if(s1>s2)
      return 1;
    else
      return 2;
  }
  public int battle(Object w)
  {
    if(Paper.class.isInstance(w))
    {
      int s1 = this.strength;
      int s2 = ((Paper)w).getstrength();

      return compare(s1,s2);
    }
    else if(Rock.class.isInstance(w))
    {
      int s1 = this.strength*2;
      int s2 = ((Rock)w).getstrength()/2;

      return compare(s1,s2);
    }
    else    //scissors
    {
      int s1 = this.strength/2;
      int s2 = ((Scissors)w).getstrength()*2;

      return compare(s1,s2);
    }
  }
}

class Scissors{
  int strength;
  String name;
  private Random rand;

  public Scissors()
  {
    this.name = "scissors";
    this.rand = new Random();
    this.setstrength();
  }
  public void setstrength()
  {
    this.strength = rand.nextInt(100);
  }
  public int getstrength()
  {
    return this.strength;
  }
  public String getname()
  {
    return this.name;
  }

  private int compare(int s1, int s2)
  {
    if(s1==s2)
      return 0;
    else if(s1>s2)
      return 1;
    else
      return 2;
  }
  public int battle(Object w)
  {
    if(Scissors.class.isInstance(w))
    {
      int s1 = this.strength;
      int s2 = ((Scissors)w).getstrength();

      return compare(s1,s2);
    }
    else if(Paper.class.isInstance(w))
    {
      int s1 = this.strength*2;
      int s2 = ((Paper)w).getstrength()/2;

      return compare(s1,s2);
    }
    else    //Rock
    {
      int s1 = this.strength/2;
      int s2 = ((Rock)w).getstrength()*2;

      return compare(s1,s2);
    }
  }
}

class Team{
  Rock r;
  Paper p;
  Scissors s;
  int points;
  HashMap<Integer,Object> weapon;

  public Team()
  {
    r = new Rock();
    p = new Paper();
    s = new Scissors();
    points = 0;
    weapon = new HashMap<Integer,Object>();
    weapon.put(0, r);
    weapon.put(1, p);
    weapon.put(2, s);
  }

  public Object selectWeapon()
  {
    Random rand = new Random();
    return weapon.get(rand.nextInt(3));
  }
}

public class War{
  Team t1, t2;

  public War()
  {
    t1 = new Team();
    t2 = new Team();
  }

  public int battle(Object w1, Object w2)
  {
    if(Rock.class.isInstance(w1))
      return ((Rock)w1).battle(w2);
    else if(Paper.class.isInstance(w1))
      return ((Paper)w1).battle(w2);
    else
      return ((Scissors)w1).battle(w2);

  }

  public static void main(String[] args) {
    War war = new War();
    int winner = 0, winner1 = 0, winner2 = 0;
    for(int i=0; i<20; i++)
    {
      Random rand = new Random();
      Object w1 = war.t1.selectWeapon();
      Object w2 = war.t2.selectWeapon();
      for(int j=0; j<3; j++)
      {
        //System.out.println(w1);
        //System.out.println(w2);
        winner = war.battle(w1,w2);
        if(winner == 1)
          winner1++;
        else if(winner == 2)
          winner2++;
      }
      if(winner1>winner2)
        war.t1.points++;
      else if(winner1<winner2)
        war.t2.points++;
    }

    System.out.println("Team 1: " + war.t1.points);
    System.out.println("Team 2: " + war.t2.points);
  }
}
