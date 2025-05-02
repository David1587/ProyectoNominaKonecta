package nomina.konecta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class PagoNominaGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Fecha de Pago de Nómina");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JLabel label = new JLabel("Ingrese la fecha (yyyy-mm-dd):");
        JTextField dateField = new JTextField();
        JButton calcularBtn = new JButton("Calcular");
        JButton limpiarBtn = new JButton("Limpiar");
        JLabel resultado = new JLabel("Resultado:");

        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(label);
        panel.add(dateField);
        panel.add(calcularBtn);
        panel.add(limpiarBtn);
        panel.add(resultado);

        calcularBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDate fechaIngresada = LocalDate.parse(dateField.getText());
                    LocalDate fechaPago = FechaPagoUtils.calcularProximaFechaPago(fechaIngresada);
                    resultado.setText("Resultado: " + fechaPago.toString());
                } catch (Exception ex) {
                    resultado.setText("Error: Fecha inválida");
                }
            }
        });

        limpiarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dateField.setText("");
                resultado.setText("Resultado:");
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

// creado por jesus david cortes