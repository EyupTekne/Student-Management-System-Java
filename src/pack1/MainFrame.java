package pack1;
import javax.swing.*;
public class MainFrame extends JFrame {
	public MainFrame() {
        setTitle("Ana Menü");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);

        JButton addStudentButton = new JButton("Öğrenci Ekle");
        addStudentButton.setBounds(50, 50, 150, 30);
        panel.add(addStudentButton);

        JButton listStudentsButton = new JButton("Öğrencileri Listele");
        listStudentsButton.setBounds(50, 100, 150, 30);
        panel.add(listStudentsButton);

        addStudentButton.addActionListener(e -> new AddStudentFrame().setVisible(true));
        listStudentsButton.addActionListener(e -> new ListStudentsFrame().setVisible(true));

        setLocationRelativeTo(null); // Ortala
    }

}
