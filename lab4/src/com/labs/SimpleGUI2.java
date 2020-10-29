package com.labs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI2 extends JFrame {
    private JLabel label = new JLabel("Введите имя:");
    private JTextField input = new JTextField("", 3);
    private JButton button = new JButton("Все готово");
    private JCheckBox checkBox = new JCheckBox("Согласны?", false);

    public SimpleGUI2() {
        super("Простая программа");
        this.setBounds(200, 200, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 5, 5));
        container.add(label);
        container.add(input);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
        container.add(checkBox);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder msg = new StringBuilder("");
            msg.append(input.getText());
            msg.append(checkBox.isSelected() ? " согласен" : " не согласен");
            JOptionPane.showMessageDialog(null, msg, "Вывод",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}
