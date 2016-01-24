package org.example.learn;

/**
 * Created by point on 1/22/2016.
 */
public class Enemy {

    private int hitPoints;
    private int damage;
    private int lives;
    private String name;

    public Enemy(){ //No. 1
        setHitPoints(10);
        setLives(1);
        setName("Unremarkable Creep");
    }

    public Enemy(int hitPoints, int lives){
        setHitPoints(hitPoints);
        setLives(lives);
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        setHitPoints(getHitPoints() - damage);
        System.out.println("Dealt " + damage + " to enemy");
    }

}
