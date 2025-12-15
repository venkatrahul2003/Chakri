import java.util.*;

public class Helper {
    public static void main(String[] args) {
        new World().start();
    }
}

class World {
    Scanner s = new Scanner(System.in);
    Player p = new Player("Hero", 30, 6);
    Random r = new Random();

    void start() {
        println("Welcome to Tiny Dungeon");
        loop:
        while (true) {
            println("");
            println("HP " + p.hp + "/" + p.maxHp + " | Gold " + p.gold + " | Level " + p.level);
            println("1 Explore  2 Shop  3 Rest  4 Quit");
            String c = s.nextLine().trim();
            switch (c) {
                case "1" -> explore();
                case "2" -> shop();
                case "3" -> rest();
                case "4" -> { println("Goodbye"); break loop; }
                default -> println("Choose 1-4");
            }
            if (p.hp <= 0) { println("You died. Game over."); break; }
        }
    }

    void explore() {
        int roll = r.nextInt(100);
        if (roll < 60) encounter();
        else if (roll < 85) treasure();
        else event();
    }

    void encounter() {
        Enemy e = Enemy.random(r, p.level);
        println("Encounter: " + e.name + " (HP " + e.hp + ")");
        battle(e);
    }

    void battle(Enemy e) {
        while (e.hp > 0 && p.hp > 0) {
            println("");
            println("Your HP " + p.hp + " | " + e.name + " HP " + e.hp);
            println("1 Attack  2 Skill  3 Heal  4 Run");
            String c = s.nextLine().trim();
            switch (c) {
                case "1" -> {
                    int dmg = p.attack();
                    e.hp -= dmg;
                    println("You hit " + e.name + " for " + dmg);
                }
                case "2" -> {
                    if (p.useSkill(e)) println("Skill hit!");
                    else println("Skill failed");
                }
                case "3" -> {
                    if (p.heal()) println("Healed to " + p.hp);
                    else println("No potions");
                }
                case "4" -> {
                    if (r.nextInt(100) < 50) { println("You fled"); return; }
                    else println("Failed to flee");
                }
                default -> { println("Choose 1-4"); continue; }
            }
            if (e.hp > 0) {
                int d = e.attack();
                p.hp -= d;
                println(e.name + " hits you for " + d);
            }
        }
        if (p.hp > 0) {
            int g = 5 + r.nextInt(6) + p.level;
            p.gold += g;
            p.exp += 10 + p.level * 2;
            println("Victory! Gained " + g + " gold and exp. Total exp " + p.exp);
            p.checkLevel();
        }
    }

    void treasure() {
        int g = 10 + r.nextInt(20);
        p.gold += g;
        println("Found treasure: " + g + " gold");
    }

    void event() {
        int x = r.nextInt(3);
        if (x == 0) { println("You found a potion"); p.potions++; }
        else if (x == 1) { println("A wandering sage heals you"); p.hp = p.maxHp; }
        else { println("Trap! you lose 5 HP"); p.hp -= 5; }
    }

    void shop() {
        println("Shop: 1 Potion 10g  2 MaxHP+5 25g  3 Exit");
        String c = s.nextLine().trim();
        switch (c) {
            case "1" -> {
                if (p.gold >= 10) { p.gold -= 10; p.potions++; println("Bought potion"); } else println("Not enough gold");
            }
            case "2" -> {
                if (p.gold >= 25) { p.gold -= 25; p.maxHp += 5; p.hp = p.maxHp; println("Max HP increased"); } else println("Not enough gold");
            }
            default -> println("Leave");
        }
    }

    void rest() {
        if (r.nextInt(100) < 20) { println("Ambushed while resting!"); encounter(); }
        else { p.hp = p.maxHp; println("Rested to full HP"); }
    }

    void println(String t) { System.out.println(t); }
}

class Player {
    String name;
    int maxHp;
    int hp;
    int atk;
    int potions = 1;
    int gold = 0;
    int level = 1;
    int exp = 0;
    Random r = new Random();

    Player(String n, int h, int a) { name = n; maxHp = h; hp = h; atk = a; }

    int attack() { return atk + r.nextInt(4); }

    boolean useSkill(Enemy e) {
        if (r.nextInt(100) < 60) {
            int d = atk * 2 + r.nextInt(6);
            e.hp -= d;
            return true;
        }
        return false;
    }

    boolean heal() {
        if (potions > 0) { potions--; hp = Math.min(maxHp, hp + 10); return true; }
        return false;
    }

    void checkLevel() {
        int need = level * 30;
        while (exp >= need) {
            exp -= need;
            level++;
            maxHp += 5;
            atk += 1;
            hp = maxHp;
            need = level * 30;
            System.out.println("Leveled up! Now level " + level);
        }
    }
}

class Enemy {
    String name;
    int hp;
    int atk;
    Random r = new Random();
    Enemy(String n, int h, int a) { name = n; hp = h; atk = a; }

    int attack() { return atk + r.nextInt(3); }

    static Enemy random(Random rd, int plv) {
        int t = rd.nextInt(100);
        if (t < 50) return new Enemy("Goblin", 8 + plv * 2, 3 + plv / 2);
        if (t < 80) return new Enemy("Orc", 14 + plv * 3, 5 + plv / 2);
        if (t < 95) return new Enemy("Troll", 22 + plv * 4, 7 + plv);
        return new Enemy("Dragon Whelp", 30 + plv * 5, 9 + plv * 2);
    }
}
