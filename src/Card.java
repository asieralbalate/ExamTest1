import java.io.Serializable;

public class Card implements Serializable {
    private int number;
    private int suit;

    public Card(int number, int suit) {
        this.number = number;
        this.suit = suit;
    }

    public String toString() {
        String suitString = "";
        switch (suit) {
            case 1:
                suitString = "oros";
                break;
            case 2:
                suitString = "copas";
                break;
            case 3:
                suitString = "espadas";
                break;
            case 4:
                suitString = "bastos";
                break;
        }
        return number + " de " + suitString;
    }
}
