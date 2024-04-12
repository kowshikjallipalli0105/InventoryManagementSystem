import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class ExitButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ExitButton");
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 50, 100, 30);
        exitButton.addActionListener(e -> {
        int result = JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        }); 
        frame.add(exitButton);  
        frame.setSize(300, 150);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



