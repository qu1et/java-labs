package com.labs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Нажмите");
    private JTextField input1 = new JTextField("", 3);
    private JTextField input2 = new JTextField("", 3);

    public SimpleGUI () {
        super("Простая программа");
        this.setBounds(200, 200, 200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 1, 5, 5));
        container.add(input1);
        container.add(input2);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder msg = new StringBuilder("");
            msg.append("Button was pressed\n");
            msg.append(input1.getText());
            msg.append(" ");
            msg.append(input2.getText());
            JOptionPane.showMessageDialog(null, msg, "Вывод",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}
