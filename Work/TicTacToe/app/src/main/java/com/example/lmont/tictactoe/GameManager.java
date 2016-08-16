package com.example.lmont.tictactoe;

import java.util.ArrayList;

/**
 * Created by lmont on 8/15/2016.
 */
public class GameManager {
    private int scoreX;
    private int scoreO;
    private boolean isXTurn;
    private ArrayList<ArrayList<Integer>> winConditions;
    private ArrayList<Integer> playerX;
    private ArrayList<Integer> playerY;
    int[] buttonClicks;
    int howManyNotOpenButtons;

    public GameManager() {
        winConditions = generateWinConditions();
        resetGame();
    }

    public void resetRound() {
        howManyNotOpenButtons = 0;
        playerX = new ArrayList<>();
        playerY = new ArrayList<>();
        buttonClicks = new int[9];
        for (int resetButton: buttonClicks) resetButton = 0;
    }

    public void resetGame() {
        isXTurn = true;
        scoreX = 0;
        scoreO = 0;
        resetRound();
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public boolean hasButtonBeenClicked(int buttonNum) {
        return (!(buttonClicks[buttonNum] == 0));
    }

    public boolean isValidSet(ArrayList<Integer> playerArray) {
        for (ArrayList<Integer> currentWinCondition : winConditions) {
            if (playerArray.containsAll(currentWinCondition))
                return true;
        }
        return false;
    }

    public boolean isXTurn() {
        return isXTurn;
    }

    public boolean isBoardFull() {
        return howManyNotOpenButtons == 9;
    }

    public void switchTurn() {
        isXTurn = !isXTurn;
    }

    public void addToScore(int winnerValue) {
        if (winnerValue < 0) scoreX++;
        if (winnerValue > 0) scoreO++;
    }

    public int setButton(int buttonIndex, int playerValue) {
        buttonClicks[buttonIndex] = playerValue;
        howManyNotOpenButtons++;
        if (playerValue < 0) {
            playerX.add(buttonIndex);
            if (isValidSet(playerX)) return -1;
        }
        if (playerValue > 0){
            playerY.add(buttonIndex);
            if (isValidSet(playerY)) return 1;
        }
        return 0;
    }

    private ArrayList<ArrayList<Integer>> generateWinConditions() {
        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[]{0, 3, 6});
        arrayList.add(new int[]{1, 4, 7});
        arrayList.add(new int[]{2, 5, 8});
        arrayList.add(new int[]{0, 1, 2});
        arrayList.add(new int[]{3, 4, 5});
        arrayList.add(new int[]{6, 7, 8});
        arrayList.add(new int[]{0, 4, 8});
        arrayList.add(new int[]{2, 4, 6});

        // Convert to arrayLists
        ArrayList<ArrayList<Integer>> winList = new ArrayList<>();
        for(int[] array : arrayList) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int x=0; x< array.length; x++) {
                temp.add(array[x]);
            }
            winList.add(temp);
        }
        return winList;
    }
}
