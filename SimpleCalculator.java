import javax.swing.*;

public class SimpleCalculator {

    private JPanel mainPanel;
    private JTextField tfNumber1;
    private JComboBox<String> cbOperations;
    private JTextField tfNumber2;
    private JLabel lblResult;
    private JButton btnCompute;

    public SimpleCalculator(){
        cbOperations.setModel(new DefaultComboBoxModel<>(new String[]{"+", "-", "*", "/"}));
        btnCompute.addActionListener(e -> compute());
    }
    private void compute(){
        try{
            double a = Double.parseDouble(tfNumber1.getText().trim());
            double b = Double.parseDouble(tfNumber2.getText().trim());
            String op = (String) cbOperations.getSelectedItem();
            double result;

            switch(op){
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "*": result = a * b; break;
                case "/":
                    if(b == 0){
                        lblResult.setText("Cannot divide by 0");
                        return;
                    }
                    result = a / b;
                    break;
                default:
                    lblResult.setText("Invalid operator");
                    return;
            }
            if(result == (long) result){
                lblResult.setText(String.valueOf((long) result));
            } else {
                lblResult.setText(String.valueOf(result));
            }
        } catch(NumberFormatException ex){
            lblResult.setText("Invalid input");
        }
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Simple Calculator");
        frame.setContentPane(new SimpleCalculator().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
