package com.labs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI3 extends JFrame {
    private JLabel label = new JLabel("Введите число:");
    private JTextField input = new JTextField("", 3);
    public JButton button = new JButton("Скрыть поле");

    public SimpleGUI3() {
        super("Простая программа");
        this.setBounds(200, 200, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 5, 5));
        input.setBackground(Color.red);

        container.add(label);
        container.add(input);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String defaultText = "Скрыть поле";

            if (e.getSource() == button) {
                if (button.getText().equals(defaultText)) {
                    button.setText("Показать поле");
                    input.setVisible(false);
                } else {
                    button.setText(defaultText);
                    input.setVisible(true);
                }
            }
        }
    }
}
