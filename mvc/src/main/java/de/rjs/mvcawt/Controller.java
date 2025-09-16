/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.mvcawt;

/**
 *
 * @author ralph
 */
public class Controller {
    private Model model;
    private CounterView view;

    public Controller(Model model, CounterView view) {
        this.model = model;
        this.view = view;

        view.setIncrementAction(() -> {
            model.incrementCounter();
            view.setCounter(model.getCounter());
        });
    }
}
