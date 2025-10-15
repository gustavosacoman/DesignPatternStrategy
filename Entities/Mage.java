package Entities;

import Weapons.ArcaneStaff;
import Weapons.DarkDagger;
import java.util.List;

public class Mage extends Entity {
    
    public Inventory inventory;

    public Mage(String name) 
    {
        super(5,18,7,70,150, name);
        this.inventory = new Inventory(List.of(new ArcaneStaff(), new DarkDagger()));
    }

    // Passiva: Aumenta o dano mágico em 15%
    @Override
    public void takeDamage(double damage) 
    {
        super.setMana(getMana() + 10);
        super.takeDamage(damage);
    }

    @Override
    public void showInventory() 
    {
        System.out.println("=============== Inventário ===============");
        System.out.println("1. Cajado Arcano");
        System.out.println("2. Adaga Sombria");
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
