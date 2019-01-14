import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java. Level 2* Lesson 4. Homework 4.
 *
 * @author Petrov Nikolay
 * @version dated Jan 11, 2019
 */

public class SimpleChat extends JFrame {
    SimpleChat(){
        setTitle("SimpleChat");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200,400,400);
        JTextArea Chat = new JTextArea();
        Chat.setBackground(Color.lightGray);
        Chat.setEditable(false);
        add(Chat, BorderLayout.CENTER);

        JTextField message = new JTextField();
        message.setSize(100,400);
        JButton send = new JButton("Send");
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(message);
        panel.add(send);
        add(panel,BorderLayout.SOUTH);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent ) {
                Chat.append("Your message: " + message.getText() + "\n");
                message.setText("");
            }
        });
        message.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Chat.append("Your message: " + message.getText() + "\n");
                message.setText("");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleChat();
    }
}