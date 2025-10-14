package Entities;

import Weapons.LongSword;
import Weapons.WarAxe;
import java.util.List;

public class Warrior extends Entity {
    
    public Inventory inventory;
    
    public Warrior() 
    {
        super(15,5,8,120,50);
        this.inventory = new Inventory(List.of(new LongSword(), new WarAxe()));
    }

    @Override
    public void passiveAbility() 
    {
        System.out.println("Habilidade Passiva do Guerreiro: Aumenta a defesa em 5 pontos.");
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
