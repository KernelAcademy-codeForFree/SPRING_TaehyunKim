import java.util.List;

public class Dealer {
    static final int HAND_SET = 5;
    Deck deck;

    Dealer(Deck deck) {
        this.deck = deck;
        deck.shuffle();
    }

    Card[] pickFive() {
        Card[] handSet = new Card[HAND_SET];
        for (int i = 0; i < HAND_SET; i++) {
            handSet[i] = deck.pick();
        }
        return handSet;
    }

    void dealToPlayerAndRank(Player player) {
        Card[] cards = pickFive();
        player.receivedByDealer(cards);
        RankType rank = Rank.evaluate(player);
        System.out.println("[" + player.getNickname() + "]의 카드:");

        Card[] printCards = player.getCards();
        for (int i = 0; i < printCards.length; i++) {
            System.out.println(printCards[i]);
        }

        System.out.println("Rank: " + rank);
        System.out.println();
    }

    Player Winner(List<Player> players) {
        Player winner = null;
        RankType bestRank = null;

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            dealToPlayerAndRank(player);

            RankType playerRank = Rank.evaluate(player);

            if (winner == null || playerRank.getNumber() > bestRank.getNumber()) {
                winner = player;
                bestRank = playerRank;
            }
        }

        if (winner != null) {
            winner.win();
            System.out.println("Winner: " + winner.getNickname());
            System.out.println("Money: " + winner.getMoney());

            for(int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                if(player != winner) {
                    player.lose();
                }
            }
        }
        System.out.println("Winner's rank: " + bestRank);
        return winner;
    }
}
