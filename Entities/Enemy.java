package Entities;

public class Enemy extends Entity {
    
    public Enemy() 
    {
        super(20, 10, 5, 50, 100);
    }

    @Override
    public void passiveAbility() 
    {
        System.out.println("Habilidade Passiva do Inimigo: Aumenta a defesa em 10%.");
    }

    @Deprecated
    @Override
    public void showInventory() 
    {
        System.out.println("O inimigo não possui inventário.");
    }
    
    @Deprecated
    @Override
    public void equipWeaponFromInventory(int index) 
    {
        System.out.println("O inimigo não pode equipar armas.");
    }
}
