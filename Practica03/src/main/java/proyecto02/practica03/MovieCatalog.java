/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyecto02.practica03;

/**
 *
 * @author adryhd
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MovieCatalog extends JFrame {
    private ArrayList<Movie> movies;
    private JComboBox<String> genreComboBox;
    private JTable movieTable;
    private JTextArea movieDetails;

    public MovieCatalog() {
        movies = new ArrayList<>();
        loadMoviesFromFile("movies.txt");
        initializeGUI();
    }

    private void loadMoviesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String genre = data[1];
                int duration = Integer.parseInt(data[2]);
                int releaseYear = Integer.parseInt(data[3]);

                switch (genre.toLowerCase()) {
                    case "terror":
                        movies.add(new HorrorMovie(name, duration, releaseYear));
                        break;
                    case "comedia":
                        movies.add(new ComedyMovie(name, duration, releaseYear));
                        break;
                    case "accion":
                        movies.add(new ActionMovie(name, duration, releaseYear));
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeGUI() {
        setTitle("Catálogo de Películas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Genre selector
        JPanel topPanel = new JPanel();
        genreComboBox = new JComboBox<>(new String[]{"Todos", "Terror", "Comedia", "Acción"});
        genreComboBox.addActionListener(e -> updateMovieTable());
        topPanel.add(new JLabel("Género: "));
        topPanel.add(genreComboBox);
        add(topPanel, BorderLayout.NORTH);

        // Movie table
        movieTable = new JTable();
        movieTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        movieTable.getSelectionModel().addListSelectionListener(e -> showMovieDetails());
        add(new JScrollPane(movieTable), BorderLayout.CENTER);

        // Movie details
        movieDetails = new JTextArea(5, 40);
        movieDetails.setEditable(false);
        add(new JScrollPane(movieDetails), BorderLayout.SOUTH);

        updateMovieTable();
        
        pack();
        setLocationRelativeTo(null);
    }

    private void updateMovieTable() {
        String selectedGenre = (String) genreComboBox.getSelectedItem();
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"Nombre", "Género", "Duración", "Año"}, 0
        );

        for (Movie movie : movies) {
            if (selectedGenre.equals("Todos") || movie.getGenre().equals(selectedGenre)) {
                model.addRow(new Object[]{
                    movie.getName(),
                    movie.getGenre(),
                    movie.getDuration(),
                    movie.getReleaseYear()
                });
            }
        }

        movieTable.setModel(model);
    }

    private void showMovieDetails() {
        int selectedRow = movieTable.getSelectedRow();
        if (selectedRow >= 0) {
            String name = (String) movieTable.getValueAt(selectedRow, 0);
            String genre = (String) movieTable.getValueAt(selectedRow, 1);
            int duration = (int) movieTable.getValueAt(selectedRow, 2);
            int year = (int) movieTable.getValueAt(selectedRow, 3);

            String details = String.format("""
                Detalles de la Película:
                Nombre: %s
                Género: %s
                Duración: %d minutos
                Año de estreno: %d
                """, name, genre, duration, year);
            
            movieDetails.setText(details);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MovieCatalog().setVisible(true);
        });
    }
}