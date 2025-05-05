public class DeckTest {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        Game game = new Game(deck, dealer);

        game.setupPlayers();
    }
}
