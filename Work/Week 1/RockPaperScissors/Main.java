import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame();

        boolean isDone = false;
        while (!isDone) {
            String playerChoice = JOptionPane.showInputDialog("Rock Paper Scissors? Exit?");
            if (playerChoice.toLowerCase().equals("exit")) {
                isDone = true;
                break; // redundant?
            }

            if (!(playerChoice.toLowerCase().equals("rock") ||
                    playerChoice.toLowerCase().equals("paper") ||
                    playerChoice.toLowerCase().equals("sciessors")))
            {
                JOptionPane.showMessageDialog(null, "Invalid Input");
                continue;
            }
            else {
                JOptionPane.showMessageDialog(null, game.playHand(playerChoice.toLowerCase()));
            }
        }

        JOptionPane.showMessageDialog(null, game.showHistory());
    }

}