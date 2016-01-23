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
        this.inventoryItems = new ArrayList<InventoryItem>();
    }

    // Sorcery
    public Player(String handleName){
        // Call default
        this();
        setHandleName(handleName);
    }

    // More than one constructor, wheee
    public Player(String handleName, int lives, int level, int score){
        this();
        setHandleName(handleName);
        setLives(lives);
        setLevel(level);
        setScore(score);
        setDefaultWeapon();
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        // Handle names should be at least 4 chars
        if (handleName.length() <= 4){
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
        if (level <= 0){
            return;
        }
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score <= 0){
            return;
        }
        this.score = score;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon wpn){
        this.weapon = wpn;
    }

    private void setDefaultWeapon(){
        this.weapon = new Weapon("Rusty Dagger", 1, 20);
    }

    public void addInventoryItem(InventoryItem inventoryItem){
        inventoryItems.add(inventoryItem);
    }

    public boolean dropInventoryItem(InventoryItem inventoryItem){
        if (this.inventoryItems.contains(inventoryItem)){
            inventoryItems.remove(inventoryItem);
            return true;
        }
        return false;
    }

    public ArrayList<InventoryItem> getInventoryItems(){
        return inventoryItems;
    }

}



