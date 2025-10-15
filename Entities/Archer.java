package Entities;

import Utils.Console;
import Weapons.DarkDagger;
import Weapons.ElvenBow;
import java.util.List;
import java.util.Random;

public class Archer extends Entity {
    
    public Inventory inventory;

    public Archer() 
    {
        super(8,7,15,90,80);
        this.inventory = new Inventory(List.of(new ElvenBow(), new DarkDagger()) );
    }

    // Passiva: 25% de chance de esquivar do ataque
    @Override
    public void takeDamage(double damage) 
    {
        long seed = System.currentTimeMillis();
        Random randomGenerator = new Random(seed);
        int numeroAleatorio = randomGenerator.nextInt(100);
        if (numeroAleatorio < 25) {
            damage = 0;
            Console.printSlowly("O ataque foi esquivado!");
        }
        super.takeDamage(damage);
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
