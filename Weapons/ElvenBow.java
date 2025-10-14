package Weapons;

import Entities.Entity;

public class ElvenBow implements IWeapon {
    
    @Override
    public String getName() 
    {
        return "Elven Bow";
    }

    @Override
    public double getBaseDamage() 
    {
        return 12;
    }

    @Override
    public double getManaCost() 
    {
        return 15;
    }

    @Override
    public double getRequiredStrength() 
    {
        return 0;
    }

    @Override
    public double getRequiredDexterity() 
    {
        return 8;
    }

    @Override
    public double getRequiredIntelligence() 
    {
        return 0;
    }

    @Override
    public void attack(Entity player, Entity enemy) 
    {
        System.out.println(player.getName() + " ataca " + enemy.getName() + " com o " + getName() + "!");
        enemy.takeDamage(this.getBaseDamage());

        if (Math.random() < 0.25) { 
            System.out.println("Tiro Preciso! O inimigo está atordoado.");
        }
    }
}
