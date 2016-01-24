package org.example.learn;

/**
 * Created by point on 1/23/2016.
 */
public class SuperSoldier extends Enemy {

    public SuperSoldier(int hitPoints, int lives){
        super(hitPoints, lives);
    }

    public void takeDamage(int damage) {
        super.takeDamage(damage / 2);
        System.out.println("Supersoldier took only " + damage/2 + " damage!");
    }

}
