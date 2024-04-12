

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Clear {
    public static void clearTable(JTable table, JTextArea textArea) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear table data
        textArea.setText("");
        
    }
}