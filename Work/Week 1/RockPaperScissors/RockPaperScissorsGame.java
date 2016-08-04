import java.util.ArrayList;

public class RockPaperScissorsGame {

    private ArrayList<Integer> history;
    private static String[] hands = {"rock", "paper", "scissors"};

    public RockPaperScissorsGame() {
        history = new ArrayList<>();
    }

    public int playHand(String opponentThrow) {

        int result = 1;
        int myThrowGenerator = (int)(Math.random()*100 % 3);
        String myThrow = hands[myThrowGenerator];

        if (myThrow.equals(opponentThrow)) {
            result = 0;
        }

        // CPU = Rock, Player = Scissors
        if (myThrow.equals(hands[0]) && opponentThrow.equals(hands[2]))
            result = -1;
        // CPU = Paper, Player = Rock
        if (myThrow.equals(hands[1]) && opponentThrow.equals(hands[0]))
            result = -1;
        // CPU = Scissors, Player = Paper
        if (myThrow.equals(hands[2]) && opponentThrow.equals(hands[1]))
            result = -1;

        history.add(result);
        return result;
    }

    public String showHistory() {
        if (history.size() <= 0) {
            return "No History";
        }

        int wins=0, losses=0, ties=0;

        for (Integer result: history) {
            switch (result) {
                case 1: wins++;
                    break;
                case -1: losses++;
                    break;
                case 0: ties++;
                    break;
                default:
            }
        }
        return "Wins: " + wins + "\n" +
                    "Losses: " + losses + "\n" +
                    "Ties: " + ties;
    }
}
