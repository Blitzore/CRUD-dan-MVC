/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.FilmDAO;
import dao.FilmDAOImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Film;
import view.FilmManagerFrame;


/**
 *
 * @author nbnrc
 */
public class FilmController {
    private FilmManagerFrame view;
    private FilmDAO filmDAO;
    private List<Film> filmList;
    private DefaultTableModel tableModel;
    
    public FilmController(FilmManagerFrame view) {
        this.view = view;
        this.filmDAO = new FilmDAOImpl();
        loadFilms();
    }
    
    public void loadFilms() {
        try {
            filmList = filmDAO.getAll();
            tableModel = (DefaultTableModel) view.getFilmTable().getModel();
            tableModel.setRowCount(0);
            
            for (Film film : filmList) {
                Object[] row = {
                    film.getJudul(),
                    film.getNilaiAlur(),
                    film.getNilaiPenokohan(),
                    film.getNilaiAkting(),
                    film.hitungRating()
                };
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tambahFilm() {
        try {
            String judul = view.getJudulTextField().getText();
            String alurText = view.getAlurTextField().getText();
            String penokohanText = view.getPenokohanTextField().getText();
            String aktingText = view.getAktingTextField().getText();
            
            if (judul.isEmpty() || alurText.isEmpty() || penokohanText.isEmpty() || aktingText.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Semua field harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            float alur = Float.parseFloat(alurText);
            float penokohan = Float.parseFloat(penokohanText);
            float akting = Float.parseFloat(aktingText);
            
            // Validasi nilai antara 0-5
            if (alur < 0 || alur > 5 || penokohan < 0 || penokohan > 5 || akting < 0 || akting > 5) {
                JOptionPane.showMessageDialog(view, "Nilai harus antara 0-5", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Film film = new Film(judul, alur, penokohan, akting);
            filmDAO.insert(film);
            
            JOptionPane.showMessageDialog(view, "Film berhasil ditambahkan", "Info", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
            loadFilms();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Nilai harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateFilm() {
        try {
            int selectedRow = view.getFilmTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Pilih film yang akan diupdate", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String judul = view.getJudulTextField().getText();
            String alurText = view.getAlurTextField().getText();
            String penokohanText = view.getPenokohanTextField().getText();
            String aktingText = view.getAktingTextField().getText();
            
            if (judul.isEmpty() || alurText.isEmpty() || penokohanText.isEmpty() || aktingText.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Semua field harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            float alur = Float.parseFloat(alurText);
            float penokohan = Float.parseFloat(penokohanText);
            float akting = Float.parseFloat(aktingText);
            
            // Validasi nilai antara 0-5
            if (alur < 0 || alur > 5 || penokohan < 0 || penokohan > 5 || akting < 0 || akting > 5) {
                JOptionPane.showMessageDialog(view, "Nilai harus antara 0-5", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Film film = filmList.get(selectedRow);
            film.setJudul(judul);
            film.setNilaiAlur(alur);
            film.setNilaiPenokohan(penokohan);
            film.setNilaiAkting(akting);
            
            filmDAO.update(film);
            
            JOptionPane.showMessageDialog(view, "Film berhasil diupdate", "Info", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
            loadFilms();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Nilai harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteFilm() {
        try {
            int selectedRow = view.getFilmTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Pilih film yang akan dihapus", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(view, "Apakah Anda yakin ingin menghapus film ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                Film film = filmList.get(selectedRow);
                filmDAO.delete(film.getId());
                
                JOptionPane.showMessageDialog(view, "Film berhasil dihapus", "Info", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                loadFilms();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void fillFields() {
        int selectedRow = view.getFilmTable().getSelectedRow();
        if (selectedRow != -1) {
            Film film = filmList.get(selectedRow);
            view.getJudulTextField().setText(film.getJudul());
            view.getAlurTextField().setText(String.valueOf(film.getNilaiAlur()));
            view.getPenokohanTextField().setText(String.valueOf(film.getNilaiPenokohan()));
            view.getAktingTextField().setText(String.valueOf(film.getNilaiAkting()));
        }
    }
    
    public void clearFields() {
        view.getJudulTextField().setText("");
        view.getAlurTextField().setText("");
        view.getPenokohanTextField().setText("");
        view.getAktingTextField().setText("");
        view.getFilmTable().clearSelection();
    }
}
