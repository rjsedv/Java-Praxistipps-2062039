/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.mvcswing1;


import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements CounterView {
    private JButton button = new JButton("Increment");
    private JLabel label = new JLabel("Counter: 0");

    public View() {
        this.setTitle("MVC Swing Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 100);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);
        panel.add(button);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void setCounter(int counter) {
        label.setText("Counter: " + counter);
    }

    @Override
    public void setIncrementAction(Runnable action) {
        button.addActionListener(e -> action.run());
    }

}
