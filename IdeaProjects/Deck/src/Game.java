import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Deck deck;
    Dealer dealer;
    int min_players = 2;
    int max_players = 4;

    Game(Deck deck, Dealer dealer) {
        this.deck = deck;
        this.dealer = dealer;
    }

    Player[] setupPlayers() {
        int playerNum;
        Player[] players = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("플레이어 수? >>> ");
            try {
                playerNum = scanner.nextInt();
                scanner.nextLine();
                if (min_players <= playerNum && playerNum <= max_players) {
                    players = new Player[playerNum];
                    for (int i = 0; i < playerNum; i++) {
                        System.out.println((i + 1) + "번 째 플레이어 >>> ");
                        String nickname = scanner.nextLine().trim();
                        if (nickname.isEmpty()) {
                            System.out.println("입력해라");
                            i--;
                        } else if (nickname.length() > 20) {
                            System.out.println("20자안으로");
                            i--;
                        } else players[i] = new Player(nickname);

                    }
                    break;
                } else System.out.println(min_players + " ~ " + max_players + " 입력");
            } catch (InputMismatchException ie) {
                System.out.println("숫자 입력");
                scanner.nextLine();
            }
        }
        dealer.Winner(Arrays.asList(players));

        return players;
//        Card[] flushCards = {
//                new Card(Card.HEART, 2),
//                new Card(Card.HEART, 4),
//                new Card(Card.HEART, 6),
//                new Card(Card.HEART, 8),
//                new Card(Card.HEART, 10)
//        };
//        players[0].receivedByDealer(flushCards); // 플레이어 테스트
    }
}
