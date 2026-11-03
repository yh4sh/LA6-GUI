import javax.swing.*;

public class CharacterCounter {
    private JPanel mainPanel;
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel countLabel;

    public CharacterCounter() {

        messageTextArea.setName("messageTextArea");
        characterTextField.setName("characterTextField");
        countButton.setName("countButton");
        countLabel.setName("countLabel");

        countButton.addActionListener(e -> {
            String input = characterTextField.getText();
            if (input.isEmpty()) {
                countLabel.setText("0");
                return;
            }

            char target = input.charAt(0);
            int count = 0;
            for (char c : messageTextArea.getText().toCharArray()) {
                if (c == target) {
                    count++;
                }
            }
            countLabel.setText(String.valueOf(count));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Character Counter");
            frame.setContentPane(new CharacterCounter().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420, 380);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
