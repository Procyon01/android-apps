package org.example.learn;

import java.util.ArrayList;

/**
 * A Tale of Two Brave Warriors.
 * Created by point on 1/21/2016.
 */
public class GameDemo {
    public static void main(String[] args) {
        Player Tyler = new Player("Tyler", 10, 2, 0);
        Player Daniel = new Player("Daniel");

        System.out.println(Tyler.getHandleName() + " joins the fray.");
        System.out.println("Tyler equips " + Tyler.getWeapon().getName());
        System.out.println(Daniel.getHandleName() + " joins the fray.");
        System.out.println("Daniel equips " + Daniel.getWeapon().getName());

        Weapon shinyAxe = new Weapon("Goldshine Axe", 15, 20);
        System.out.println("A " + shinyAxe.getName() + " appears on the arena floor!");

        Daniel.setWeapon(shinyAxe);
        System.out.println("Daniel equips " + shinyAxe.getName() + "!");

        Tyler.setLevel(1);
        System.out.println("Tyler is demoralized! (level has dropped by 1)!");

        InventoryItem redPotion = new InventoryItem(ItemType.POTION, "A health potion");
        Tyler.addInventoryItem(redPotion);
        System.out.println(redPotion.getName() + " has been picked up by Tyler!");

        InventoryItem bluePotion = new InventoryItem(ItemType.POTION, "A mana potion");
        System.out.println(bluePotion.getName() + " has been picked up by Tyler!");
        Tyler.addInventoryItem(bluePotion);

        ArrayList<InventoryItem> items = Tyler.getInventoryItems();
        System.out.println("\nTyler currently has in inventory: ");
        for (InventoryItem i : items) {
            System.out.println(i.getName());
        }

        Soldier soldier = new Soldier(25, 10);
        soldier.takeDamage(5);

        SuperSoldier superSoldier = new SuperSoldier(25, 1);
        System.out.println("Hitpoints: " + superSoldier.getHitPoints());
        superSoldier.takeDamage(10);
        System.out.println("Hitpoints: " + superSoldier.getHitPoints());
    }
}
