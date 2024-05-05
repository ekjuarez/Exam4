
// Evan Knudsen

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        File outputFile = new File("C:\\Exam4\\Output.txt");

        System.out.println("Please enter the number of sides of the dice: ");
        int numberOfSides = in.nextInt();
        System.out.println("Please enter the number of players: ");
        int numberOfPlayers = in.nextInt();

        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Integer> rollResults = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter a player's name: ");
            Die playerDie = new Die(numberOfSides);
            Player player = new Player(in.next(), playerDie);
            players.add(player);
        }

        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            currentPlayer.getPlayerDie().roll();
            rollResults.add(currentPlayer.getPlayerDie().getValue());
            System.out.println("Player " + currentPlayer.getName() + " rolled a " + currentPlayer.getPlayerDie().getValue() + " on a " + currentPlayer.getPlayerDie().getNumSides() + " sided die");
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile.getAbsolutePath())) {
            PrintStream printStream = new PrintStream(fileOutputStream);
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);

                printStream.println("Player " + player.getName() + " rolled a " + player.getPlayerDie().getValue() + " on a " + player.getPlayerDie().getNumSides() + " sided die");
            }
        }
        Player winningPlayer = players.get(decideWinner(rollResults));
        System.out.println(winningPlayer.getName() + " won the game.");

    }

    public static int decideWinner(ArrayList<Integer> rollResults) {
        int highestValue = 0;
        for (int i = 0; i < rollResults.size(); i++) {
            if (highestValue < rollResults.get(i)) {
                highestValue = rollResults.get(i);
            }
        }
        return rollResults.indexOf(highestValue);
    }
}
