package pack1;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddStudentFrame extends JFrame {
    public AddStudentFrame() {
        setTitle("Öğrenci Ekle");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JLabel nameLabel = new JLabel("İsim:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(100, 20, 165, 25);
        panel.add(nameField);

        JLabel surnameLabel = new JLabel("Soyisim:");
        surnameLabel.setBounds(10, 60, 80, 25);
        panel.add(surnameLabel);

        JTextField surnameField = new JTextField(20);
        surnameField.setBounds(100, 60, 165, 25);
        panel.add(surnameField);

        JLabel numberLabel = new JLabel("Numara:");
        numberLabel.setBounds(10, 100, 80, 25);
        panel.add(numberLabel);

        JTextField numberField = new JTextField(20);
        numberField.setBounds(100, 100, 165, 25);
        panel.add(numberField);

        JLabel classLabel = new JLabel("Sınıf:");
        classLabel.setBounds(10, 140, 80, 25);
        panel.add(classLabel);

        JTextField classField = new JTextField(20);
        classField.setBounds(100, 140, 165, 25);
        panel.add(classField);

        JButton saveButton = new JButton("Kaydet");
        saveButton.setBounds(100, 180, 100, 25);
        panel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String surname = surnameField.getText().trim();
                String number = numberField.getText().trim();
                String className = classField.getText().trim();

                if (name.isEmpty() || surname.isEmpty() || number.isEmpty() || className.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!");
                    return;
                }

                try (Connection conn = DatabaseConnection.connect()) {
                    String query = "INSERT INTO ogrenciler (isim, soyisim, numara, sinif) VALUES (?, ?, ?, ?)";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setString(1, name);
                    ps.setString(2, surname);
                    ps.setString(3, number);
                    ps.setString(4, className);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Öğrenci başarıyla eklendi!");
                    dispose(); // Pencereyi kapat
                } catch (Exception ex) {
                    ex.printStackTrace(); // Detaylı hata çıktısı
                    JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage());
                }
            }
        });


        setLocationRelativeTo(null); // Ortala
    }
}
