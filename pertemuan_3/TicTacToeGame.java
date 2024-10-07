package pertemuan_3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame implements ActionListener {
    private JFrame frame;
    private JButton[] buttons = new JButton[9];
    private boolean playerXTurn = true;

    public TicTacToeGame() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setLayout(new GridLayout(3, 3)); // 3x3 GridLayout for the Tic-Tac-Toe board

        // Initialize buttons and add them to the frame
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60)); // Set font size for "X" and "O"
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
        }

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        // Only allow action if the button is empty
        if (clickedButton.getText().equals("")) {
            if (playerXTurn) {
                clickedButton.setText("X");
            } else {
                clickedButton.setText("O");
            }
            playerXTurn = !playerXTurn; // Switch turn
            checkForWinner(); // Check if someone won
        }
    }

    private void checkForWinner() {
        // Define winning combinations
        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horizontal
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Vertical
                {0, 4, 8}, {2, 4, 6}             // Diagonal
        };

        for (int[] combo : winningCombinations) {
            if (buttons[combo[0]].getText().equals(buttons[combo[1]].getText()) &&
                    buttons[combo[1]].getText().equals(buttons[combo[2]].getText()) &&
                    !buttons[combo[0]].getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Player " + buttons[combo[0]].getText() + " wins!");
                resetBoard();
                return;
            }
        }

        // Check for a draw (if all buttons are filled)
        boolean draw = true;
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                draw = false;
                break;
            }
        }
        if (draw) {
            JOptionPane.showMessageDialog(frame, "It's a draw!");
            resetBoard();
        }
    }

    private void resetBoard() {
        // Reset the board for a new game
        for (JButton button : buttons) {
            button.setText("");
        }
        playerXTurn = true; // X always starts first
    }

    public static void main(String[] args) {
        new TicTacToeGame();
    }
}
