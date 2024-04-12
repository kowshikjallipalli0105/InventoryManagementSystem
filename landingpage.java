import java.sql.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class landingpage extends JFrame {
    static JTextArea textArea;
    static JScrollPane scrollPane;
    static JTextField textField;
    static JButton listAllButton,addProductButton,updateQuantityButton,updateCostButton,deleteButton,viewProductButton,exitButton,clearButton;
    static JLabel productIdLabel;
    static JTable table;
    static Connection con;
    public static void initializeGUI(Connection con) {
        JFrame frame =new JFrame("Inventory Management System");
        frame.setSize(1000,600);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.lightGray);

        Font font =new Font("MV Boli",Font.BOLD,20);
        
        textArea = new JTextArea();
        textArea.setFont(font);
        textArea.setEditable(false);
        textArea.setText("");

        productIdLabel = new JLabel("Enter Product ID : ");
        productIdLabel.setFont(font);
        productIdLabel.setBounds(200, 5, 250, 30);
        frame.add(productIdLabel);

        textField = new JTextField();
        textField.setFont(font);
        textField.setBounds(400, 5, 200, 30);
        frame.add(textField);

        viewProductButton = new JButton("View Product");
        viewProductButton.setFont(font);
        viewProductButton.setBounds(600, 5, 200, 30);
        frame.add(viewProductButton);

        listAllButton = new JButton("List All Products");
        listAllButton .setFont(font);
        listAllButton.setBounds(10, 40, 210, 30);
        frame.add(listAllButton);

        addProductButton = new JButton("Add Product");
        addProductButton.setFont(font);
        addProductButton.setBounds(220, 40, 180, 30);
        frame.add(addProductButton);

        updateQuantityButton = new JButton("Update Quantity");
        updateQuantityButton.setFont(font);
        updateQuantityButton.setBounds(400, 40, 200, 30);
        frame.add(updateQuantityButton);

        updateCostButton = new JButton("Update Cost");
        updateCostButton.setFont(font);
        updateCostButton.setBounds(600, 40, 180, 30);
        frame.add(updateCostButton);
        
        deleteButton = new JButton("Delete");
        deleteButton.setFont(font);
        deleteButton.setBounds(780, 40, 100, 30);
        frame.add(deleteButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(font);
        exitButton.setBounds(880, 40, 100, 30);
        frame.add(exitButton);

        table = new JTable();
        scrollPane= new JScrollPane(table);
        scrollPane.setBounds(50, 80, 900, 400);
        frame.add(scrollPane);

        clearButton = new JButton("Clear");
        clearButton.setFont(font);
        clearButton.setBounds(500, 500, 100, 30);
        frame.add(clearButton);
        listAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListALLProducts.printTable(table);
            }
            
        });
        ViewProductId.viewProduct(viewProductButton,frame,con,textField);
        
        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddProduct.addNewProduct(table,con);
            }
        });

        updateQuantityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateDb.updateQuantity(con);
            }
        });

        updateCostButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateDb.updateCost(con);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteDb.delete(table,con);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                frame.dispose();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Clear.clearTable(table,textArea);
            }
        });
        
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }



}














