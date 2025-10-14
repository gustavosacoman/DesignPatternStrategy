package Weapons;


import Entities.Entity;

public class LongSword implements IWeapon {

    @Override
    public String getName()
    {
        return "LongSword";
    }
    
    @Override
    public double getBaseDamage() 
    {
        return 15;
    }

    @Override
    public double getManaCost() 
    {
        return 0;
    }

    @Override
    public double getRequiredStrength() 
    {
        return 10;
    }

    @Override
    public double getRequiredDexterity() 
    {
        return 0;
    }

    @Override
    public double getRequiredIntelligence() 
    {
        return 0;
    }

    @Override
    public void attack(Entity player, Entity enemy) 
    {
        System.out.println(player.getName() + " ataca " + enemy.getName() + " com a " + getName() + "!");
        enemy.takeDamage(this.getBaseDamage());

        if (Math.random() < 0.30) { 
            System.out.println("Corte Profundo! O inimigo está sangrando.");
        }
    }
}
