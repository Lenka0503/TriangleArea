package main.java.by.hodorenko.triangleareaapp;

import javax.swing.*;
import java.awt.*;

public class TriangleAreaApp extends JFrame {

    public TriangleAreaApp() {
        setTitle("Расчет площади треугольника");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        setLocationRelativeTo(null);

        JTextField aField = new JTextField();
        JTextField bField = new JTextField();
        JTextField cField = new JTextField();
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JButton calculateButton = new JButton("Рассчитать");
        JButton clearButton = new JButton("Очистить");

        calculateButton.addActionListener(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                double c = Double.parseDouble(cField.getText());

                if (a <= 0 || b <= 0 || c <= 0 ||
                        a + b <= c || a + c <= b || b + c <= a) {
                    JOptionPane.showMessageDialog(this,
                            "Треугольник с такими сторонами не существует");
                    return;
                }

                double p = (a + b + c) / 2;
                double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                resultField.setText(String.format("%.2f", area));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Введите корректные числовые значения");
            }
        });

        clearButton.addActionListener(e -> {
            aField.setText("");
            bField.setText("");
            cField.setText("");
            resultField.setText("");
        });

        add(new JLabel("Сторона A:"));
        add(aField);
        add(new JLabel("Сторона B:"));
        add(bField);
        add(new JLabel("Сторона C:"));
        add(cField);
        add(calculateButton);
        add(clearButton);
        add(resultField);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new TriangleAreaApp().setVisible(true));
    }
}
