import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizFrame extends JFrame implements ActionListener {
    JButton language = new JButton();
    JButton history = new JButton();
    JButton socialMedia = new JButton();
    JButton sports = new JButton();

    QuizFrame() {
        this.setTitle("Quick Quiz");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 500);
        this.setResizable(false);

        JTextField textfield = new JTextField();

        textfield.setBounds(125, 0, 500, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setText("Please Select The Topic");
        textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        this.add(textfield);

        language.setBounds(70, 100, 250, 100);
        language.setText("Language");
        language.setForeground(Color.blue);
        language.setFont(new Font("MV Boli", Font.BOLD, 30));
        language.setFocusable(false);
        language.addActionListener(this);

        history.setBounds(410, 100, 250, 100);
        history.setText("History");
        history.setForeground(Color.blue);
        history.setFont(new Font("MV Boli", Font.BOLD, 30));
        history.setFocusable(false);
        history.addActionListener(this);

        socialMedia.setBounds(70, 250, 250, 100);
        socialMedia.setText("Social Media");
        socialMedia.setForeground(Color.blue);
        socialMedia.setFont(new Font("MV Boli", Font.BOLD, 30));
        socialMedia.setFocusable(false);
        socialMedia.addActionListener(this);

        sports.setBounds(410, 250, 250, 100);
        sports.setText("Sports");
        sports.setForeground(Color.blue);
        sports.setFont(new Font("MV Boli", Font.BOLD, 30));
        sports.setFocusable(false);
        sports.addActionListener(this);

        this.add(language);
        this.add(history);
        this.add(socialMedia);
        this.add(sports);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        language.setEnabled(false);
        history.setEnabled(false);
        socialMedia.setEnabled(false);
        sports.setEnabled(false);

        if (e.getSource() == language)
            new Language();

        if (e.getSource() == history)
            new History();

        if (e.getSource() == socialMedia)
            new SocialMedia();

        if (e.getSource() == sports)
            new Sports();
    }
}
