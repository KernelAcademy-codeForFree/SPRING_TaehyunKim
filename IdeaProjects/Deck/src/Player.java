class Player {
    private String nickname;
    private int money;
    private int win;
    private int lose;
    private int score;
    private Card[] cards; // 카드 저장

    // 닉네임, 돈, 승, 패 설정
    Player(String nickname) {
        this.nickname = nickname;
        money = 10000;
        win = 0;
        lose = 0;
    }

    // 닉네임 받아오기
    String getNickname() {
        return nickname;
    }

    // 딜러에게 카드 받기
    void receivedByDealer(Card[] cards) {
        this.cards = cards;
    }

    // 카드 받아오기
    Card[] getCards() {
        return cards;
    }

    //
    int getWin() {
        return win;
    }

    int getLose() {
        return lose;
    }

    int getMoney() {
        return money;
    }

    void win() {
        money += 100;
        win++;
    }

    void lose() {
        lose++;
    }
}
