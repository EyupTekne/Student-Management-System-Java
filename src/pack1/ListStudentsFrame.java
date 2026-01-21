package pack1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListStudentsFrame extends JFrame {
    public ListStudentsFrame() {
        setTitle("Öğrencileri Listele");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "İsim", "Soyisim", "Numara", "Sınıf"});
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 460, 300);
        panel.add(scrollPane);

        try (Connection conn = DatabaseConnection.connect()) {
            String query = "SELECT * FROM ogrenciler";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("isim"),
                        rs.getString("soyisim"),
                        rs.getString("numara"),
                        rs.getString("sinif")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hata: " + e.getMessage());
        }

        setLocationRelativeTo(null); // Ortala
    }
}

