package Entities;

import Weapons.IWeapon; 

public abstract class Entity {
    private String name;
    private double strength;
    private double intelligence;
    private double dexterity;
    private double life;
    private double mana;
    private boolean stunned = false;
    private boolean bleeding = false;


    private IWeapon equippedWeapon;

    public Entity(double strength, double intelligence, double dexterity, double life, double mana) 
    {
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.life = life;
        this.mana = mana;
    }

    public void equipWeapon(IWeapon weapon)
    {
        if (this.strength >= weapon.getRequiredStrength() &&
            this.intelligence >= weapon.getRequiredIntelligence() &&
            this.dexterity >= weapon.getRequiredDexterity())
            {
                this.equippedWeapon = weapon;
                System.out.println("Arma equipada: " + weapon.getClass().getSimpleName());
            } 
    }

    public void performAttack(Entity enemy) 
    {
        if (equippedWeapon != null)
        {
            equippedWeapon.attack(this, enemy);
        }else
        {
            System.out.println(this.name + " está desarmado e ataca com os punhos!");
            enemy.takeDamage(1);
        }
    }

    public void takeDamage(double damage) 
    {
        this.life -= damage;
        if (this.life < 0) this.life = 0;
        System.out.println(this.name + " recebeu " + damage + " de dano. Vida restante: " + this.life);
    }

    public void showAttributes() 
    {
        System.out.println("Força: " + strength);
        System.out.println("Inteligência: " + intelligence);
        System.out.println("Destreza: " + dexterity);
        System.out.println("Vida: " + life);
        System.out.println("Mana: " + mana);
    }

    public abstract void equipWeaponFromInventory(int index);

    // public abstract void passiveAbility();

    public abstract void showInventory();

    public double getStrength() 
    {
        return strength;
    }

    public double getHealth() 
    {
        return life;
    }

    public String getName() 
    {
        return name;
    }

    public double getMana() 
    {
        return mana;
    }
    public void setMana(double mana) 
    {
        this.mana = mana;
    }

    public boolean isStunned() 
    {
        return stunned;
    }

    public void setStunned(boolean stunned) 
    {
        this.stunned = stunned;
    }
    
    public boolean isBleeding() 
    {
        return bleeding;
    }
    public void setBleeding(boolean bleeding) 
    {
        this.bleeding = bleeding;
    }
}
