package Weapons;

import Entities.Entity;
import Utils.Console;

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
        
        if (enemy.isStunned()) {
            Console.printSlowly("O inimigo está desprevinidodo! Ataque crítico!");
            enemy.takeDamage(this.getBaseDamage() * 3);
        }
        else
        {
            enemy.takeDamage(this.getBaseDamage());
        }
        player.setMana(player.getMana() - getManaCost());
    }
    
}
