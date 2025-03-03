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
        // Configuración de la ventana
        setContentPane(PanelPeliculas);
        setTitle("Catálogo de Películas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
        crearTabla();
    }

    // este es un gran evento que crea toda la tabla con sus escabezados y asigna los datos de la lista
    public void crearTabla() {
        //creamos la estructura de la tabla
        DefaultTableModel tablapelis = new DefaultTableModel(
                //estas son las columnas
                new String[]{"Pelicula", "Genero", "Duracion", "Año Estreno"}, 0
        );

        //llamamos la lista que creamos en gestion de archivos
        ArrayList<String> basePelis = Config.cargarArchivo();

        //se recorre la lista donde cargamos lo del archivo suponiendo que esta separado por comas

        for (String linea : basePelis) {
            String[] fila = linea.split(",");
            if (fila.length == 4) {  // Se comprueba que la línea tenga los 4 datos necesarios
                tablapelis.addRow(fila);
            } else {
                System.out.println("Línea mal formateada: " + linea);
            }
        }

        // cargamos los datos a la tabla
        tablaCatalogo.setModel(tablapelis);



        menuPeliculasDsp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //con esto podemos identificar lo que tiene seleccionado el jcombo
                String generoSeleccionado = menuPeliculasDsp.getSelectedItem().toString();

                //llamamos lo que tiene la tabla actualmente cargado
                DefaultTableModel tablaPelis = (DefaultTableModel) tablaCatalogo.getModel();

                //TableRowSorter este es como una especie de iterador por lineas
                TableRowSorter<DefaultTableModel> lecturaPelis = new TableRowSorter<>(tablaPelis);
                tablaCatalogo.setRowSorter(lecturaPelis);

                //con esto comparamos con el identificador del jcombo y filtramos la tabla
                lecturaPelis.setRowFilter(RowFilter.regexFilter(generoSeleccionado, 1));

                //esto nada mas es para validar si se selecciona todo entonces mostrara todas las peliculas
                if (generoSeleccionado.equals("Todas")) {
                    lecturaPelis.setRowFilter(null);
                } else {
                    lecturaPelis.setRowFilter(RowFilter.regexFilter(generoSeleccionado, 1));
                }
            }
        });
    }

}