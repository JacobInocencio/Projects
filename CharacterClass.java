

/**
 * This class creates a character in the game.
 * It stores character attributes and allows them 
 * to be changed when they are called.
 */
public class Character {

    //Stores the character's name
    private String name;

    //Stores the character's HP
    private int hp;

    //Stores the character's courage
    private int courage;

    //Constructor that sets all attributes
    public Character(String n, int h, int c) {
        name = n;
        hp = h;
        courage = c;
    }

    //Returns the name
    public String getName() {
        return name;
    }

    //Returns the HP
    public int getHp() {
        return hp;
    }

    //Returns the courage
    public int getCourage() {
        return courage;
    }

    //Updates the HP
    public void setHp(int newHp) {
        hp = newHp;
    }

    //Updates the courage
    public void setCourage(int newCourage) {
        courage = newCourage;
    }
}
