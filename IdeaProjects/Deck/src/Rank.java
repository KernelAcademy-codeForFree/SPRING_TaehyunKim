public class Rank {

    static RankType evaluate(Player player) {
        Card[] cards = player.getCards();
        int[] countValue = new int[14]; // 인덱스 1~13
        int[] countKind = new int[5];   // 인덱스 1~4

        for(int i = 0; i < cards.length; i++) {
            int value = cards[i].getNumber();
            int kind = cards[i].getKind();
            countValue[value]++;
            countKind[kind]++;
        }

        int pairs = 0;
        boolean three = false;
        boolean four = false;
        boolean flush = false;

        for(int i = 0; i < countValue.length; i++) {
            if(countValue[i] == 4) four = true;
            else if (countValue[i] == 3) three = true;
            else if (countValue[i] == 2) pairs++;
        }

        for(int i = 0; i < countKind.length; i++) {
            if(countValue[i] == 5) flush = true;
        }

        if(four) return RankType.FOUR_CARDS;
        if(three && pairs == 1) return RankType.FULL_HOUSE;
        if(three) return RankType.TRIPLE;
        if(pairs == 2) return RankType.TWO_PAIRS;
        if(pairs == 1) return RankType.ONE_PAIR;
        if(flush) return RankType.FLUSH;

        return RankType.HIGH_CARD;
    }
}

enum RankType {
    HIGH_CARD(1),
    ONE_PAIR(2),
    TWO_PAIRS(3),
    TRIPLE(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_CARDS(8),
    STRAIGHT_FLUSH(9);

    private final int number;

    RankType(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

