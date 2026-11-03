import javax.swing.*;

public class NumberCounter {
    private JPanel mainPanel;
    private JLabel countLabel;
    private JButton increaseButton;
    private JButton decreaseButton;

    private int count = 0;

    public NumberCounter() {

        countLabel.setName("countLabel");
        increaseButton.setName("increaseButton");
        decreaseButton.setName("decreaseButton");

        countLabel.setText(String.valueOf(count));

        increaseButton.addActionListener(e -> {
            count++;
            countLabel.setText(String.valueOf(count));
        });

        decreaseButton.addActionListener(e -> {
            count--;
            countLabel.setText(String.valueOf(count));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Number Counter");
            frame.setContentPane(new NumberCounter().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
