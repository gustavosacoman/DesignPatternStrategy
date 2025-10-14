package Game;

import Entities.Archer;
import Entities.Enemy;
import Entities.Entity;
import Entities.Mage;
import Entities.Warrior;
import View.Console;
import Weapons.ArcaneStaff;
import Weapons.ElvenBow;
import Weapons.LongSword;

public class Battle {

    public static void chooseCharacter() 
    {

        int option;
        System.out.println("Escolha seu personagem:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");
        System.out.println("4 - Sair do jogo");

        option = Console.readInt(">> ");

        switch (option) 
        {
            case 1:
                Entity warrior = new Warrior();
                System.out.println("Você escolheu o Guerreiro!");
                warrior.showAttributes();
                startBattle(warrior);
                break;
            case 2:
                Entity mage = new Mage();
                System.out.println("Você escolheu o Mago!");
                mage.showAttributes();
                startBattle(mage);
                
                break;
            case 3:
                Entity archer = new Archer();
                System.out.println("Você escolheu o Arqueiro!");
                archer.showAttributes();
                startBattle(archer);
                break;
            case 4:
                System.out.println("Saindo do jogo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                chooseCharacter();
                break;
        }
    }

    private static void startBattle(Entity player)
    {
        Console.readString("Aperte Enter para continuar");
        Enemy enemy = new Enemy();
        
        if (player instanceof Warrior)
        {
            player.equipWeapon(new LongSword());
        }
        else if (player instanceof Mage)
        {
            player.equipWeapon(new ArcaneStaff());
        }
        else if (player instanceof Archer)
        {
            player.equipWeapon(new ElvenBow());
        }

        do
        {
            Console.printSlowly("Um inimigo aparece!\n");
            Console.printSlowly("o inimigo tem " + enemy.getHealth() + " de vida!\n");
            Console.printSlowly("Você tem " + player.getHealth() + " de vida!\n");

            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - trocar de arma");
            System.out.println("3 - desistir");
            Console.printSlowly(">> ");
            int action = Console.readInt("");

            switch (action)
            {
                case 1:
                    player.performAttack(enemy);
                break;
                case 2:
                    player.showInventory();
                    int weaponIndex = Console.readInt("Escolha a arma pelo número: ");
                    player.equipWeaponFromInventory(weaponIndex);
                break;
                case 3:
                    Console.printSlowly("Você fugiu da batalha!");
                return;
                default:
                    System.out.println("Ação inválida.");
                    break;
            }

            if (enemy.getHealth() > 0) {
                Console.printSlowly("\nTurno do inimigo!");
                enemy.performAttack(player);
            }

            Console.readString("\nAperte Enter para o próximo turno...");

        } while (enemy.getHealth() > 0 || player.getHealth() > 0);

        if (player.getHealth() > 0) {
            Console.printSlowly("\n*** VITÓRIA! Você derrotou o inimigo! ***");
        } else {
            Console.printSlowly("\n--- DERROTA! Você foi derrotado... ---");
        }
    }
    
    
}
