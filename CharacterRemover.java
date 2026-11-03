import javax.swing.*;

public class CharacterRemover {
    private static final String ORIGINAL_TEXT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String VOWELS = "AEIOUaeiou";

    private JPanel mainPanel;
    private JCheckBox vowelCheckbox;
    private JCheckBox consonantCheckbox;
    private JCheckBox numberCheckbox;
    private JButton removeButton;
    private JButton restoreButton;
    private JLabel textLabel;

    public CharacterRemover() {

        vowelCheckbox.setName("vowelCheckbox");
        consonantCheckbox.setName("consonantCheckbox");
        numberCheckbox.setName("numberCheckbox");
        removeButton.setName("removeButton");
        restoreButton.setName("restoreButton");
        textLabel.setName("textLabel");

        textLabel.setText(ORIGINAL_TEXT);

        removeButton.addActionListener(e -> {
            StringBuilder result = new StringBuilder();
            for (char c : textLabel.getText().toCharArray()) {
                if (!shouldRemove(c)) {
                    result.append(c);
                }
            }
            textLabel.setText(result.toString());
        });

        restoreButton.addActionListener(e -> {
            textLabel.setText(ORIGINAL_TEXT);
            vowelCheckbox.setSelected(false);
            consonantCheckbox.setSelected(false);
            numberCheckbox.setSelected(false);
        });
    }

    private boolean shouldRemove(char c) {
        if (Character.isDigit(c)) {
            return numberCheckbox.isSelected();
        }
        if (Character.isLetter(c)) {
            if (VOWELS.indexOf(c) >= 0) {
                return vowelCheckbox.isSelected();
            }
            return consonantCheckbox.isSelected();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Character Remover");
            frame.setContentPane(new CharacterRemover().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(460, 260);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
