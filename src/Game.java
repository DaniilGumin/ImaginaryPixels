import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Unit player = new Player();
        NextTurnObserver nextTurnObserver = new NextTurnObserver();
        nextTurnObserver.subscribe(player);
        Scanner scanner = new Scanner(System.in);
        while (player.isAlive()) {
            System.out.println("Ты встречаешь воина.1 - драться, 2 - убежать");
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                Unit warrior = new Warrior();
                nextTurnObserver.subscribe(warrior);
                while (player.isAlive() && warrior.isAlive()) {
                    System.out.println("Выбери тип атаки: ");
                    for (int i = 0; i < player.getSkills().size(); i++) {
                        System.out.println(i + ". " + player.getSkills().get(i).getName());
                    }
                    int attackIndex = scanner.nextInt();
                    player.attack(warrior, player.getSkills().get(attackIndex));
                    warrior.attack(player, warrior.getSkills().get(0));
                    System.out.println("\nТвои hp: " + player.getHealth());
                    System.out.println("hp воина: " + warrior.getHealth());
                    nextTurnObserver.notify(0);
                    if (!warrior.isAlive()) {
                        nextTurnObserver.unsubscribe(warrior);
                    }
                }
            } else if (userInput == 2) {
                System.out.println("Ты убежал.");
            }
        }
    }
}
