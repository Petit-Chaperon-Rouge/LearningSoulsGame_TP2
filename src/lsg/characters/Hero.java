package lsg.characters;

/**
 * Created by alecoeuc on 22/09/17.
 */
public class Hero extends Character {


    // Constructeurs


    /**
     * Crée un héro par défault nommé Gregooninator
     */
    public Hero(){
        this.setName("Gregooninator");
        this.setMaxLife(100);
        this.setLife(this.getMaxLife());
        this.setMaxStamina(50);
        this.setStamina(this.getMaxStamina());
    }

    /**
     * Crée un héro avec le nom choisi
     * @param name Le nom a donner au héro
     */
    public Hero(String name){
        super(name);
        this.setMaxLife(100);
        this.setLife(this.getMaxLife());
        this.setMaxStamina(50);
        this.setStamina(this.getMaxStamina());
    }

}