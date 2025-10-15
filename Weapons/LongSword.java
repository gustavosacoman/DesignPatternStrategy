package Weapons;


import Entities.Entity;
import Utils.RandomGeneratorUtil;


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
        
        enemy.takeDamage(this.getBaseDamage() * 3);

        int randomValue = RandomGeneratorUtil.generateRandomInt(100);

        if (randomValue < 35) { 
            enemy.setBleeding(true);
        }
        player.setMana(player.getMana() - getManaCost());
    }
}
