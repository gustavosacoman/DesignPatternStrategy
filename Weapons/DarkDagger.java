package Weapons;

import Entities.Entity;

public class DarkDagger implements  IWeapon {
    
    @Override
    public String getName() 
    {
        return "Adaga Sombria";
    }

    @Override
    public double getBaseDamage() 
    {
        return 10;
    }

    @Override
    public double getManaCost() 
    {
        return 10;
    }

    @Override
    public double getRequiredStrength() 
    {
        return 0;
    }
    @Override
    public double getRequiredDexterity() 
    {
        return 10;
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

        if (Math.random() < 0.20) { 
            System.out.println("Sombra Envolvente! O inimigo está envenenado.");
        }
    }
    
}
