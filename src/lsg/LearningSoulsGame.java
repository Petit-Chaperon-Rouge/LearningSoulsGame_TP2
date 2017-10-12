package lsg;

import lsg.characters.Hero;
import lsg.characters.Monster;
import lsg.weapons.Sword;

/**
 * Created by alecoeuc on 22/09/17.
 */
public class LearningSoulsGame {
    public static void main(String[] args) {

        Hero hero = new Hero();
        Monster monster1 = new Monster("Studentatort");
        Monster monster2 = new Monster();
        Monster monster3 = new Monster();
        Sword sword = new Sword();


        for (int i = 0; i < 5; i++) {
            hero.printStats();
            System.out.println("attaque avec " + sword.toString() + " > " + hero.attackWith(sword));
        }

        /*
        monster1.printStats();
        monster2.printStats();
        monster3.printStats();
        */

    }
}