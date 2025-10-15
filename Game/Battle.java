package Game;

import Entities.Archer;
import Entities.Enemy;
import Entities.Entity;
import Entities.Mage;
import Entities.Warrior;
import Utils.Console;
import Weapons.ArcaneStaff;
import Weapons.ElvenBow;
import Weapons.LongSword;

public class Battle {

    public static void startGame() 
    {
        Console.printSlowly("Bem-vindo ao jogo de batalha!\n");
        Console.printSlowly("Digite o nome do seu personagem:\n");
        String name = Console.readString(">> ");
        chooseCharacter(name);
    }

    public static void chooseCharacter(String name) 
    {

        int option;
        Console.printSlowly("Escolha seu personagem:\n");
        Console.printSlowly("1 - Guerreiro\n");
        Console.printSlowly("2 - Mago\n");
        Console.printSlowly("3 - Arqueiro\n");
        Console.printSlowly("4 - Sair do jogo\n");

        option = Console.readInt(">> ");

        switch (option) 
        {
            case 1:
                Entity warrior = new Warrior(name);
                Console.printSlowly("Você escolheu o Guerreiro!");
                warrior.showAttributes();
                startBattle(warrior);
                break;
            case 2:
                Entity mage = new Mage(name);
                Console.printSlowly("Você escolheu o Mago!");
                mage.showAttributes();
                startBattle(mage);
                
                break;
            case 3:
                Entity archer = new Archer(name);
                Console.printSlowly("Você escolheu o Arqueiro!");
                archer.showAttributes();
                startBattle(archer);
                break;
            case 4:
                Console.printSlowly("Saindo do jogo...");
                System.exit(0);
                break;
            default:
                Console.printSlowly("Opção inválida. Tente novamente.");
                chooseCharacter(name);
                break;
        }
    }

    private static void startBattle(Entity player)
    {
        Console.readString("Aperte Enter para continuar");
        Enemy enemy = new Enemy(10, 5, 5000, 250, 50, "Goblin");
        
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
        Console.printSlowly("Um inimigo aparece!\n");
        Console.printSlowly("o inimigo tem " + enemy.getHealth() + " de vida!\n");
        Console.printSlowly("Você tem " + player.getHealth() + " de vida!\n");

        boolean playerTurn = true;
        do
        {
            playerTurn = true;
            Console.printSlowly("\n=============== SEU TURNO ===============\n");
            player.showStatus();
            enemy.showStatus();
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - trocar de arma");
            System.out.println("3 - desistir");
            Console.printSlowly(">> ");
            int action = Console.readInt("");

            if (player.getDexterity() < enemy.getDexterity())
            {
                Console.printSlowly("O inimigo é mais rápido e ataca primeiro!\n");
                enemy.performAttack(player);
                playerTurn = false;
                if (player.getHealth() <= 0) break;
            }


            switch (action)
            {
                case 1:
                    player.performAttack(enemy);
                break;
                case 2:
                    player.showInventory();
                    int weaponIndex = Console.readInt("Escolha a arma pelo número: ");
                    player.equipWeaponFromInventory(weaponIndex - 1);
                break;
                case 3:
                    Console.printSlowly("Você fugiu da batalha!");
                return;
                default:
                System.out.println("Ação inválida.");
                continue;   
            }

            if(enemy.isBleeding())
            {
                Console.printSlowly("O inimigo está sangrando!");
                enemy.takeDamage(5);
            }
            if (enemy.isStunned())
            {
                Console.printSlowly("O inimigo está atordoado e não pode atacar!");
                enemy.setStunned(false);
                continue;
            }

            if (enemy.getHealth() > 0 && !playerTurn) {
                Console.printSlowly("\nTurno do inimigo!");
                enemy.performAttack(player);
            }

            Console.readString("\nAperte Enter para o próximo turno...");

        } while (enemy.getHealth() > 0 && player.getHealth() > 0);

        if (player.getHealth() > 0) {
            Console.printSlowly("\n*** VITÓRIA! Você derrotou o inimigo! ***");
        } else {
            Console.printSlowly("\n--- DERROTA! Você foi derrotado... ---");
        }
    }
    
    
}
