import model.Character;
import model.Monster;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Kérd meg a felhasználót, hogy adja meg a karaktere nevét és ezt olvasd be egy változóba!
        // (Használj Scannert!)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your character's name: ");
        String username = scanner.nextLine();

        Monster monster = new Monster("",1);
        // Példányosíts egy Charactert (hívd meg a konstruktorát) ezzel a változóval!
        Character character = new Character(username, monster.getHealth(), 1);

        // Írd ki: Welcome, [játékos neve]!
        System.out.println("Welcome " + username + " !");

        // Készíts egy 3 hosszúságú tömböt Monster-ekből!
        Monster[] monsters = new Monster[3];

        // Töltsd fel szörnyekkel! Példa: monsters[0] = new Monster("Goblin", 50);
        monsters[0] = new Monster("Goblin", 100);
        monsters[1] = new Monster("Orc", 60);
        monsters[2] = new Monster("Tauren", 170);

        // Készíts egy gameOver nevű logikai változót, állítds az értékét false-ra!
        boolean gameOver = false;

        // Írj egy ciklust, ami addig tart amíg nincs vége a játéknek (amíg a gameOver nem true) ÉS
        // amíg a karakter élete 0-nál nagyobb!
        Monster selectedMonster = monster;

        while (!gameOver && character.getHealth() > 0) {
            System.out.println("Choose a monster to fight or quit: ");
            System.out.println(" 0: Quit ");


            // Írd ki: Choose a monster to fight or quit:

            // Írd ki: 0: Quit

            // Írd ki a Monstereket tartalmazó tömb összes elemének a nevét ebben a formátumban:
            // 1: Goblin
            // 2: Troll
            // 3: Dragon
            for (int i = 0; i < monsters.length; i++) {
                System.out.println((i + 1) + ". " + monsters[i].toString());

            }

            // Olvasd be egy choice nevű változóba a felhasználótól, hogy mit választ: kilép vagy valamelyik
            // szörnnyel harcol!

            // Ha azt választja, hogy kilép (0), írd ki: Thanks for playing! Goodbye.
            // És állítsd be a gameOver változó értékét true-ra!
            System.out.println("Which monster dou you wanna choose? 1,2,3? ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Thanks for playing. Goodbye! ");
                gameOver = true;
            } else if (choice >= 1 && choice <= monsters.length) {
                selectedMonster = monsters[choice - 1];

            }

            // Ha jó inputot ad meg (1 és tömb hossza között) és harcol:
            // Tárold el egy Monster típusú változóban, hogy melyiket választotta a felhasználó!
            // Írj egy ciklust, ami addig megy, amíg a szörny és a játékos élete is nagyobb mint 0!
            // Támadja meg a felhasználó karaktere a szörnyet!
            while (selectedMonster.getHealth() > 0 && character.getHealth() > 0) {
                character.attack(selectedMonster);
                // Ha a szörny élete továbbra is nagyobb, mint 0, akkor a szörny támadjon vissza!
                if (selectedMonster.getHealth() > 0) {
                    selectedMonster.attack(character);
                }
                // Ha a karakter élete 0 vagy kisebb, írd ki: You have been defeated!
                if (character.getHealth() <= 0) {
                    System.out.println("You have been defeated!");
                    // Ha rossz inputot ad meg, írd ki: Invalid choice!
                } else {
                    System.out.println("Invalid choice!");

                }

            }


        }
    }
}
