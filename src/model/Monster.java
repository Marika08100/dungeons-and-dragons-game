package model;

public class Monster {


    // Vegyél fel két fieldet: name (String) és health (int)
    private String name;
    private int health;

    // Írj egy két paraméteres kosntruktort ami beállítja az attribútumok értékeit!
    public Monster(String name, int health) {
        this.name = name;
        this.health = health;


    }


    public void attack(Character player) {
        // Írd ki: [szörny neve] attacks [játékos neve]!
        System.out.println( name +  " attack " + player.getName());
        // Csokkentsd a jatekos elet 20-al
        player.setHealth(player.getHealth() - 20);
        // Írd ki: Dealt 20 damage to [játékos neve]!
        System.out.println("Dealt 20 damage to " + player.getName() + player.getHealth());

        // Ha a játékos élete 0 vagy kisebb, írd ki: [játékos neve] has been defeated!
        if (player.getHealth() <= 0) {
            System.out.println(player + "has been defeated ");
        }
    }
    @Override
    public String toString(){
        return name + " " + health + " HP";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}