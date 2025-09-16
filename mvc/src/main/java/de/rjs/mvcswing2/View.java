/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.mvcswing2;


import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements CounterView {
    private final JButton incrementButton = new JButton("➕ Add");
    private final JLabel counterLabel = new JLabel("Count: 0");

    public View() {
        super("Modern MVC Swing View");

        // Layout vertikal
        setLayout(new BorderLayout(10, 10));

        // Label oben, Button unten
        counterLabel.setFont(new Font("Arial", Font.BOLD, 24));
        counterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        counterLabel.setForeground(Color.BLUE);

        incrementButton.setFont(new Font("Arial", Font.BOLD, 20));
        incrementButton.setBackground(Color.LIGHT_GRAY);

        add(counterLabel, BorderLayout.CENTER);
        add(incrementButton, BorderLayout.SOUTH);

        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // zentrieren
        setVisible(true);
    }

    @Override
    public void setCounter(int counter) {
        counterLabel.setText("Count: " + counter);
    }

    @Override
    public void setIncrementAction(Runnable action) {
        incrementButton.addActionListener(e -> action.run());
    }
}
