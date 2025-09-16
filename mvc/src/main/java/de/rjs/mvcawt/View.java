/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.mvcawt;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends Frame implements CounterView {
    private Button button = new Button("Increment");
    private Label label = new Label("Counter: 0");

    public View() {
        super("MVC AWT Example");
        setSize(300, 100);
        setLayout(new FlowLayout());

        add(label);
        add(button);

        // Fenster schließen ermöglichen
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
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

