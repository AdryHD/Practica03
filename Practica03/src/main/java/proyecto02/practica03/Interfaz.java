package proyecto02.practica03;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz extends JFrame {
    private JPanel PanelPrincipal;
    private JComboBox menu;
    private JTable TableroJT;
    private JLabel TituloCatalogo;
    private JScrollPane TablaPeliculas;
    private JComboBox<String> DesplegablePeliculas;

    public Interfaz() {
        setContentPane(PanelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        ingresaTabla();
    }

    public void ingresaTabla() {
        DefaultTableModel tablapelis = new DefaultTableModel(
                new String[]{"PELICULA", "GENERO", "TIEMPO", "ESTRENO"}, 0
        );

        ArrayList<String> bdPeli = Config.cargartxt();
        for (String linea : bdPeli) {
            String[] fila = linea.split(",");
            if (fila.length == 4) {
                tablapelis.addRow(fila);
            } else {
                System.out.println("Dato erroneo de la linea: " + linea);
            }
        }

        TableroJT.setModel(tablapelis);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = menu.getSelectedItem().toString();
                DefaultTableModel tablaPeli = (DefaultTableModel) TableroJT.getModel();
                TableRowSorter<DefaultTableModel> lecturaPeli = new TableRowSorter<>(tablaPeli);
                TableroJT.setRowSorter(lecturaPeli);
                lecturaPeli.setRowFilter(RowFilter.regexFilter(genero, 1));
                if (genero.equals("Catalogo")) {
                    lecturaPeli.setRowFilter(null);
                } else {
                    lecturaPeli.setRowFilter(RowFilter.regexFilter(genero, 1));
                }
            }
        });
    }

}