package Entities;

import Utils.Console;

public class Enemy extends Entity {
    
    public Enemy(double strength, double intelligence, double dexterity, double life, double mana, String name) 
    {
        super(strength, intelligence, dexterity, life, mana, name);
    }

    @Deprecated
    @Override
    public void showInventory() 
    {
        System.out.println("O inimigo não possui inventário.");
    }

    @Override
    public void showStatus() {
        String statusLine = String.format("--- Inimigo | Vida: %.0f ---", 
                                          this.getHealth());
        System.out.println(statusLine);
    }   
    
    @Deprecated
    @Override
    public void equipWeaponFromInventory(int index) 
    {
        System.out.println("O inimigo não pode equipar armas.");
    }

    @Override
    public void performAttack(Entity target) 
    {

        if (this.isStunned()) 
        {
            Console.printSlowly("O inimigo está atordoado e não pode atacar!\n");
            this.setStunned(false); 
            return;
        }

        double damage = 10;
        Console.printSlowly("O inimigo ataca voce causando " + damage + " de dano!\n");
        target.takeDamage(damage);
    }
}
