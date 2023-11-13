package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

public class DuckRaceApp {
    private final Board board = Board.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void run(){
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput){
            System.out.println("Please [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")){
                validInput = true;
                reward = ("D".equals(input)) ? Reward.DEBIT_CARD : Reward.PRIZES;
            }
        }
        return reward;
    }

    private int promptForId() { //TODO: Don't hardcode 19
        int id = 0;

        boolean validInput = false;
        while (!validInput){
            System.out.print("ID must be between 1 & 19: ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{1,2}")){
                id = Integer.parseInt(input);
                if (1 <= id && id <= 19){
                    validInput = true;
                }
            }
        }

        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("------------------------------------------");
        System.out.println("HOWDY PARTNER, WELCOME TO THE DUCKRACE APP");
        System.out.println("------------------------------------------");
        System.out.println();
    }
}
