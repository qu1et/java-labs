package com.labs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI4 extends JFrame {
    private JTextField input = new JTextField("", 3);
    private JButton button = new JButton("Отобразить");

    public SimpleGUI4() {
        super("Простая программа");
        this.setBounds(200, 200, 300, 60);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 2, 5, 5));
        container.add(input);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder msg = new StringBuilder("");
            msg.append(input.getText());

            JOptionPane.showMessageDialog(null, msg, "Информация",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}
