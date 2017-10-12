package lsg.characters;

import lsg.helpers.Dice;
import lsg.weapons.Weapon;

/**
 * Created by alecoeuc on 22/09/17.
 */
public class Character {

    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;
    private Dice dice;


    // Getters & Setters


    /**
     *
     * @return (String) Le nom
     */
    public String getName(){
        return this.name;
    }

    /**
     * Changer ou donner le nom
     * @param name Le nom
     */
    protected void setName(String name){
        this.name = name;
    }



    /**
     *
     * @return (int) La vie restante
     */
    public int getLife(){
        return this.life;
    }

    /**
     * Modifie la valuer de la vie restante
     * @param life La vie restante
     */
    protected void setLife(int life){
        this.life = life;
    }



    /**
     *
     * @return (int) La valeur maximale de vie
     */
    public int getMaxLife(){
        return this.maxLife;
    }

    /**
     * Modifie la valeur maximale de vie
     * @param maxLife La valeur maximale de vie
     */
    protected void setMaxLife(int maxLife){
        this.maxLife = maxLife;
    }



    /**
     *
     * @return (int) La force restante
     */
    public int getStamina(){
        return this.stamina;
    }

    /**
     * Modifie la force restante
     * @param stamina La force restante
     */
    protected void setStamina(int stamina){
        this.stamina = stamina;
    }



    /**
     *
     * @return (int) La valeur de force maximale
     */
    public int getMaxStamina(){
        return this.maxStamina;
    }

    /**
     * Modifie la valeur de force maximale du héro
     * @param maxStamina La valeur de force maximale du héro
     */
    protected void setMaxStamina(int maxStamina){
        this.maxStamina = maxStamina;
    }


    // Constructeurs


    /**
     * Crée un personnage par défault
     */
    public Character(){
        dice = new Dice(101);
    }

    /**
     * Crée un personnage avec le nom choisi
     * @param name Le nom a donner
     */
    public Character(String name){
        this.setName(name);
        dice = new Dice(101);
    }


    // Méthodes


    /**
     * Retourne les statistiques du personnage sur la console
     */
    public void printStats(){
        System.out.println(this.toString());
    }

    /**
     * Surcharge de toString
     * @return Les statistiques du personnage
     */
    public String toString() {
        String alive = (this.isAlive()) ? "ALIVE" : "DEAD" ;
       return (String.format("%-20s %-20s LIFE:%-10s STAMINA:%-10s", "[ " + getClass().getSimpleName() + " ]", getName(), String.format("%5d", this.getLife()), String.format("%5d", this.getStamina())) + "(" + alive + ")");
    }

    /**
     * L'etat du personnage
     * @return L'etat du personnage
     */
    public boolean isAlive(){ // Peut être mis en friendly
        return this.getLife()!=0;
    }

    /**
     * Le personnage attaque.
     * Réarrange les statistiques du personnage et de l'arme
     * @return (int) La valeur des dégâts
     */
    public int attackWith(Weapon weapon) {
        int damage = 0;

        weapon.use();

        if (!weapon.isBroken()) {
            int precision = this.dice.roll();
            damage = (int) (weapon.getMinDamage() + (weapon.getMaxDamage()-weapon.getMinDamage()) * (precision/100));

        }

        this.setStamina(this.getStamina()-weapon.getStamCost());

        if (this.getStamina()<0) {
            while (this.getStamina()<0) {
                this.setStamina(this.getStamina() + 1);
                damage--;
            }
        }

        if (damage < 0)
            damage = 0;

        return damage;
    }

}
