package Entities;

import Weapons.ArcaneStaff;
import Weapons.DarkDagger;
import java.util.List;

public class Mage extends Entity {
    
    public Inventory inventory;
    public Mage() 
    {
        super(5,18,7,70,150);
        this.inventory = new Inventory(List.of(new ArcaneStaff(), new DarkDagger()));
    }

    @Override
    public void passiveAbility() 
    {
        System.out.println("Habilidade Passiva do Mago: Aumenta o poder mágico em 15%.");
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
