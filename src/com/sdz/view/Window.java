package com.sdz.view;

import com.sdz.model.Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class Window extends JFrame implements Observer {

    private Calculator calc;
    private JLabel resultDisplay;

    public Window() {

        this.calc = new Calculator();
        this.calc.addObserver(this);

        this.setTitle("Calculator");

        this.setSize(250, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Display
        Font police = new Font("DS-digital", Font.PLAIN, 30);
        this.resultDisplay = new JLabel();
        this.resultDisplay.setFont(police);
        this.resultDisplay.setText("34.56"); //TODO Update value and display to right and border

        //Create and fill panel for number buttons
        JPanel numberPanel = new JPanel();
        GridLayout numberGridLayout = new GridLayout(4, 3);
        numberGridLayout.setVgap(5);
        numberGridLayout.setHgap(5);
        numberPanel.setLayout(numberGridLayout);
        Vector<JButton> numberButtons = new Vector<>();
        for (int i = 0; i < 10; i++) {
            numberButtons.add(new JButton(i + ""));
            numberPanel.add(numberButtons.get(i));
        }
        JButton dotButton = new JButton(".");
        JButton eqButton = new JButton("=");
        numberPanel.add(dotButton);
        numberPanel.add(eqButton);

        //Operations panel
        JPanel opPanel = new JPanel();
        GridLayout opGridLayout = new GridLayout(5, 1);
        opGridLayout.setVgap(5);
        opGridLayout.setHgap(5);
        opPanel.setLayout(opGridLayout);

        JButton cButton = new JButton("C");
        cButton.setForeground(Color.RED);
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton multButton = new JButton("*");
        JButton divButton = new JButton("/");

        opPanel.add(cButton);
        opPanel.add(plusButton);
        opPanel.add(minusButton);
        opPanel.add(multButton);
        opPanel.add(divButton);

        //Number panel and Op panel in hor box
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalStrut(5));
        buttonBox.add(numberPanel);
        buttonBox.add(Box.createHorizontalStrut(5));
        buttonBox.add(opPanel);
        buttonBox.add(Box.createHorizontalStrut(5));

        //Hor box and display panel in ver box
        Box mainBox = Box.createVerticalBox();
        mainBox.add(Box.createVerticalStrut(5));
        mainBox.add(this.resultDisplay);
        mainBox.add(Box.createVerticalStrut(5));
        mainBox.add(buttonBox);
        mainBox.add(Box.createVerticalStrut(5));

        this.setContentPane(mainBox);

        this.setVisible(true);

    }

    @Override
    public void update(Observable obs, Object obj) {
        Calculator calc = (Calculator) obs; //TODO check instanceof and handle exception (but ok so far as only Calculator extends Observable
        this.resultDisplay.setText(calc.getResult() + "");
    }

}
