package Weapons;

import Entities.Entity;
import Utils.Console;
import Utils.RandomGeneratorUtil;

public class WarAxe implements IWeapon {
    
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
        enemy.setStunned(false);
        Console.printSlowly(player.getName() + " ataca " + enemy.getName() + " com o " + getName() + "!");
        enemy.takeDamage(this.getBaseDamage());
        
        int numeroAleatorio = RandomGeneratorUtil.generateRandomInt(100);

        if (numeroAleatorio < 25) { 
            enemy.setStunned(true);
        }
    }
    
}
