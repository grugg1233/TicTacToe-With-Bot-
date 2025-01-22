import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame; // Import for BorderFactory

public class TicTacToe extends JFrame implements ActionListener {
    
    private final int SIZE = 3; // Size of the grid (n x n)
    private JButton[][] buttons; // 2D array of buttons

    TicTacToe() {
        // Initialize the frame
        this.setTitle("Tic Tac Toe");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(SIZE, SIZE)); // Use GridLayout for n x n grid

        // Initialize the button grid
        buttons = new JButton[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.LIGHT_GRAY); // Initial background color
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Add border
                buttons[i][j].setFocusable(false); // Remove focus outline
                buttons[i][j].addActionListener(this); // Add action listener
                this.add(buttons[i][j]); // Add button to the frame
            }
        }

        // Make the frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Find which button was clicked and change its color
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (e.getSource() == buttons[i][j]) {
                    buttons[i][j].setBackground(Color.CYAN); // Change color on click
                }
            }
        }
    }


}
