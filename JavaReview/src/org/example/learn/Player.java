package org.example.learn;

import java.util.ArrayList;

/**
 * Created by point on 1/21/2016.
 */
public class Player {

    private String handleName;
    private int lives;
    private int level;
    private int score;
    private Weapon weapon;
    private ArrayList<InventoryItem> inventoryItems;

    // Default constructors are a thing
    public Player(){
        setHandleName("speg");
        setLives(1);
        setLevel(1);
        setScore(0);
        setDefaultWeapon();
        InventoryItems = new ArrayList<InventoryItem>();
    }

    // Sorcery
    public Player(String handleName){
        // Call default
        this();
        setHandleName(handleName);
    }

    // More than one constructor, wheee
    public Player(String handleName, int lives, int level, int score){
        super();
        setHandleName(handleName);
        setLives(lives);
        setLevel(level);
        setScore(score);
        setDefaultWeapon();
    }

    private void setDefaultWeapon(){
        this.weapon = new Weapon("Rusty Dagger", 1, 20);
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        // Handle names should be at least 4 chars
        if (handleName.length() >= 4){
            return;
        }
        this.handleName = handleName;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}

