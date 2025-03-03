package proyecto02.practica03;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz extends JFrame {
    private JPanel JPPrincipal;
    private JComboBox menu;
    private JTable JTablero;
    private JLabel TtlCatalogo;
    private JScrollPane TablaLista;

    public Interfaz() {
        setContentPane(JPPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        ingresaTabla();
    }

    public void ingresaTabla() {
        DefaultTableModel tabla = new DefaultTableModel(
                new String[]{"PELICULA", "GENERO", "TIEMPO", "ESTRENO"}, 0
        );
        ArrayList<String> bdPeli = Config.cargartxt();
        for (String linea : bdPeli) {
            String[] fila = linea.split(",");
            if (fila.length == 4) {
                tabla.addRow(fila);
            } else {
                System.out.println("Dato erroneo de la linea: " + linea);
            }
        }

        JTablero.setModel(tabla);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = menu.getSelectedItem().toString();
                DefaultTableModel tablaPeli = (DefaultTableModel) JTablero.getModel();
                TableRowSorter<DefaultTableModel> lectura = new TableRowSorter<>(tablaPeli);
                JTablero.setRowSorter(lectura);
                lectura.setRowFilter(RowFilter.regexFilter(genero, 1));
                if (genero.equals("Lista")) {
                    lectura.setRowFilter(null);
                } else {
                    lectura.setRowFilter(RowFilter.regexFilter(genero, 1));
                }
            }
        });
    }
}