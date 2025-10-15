package Weapons;

import Entities.Entity;

public class ArcaneStaff implements IWeapon {
    
    @Override
    public String getName() 
    {
        return "Arcane Staff";
    }

    @Override
    public double getBaseDamage() 
    {
        return 18;
    }

    @Override
    public double getManaCost() 
    {
        return 25;
    }

    @Override
    public double getRequiredStrength() 
    {
        return 0;
    }

    @Override
    public double getRequiredDexterity() 
    {
        return 0;
    }

    @Override
    public double getRequiredIntelligence() 
    {
        return 12;
    }

    @Override
    public void attack(Entity player, Entity enemy) 
    {
        System.out.println(player.getName() + " ataca " + enemy.getName() + " com o " + getName() + "!");
        enemy.takeDamage(this.getBaseDamage());

        if (Math.random() < 0.30) { 
            System.out.println("Explosão Arcana! O inimigo está atordoado.");
            
        }
    }
}
