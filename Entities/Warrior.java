package Entities;

import Weapons.LongSword;
import Weapons.WarAxe;
import java.util.List;

public class Warrior extends Entity {
    
    public Inventory inventory;
    
    public Warrior(String name) 
    {
        super(15,5,8,120,50, name);
        this.inventory = new Inventory(List.of(new LongSword(), new WarAxe()));
    }

    // Passiva: Reduz o dano recebido em 20%
    @Override
    public void takeDamage(double damage) 
    {
        damage = 0.8 * damage;
        super.takeDamage(damage);
    }

    @Override
    public void showInventory() 
    {
        System.out.println("=============== Inventário ===============");
        System.out.println("1. Espada Longa");
        System.out.println("2. Machado de Guerra");
        System.out.println("===========================================");
    }

    @Override
    public void equipWeaponFromInventory(int index)
    {
        if (index < 0 || index >= inventory.weapons.size()) 
        {
            System.out.println("Nenhuma arma equipada.");
            return;
        }
        equipWeapon(inventory.weapons.get(index));
    }
}
