package effectivejava.old.chap8.item51;

public class Main {

    public static void main(String[] args) {
        Card card = new Card("5", "diamond");
    }


    public static class Card {

        String rank;
        String suit;

        public Card (String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        public String getRank() {
            return rank;
        }

        public String getSuit() {
            return suit;
        }

        public String shuffle() {
            return null;
        }

        static String getRankSuit() {
            return "";
        }
    }

}
