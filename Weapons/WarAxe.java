package Weapons;

import Entities.Entity;

public class WarAxe implements  IWeapon {
    
    @Override
    public String getName() 
    {
        return "War Axe";
    }

    @Override
    public double getBaseDamage() 
    {
        return 20;
    }

    @Override
    public double getManaCost() 
    {
        return 0;
    }

    @Override
    public double getRequiredStrength() 
    {
        return 15;
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
        System.out.println(player.getName() + " ataca " + enemy.getName() + " com o " + getName() + "!");
        enemy.takeDamage(this.getBaseDamage());

        if (Math.random() < 0.35) { 
            System.out.println("Golpe Devastador! O inimigo está atordoado.");
        }
    }
    
}
