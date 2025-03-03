package proyecto02.practica03;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz extends JFrame {
    private JPanel PanelPeliculas;
    private JComboBox menuPeliculasDsp;
    private JTable tablaCatalogo;
    private JLabel TituloPanel;
    private JScrollPane TablaTotal;
    private JComboBox<String> DesplegablePeliculas;


    public Interfaz() {

        setContentPane(PanelPeliculas);
        setTitle("Catálogo de Películas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setVisible(true);
        crearTabla();
    }


    public void crearTabla() {
        DefaultTableModel tablapelis = new DefaultTableModel(
                new String[]{"Pelicula", "Genero", "Tiempo", "Año Estreno"}, 0
        );

        ArrayList<String> basePelis = Config.cargartxt();



        for (String linea : basePelis) {
            String[] fila = linea.split(",");
            if (fila.length == 4) {
                tablapelis.addRow(fila);
            } else {
                System.out.println("Línea erronea: " + linea);
            }
        }

        tablaCatalogo.setModel(tablapelis);



        menuPeliculasDsp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String generoSeleccionado = menuPeliculasDsp.getSelectedItem().toString();

                DefaultTableModel tablaPelis = (DefaultTableModel) tablaCatalogo.getModel();

                TableRowSorter<DefaultTableModel> lecturaPelis = new TableRowSorter<>(tablaPelis);
                tablaCatalogo.setRowSorter(lecturaPelis);

                lecturaPelis.setRowFilter(RowFilter.regexFilter(generoSeleccionado, 1));

                if (generoSeleccionado.equals("Catalogo")) {
                    lecturaPelis.setRowFilter(null);
                } else {
                    lecturaPelis.setRowFilter(RowFilter.regexFilter(generoSeleccionado, 1));
                }
            }
        });
    }

}