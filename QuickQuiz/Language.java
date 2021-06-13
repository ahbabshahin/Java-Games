import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Language extends JFrame implements ActionListener {

    String[] questions = {"Which company created Java?",
            "Which year was Java created?",
            "What was Java originally called?",
            "Who is credited with creating Java?",
            "Who is credited with creating C?",
            "Which Operating System is written by C?",
            "When was C language first released?",
            "Which language is not build by C?",
            "Who designed Python?",
            "Which is the filename extention of Python?"};

    String[][] option = {{"Sun Microsystem", "Star Bucks", "Microsoft", "Alphabet"},
            {"1989", "1996", "1972", "1997"},
            {"Apple", "Latte", "Oak", "Coffe"},
            {"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zakerbark"},
            {"Dennis Ritchie ", "Jimmy Carter", "James Rowan", "Mark Sturges"},
            {"Windows 10", "Apple macOS", "Windows Vista", "Linux kernel"},
            {"1960", "1978", "1988", "1999"},
            {"C#", "C++", "Visual Basic", "Julia"},
            {"Guido van Rossum", "Jo Jo Betchler", "Ramioli Gosling", "Marry Cooper"},
            {"pzy", "piy", "phy", "pyw"}};

    char[] answers = {'A', 'B', 'C', 'C', 'A', 'D', 'B', 'C', 'A', 'D'};

    char answer;
    int index;
    int correct_guess = 0;
    int skipped = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 15;

    JTextField textfield = new JTextField();
    JTextArea textArea = new JTextArea();

    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JButton pass = new JButton();

    JLabel answer_levelA = new JLabel();
    JLabel answer_levelB = new JLabel();
    JLabel answer_levelC = new JLabel();
    JLabel answer_levelD = new JLabel();

    JLabel time_level = new JLabel();
    JLabel seconds_left = new JLabel();

    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    JTextField skip = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                displayAnswer();
            }
        }
    });


    Language() {
        this.setTitle("Language");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 650);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        textfield.setBounds(0, 0, 1000, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textArea.setBounds(0, 50, 1000, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25, 255, 0));
        textArea.setFont(new Font("MV Boli", Font.BOLD, 23));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setText("A");
        answer_levelA.setText(option[0][0]);
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setText("B");
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setText("C");
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setText("D");
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);

        pass.setBounds(0, 525, 150, 70);
        pass.setFont(new Font("MV Boli", Font.BOLD, 35));
        pass.setText("Pass->");
        pass.setFocusable(false);
        pass.addActionListener(this);

        answer_levelA.setBounds(125, 100, 1000, 100);
        answer_levelA.setBackground(new Color(50, 50, 50));
        answer_levelA.setForeground(new Color(25, 255, 0));
        answer_levelA.setFont(new Font("MV Boli", Font.PLAIN, 25));


        answer_levelB.setBounds(125, 200, 1000, 100);
        answer_levelB.setBackground(new Color(50, 50, 50));
        answer_levelB.setForeground(new Color(25, 255, 0));
        answer_levelB.setFont(new Font("MV Boli", Font.PLAIN, 25));


        answer_levelC.setBounds(125, 300, 1000, 100);
        answer_levelC.setBackground(new Color(50, 50, 50));
        answer_levelC.setForeground(new Color(25, 255, 0));
        answer_levelC.setFont(new Font("MV Boli", Font.PLAIN, 25));


        answer_levelD.setBounds(125, 400, 1000, 100);
        answer_levelD.setBackground(new Color(50, 50, 50));
        answer_levelD.setForeground(new Color(25, 255, 0));
        answer_levelD.setFont(new Font("MV Boli", Font.PLAIN, 25));


        seconds_left.setBounds(880, 510, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Ink Free", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_level.setBounds(880, 475, 100, 25);
        time_level.setBackground(new Color(50, 50, 50));
        time_level.setForeground(new Color(255, 0, 0));
        time_level.setFont(new Font("MV Boli", Font.PLAIN, 16));
        time_level.setHorizontalAlignment(JTextField.CENTER);
        time_level.setText("timer >:D");

        number_right.setBounds(325, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(325, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        skip.setBounds(525, 225, 300, 200);
        skip.setBackground(new Color(25, 25, 25));
        skip.setForeground(new Color(25, 255, 0));
        skip.setFont(new Font("Ink Free", Font.BOLD, 50));
        skip.setBorder(BorderFactory.createBevelBorder(1));
        skip.setHorizontalAlignment(JTextField.CENTER);
        skip.setEditable(false);


        this.add(time_level);
        this.add(seconds_left);
        this.add(answer_levelA);
        this.add(answer_levelB);
        this.add(answer_levelC);
        this.add(answer_levelD);
        this.add(buttonA);
        this.add(buttonB);
        this.add(buttonC);
        this.add(buttonD);
        this.add(pass);
        this.add(textArea);
        this.add(textfield);

        this.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion() {
        if (index >= total_questions) {
            results();
        } else {
            textfield.setText("Question " + (index + 1));
            textArea.setText(questions[index]);
            answer_levelA.setText(option[index][0]);
            answer_levelB.setText(option[index][1]);
            answer_levelC.setText(option[index][2]);
            answer_levelD.setText(option[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        pass.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = 'A';
            buttonA.setFocusable(true);
            if (answer == answers[index]) {
                correct_guess++;
            }
        }
        if (e.getSource() == buttonB) {
            answer = 'B';;
            buttonB.setFocusable(true);
            if (answer == answers[index]) {
                correct_guess++;
            }
        }
        if (e.getSource() == buttonC) {
            answer = 'C';
            buttonC.setFocusable(true);
            if (answer == answers[index]) {
                correct_guess++;
            }
        }
        if (e.getSource() == buttonD) {
            answer = 'D';
            buttonD.setFocusable(true);
            if (answer == answers[index]) {
                correct_guess++;
            }
        }

        if (e.getSource() == pass)
            skipped++;

        displayAnswer();
    }

    public void displayAnswer() {
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        pass.setEnabled(false);

        if (answers[index] != 'A') {
            answer_levelA.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'B') {
            answer_levelB.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'C') {
            answer_levelC.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'D') {
            answer_levelD.setForeground(new Color(255, 0, 0));
        }
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_levelA.setForeground(new Color(25, 255, 0));
                answer_levelB.setForeground(new Color(25, 255, 0));
                answer_levelC.setForeground(new Color(25, 255, 0));
                answer_levelD.setForeground(new Color(25, 255, 0));

                answer = ' ';
                seconds = 15;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                pass.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        pass.setEnabled(false);

        result = (int) ((correct_guess / (double) total_questions) * 100);

        textfield.setText("Your Score!");
        textArea.setText("");
        answer_levelA.setText("");
        answer_levelB.setText("");
        answer_levelC.setText("");
        answer_levelD.setText("");

        number_right.setText("(" + correct_guess + "/" + total_questions + ")");
        percentage.setText(result + "%");
        skip.setText("Skipped " + skipped);
        this.add(skip);
        this.add(percentage);
        this.add(number_right);
    }
}