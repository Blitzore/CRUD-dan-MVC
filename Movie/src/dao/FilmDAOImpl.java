/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Film;

/**
 *
 * @author nbnrc
 */
public class FilmDAOImpl implements FilmDAO {
    private Connection connection;
    
    public FilmDAOImpl() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public void insert(Film film) throws Exception {
        String sql = "INSERT INTO film (judul, nilai_alur, nilai_penokohan, nilai_akting) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, film.getJudul());
            statement.setFloat(2, film.getNilaiAlur());
            statement.setFloat(3, film.getNilaiPenokohan());
            statement.setFloat(4, film.getNilaiAkting());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error inserting film: " + e.getMessage());
        }
    }

    @Override
    public void update(Film film) throws Exception {
        String sql = "UPDATE film SET judul = ?, nilai_alur = ?, nilai_penokohan = ?, nilai_akting = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, film.getJudul());
            statement.setFloat(2, film.getNilaiAlur());
            statement.setFloat(3, film.getNilaiPenokohan());
            statement.setFloat(4, film.getNilaiAkting());
            statement.setInt(5, film.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error updating film: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM film WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error deleting film: " + e.getMessage());
        }
    }

    @Override
    public List<Film> getAll() throws Exception {
        List<Film> filmList = new ArrayList<>();
        String sql = "SELECT id, judul, nilai_alur, nilai_penokohan, nilai_akting, nilai_rating FROM film";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                Film film = new Film(
                    resultSet.getInt("id"),
                    resultSet.getString("judul"),
                    resultSet.getFloat("nilai_alur"),
                    resultSet.getFloat("nilai_penokohan"),
                    resultSet.getFloat("nilai_akting")
                );
                filmList.add(film);
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving films: " + e.getMessage());
        }
        return filmList;
    }
}
