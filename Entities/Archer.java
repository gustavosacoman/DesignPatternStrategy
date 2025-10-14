package Entities;

import Weapons.DarkDagger;
import Weapons.ElvenBow;
import java.util.List;

public class Archer extends Entity {
    
    public Inventory inventory;

    public Archer() 
    {
        super(8,7,15,90,80);
        this.inventory = new Inventory(List.of(new ElvenBow(), new DarkDagger()) );
    }

    @Override
    public void passiveAbility() 
    {
        System.out.println("Habilidade Passiva do Arqueiro: Aumenta a chance de acerto crítico em 10%.");
    }

    @Override
    public void showInventory() 
    {
        System.out.println("=============== Inventário ===============");
        System.out.println("1. Arco Élfico");
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
