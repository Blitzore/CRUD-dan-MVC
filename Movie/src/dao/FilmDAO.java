/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Film;

/**
 *
 * @author nbnrc
 */
public interface FilmDAO {
    public void insert(Film film) throws Exception;
    public void update(Film film) throws Exception;
    public void delete(int id) throws Exception;
    public List<Film> getAll() throws Exception;
}
