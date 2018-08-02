import java.util.HashMap;
import java.util.Map;

public class SnakesLadders {
    public class Player {
        private int square;
        private int playerNumber;

        Player(int playerNumber) {
            this.square = 0;
            this.playerNumber = playerNumber;
        }
        public int getSquare() {
            return this.square;
        }
        public void setSquare(int update) {
            this.square = update;
        }

        public int getPlayerNumber() {
            return this.playerNumber;
        }

        @Override
        public String toString() {
            return String.format("Player %1$s is on square %2$s", playerNumber, square);
        }
    }

    private Player currentPlayer;
    private Player previousPlayer;
    private Player nextPlayer;
    private boolean extraTurn;
    private boolean hasWinner;

    private static final Map<Integer, Integer> LADDERS;
    static {
        LADDERS = new HashMap<>();
        LADDERS.put(2, 38);
        LADDERS.put(7, 14);
        LADDERS.put(8, 31);
        LADDERS.put(15, 26);
        LADDERS.put(21, 42);
        LADDERS.put(28, 84);
        LADDERS.put(36, 44);
        LADDERS.put(51, 67);
        LADDERS.put(71, 91);
        LADDERS.put(78, 98);
        LADDERS.put(87, 94);
    }

    private static final Map<Integer, Integer> SNAKES;
    static {
        SNAKES = new HashMap<>();
        SNAKES.put(16, 6);
        SNAKES.put(46, 25);
        SNAKES.put(49, 11);
        SNAKES.put(62, 19);
        SNAKES.put(64, 60);
        SNAKES.put(74, 53);
        SNAKES.put(89, 68);
        SNAKES.put(92, 88);
        SNAKES.put(95, 75);
        SNAKES.put(99, 80);
    }

    public SnakesLadders() {
        this.currentPlayer = new Player(1);
        this.nextPlayer = new Player(2);
        this.previousPlayer = null;
        this.extraTurn = false;
        this.hasWinner = false;
    }

    public boolean hasSnake(int key) {
        return SNAKES.containsKey(key);
    }

    public void setNextSquare(int nextSquare) {
        if (nextSquare > 100 && !hasSnake(200 - nextSquare)) {
            this.currentPlayer.setSquare(200 - nextSquare);
        } else if (nextSquare > 100) {
            this.currentPlayer.setSquare(SNAKES.get(200 - nextSquare));
        } else if (LADDERS.containsKey(nextSquare)) {
            this.currentPlayer.setSquare(LADDERS.get(nextSquare));
        } else if (SNAKES.containsKey(nextSquare)) {
            this.currentPlayer.setSquare(SNAKES.get(nextSquare));
        } else {
            this.currentPlayer.setSquare(nextSquare);
        }
    }

    public String play(int die1, int die2) {
        if (this.hasWinner) {
            return "Game over!";
        }

        if (die1 == die2) { extraTurn = true; }
        else { extraTurn = false; }

        int currentSquare = this.currentPlayer.getSquare();
        int sumDice = die1 + die2;
        int nextSquare = currentSquare + sumDice;

        setNextSquare(nextSquare);

        // Since the square was updated, we need to make another call to getSquare
        if (this.currentPlayer.getSquare() == 100) {
            this.hasWinner = true;
            return String.format("Player %1s Wins!", this.currentPlayer.getPlayerNumber());
        }

        String returnVal = this.currentPlayer.toString();

        // If you don't have an extra turn then change it up
        if (!extraTurn) {
            this.previousPlayer = this.currentPlayer;
            this.currentPlayer = this.nextPlayer;
            this.nextPlayer = this.previousPlayer;
        }

        return returnVal;
    }
}
