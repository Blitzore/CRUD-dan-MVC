/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nbnrc
 */
public class Film extends AbstractFilm {
    
    public Film() {
        super();
    }
    
    public Film(String judul, float nilaiAlur, float nilaiPenokohan, float nilaiAkting) {
        super(judul, nilaiAlur, nilaiPenokohan, nilaiAkting);
    }
    
    public Film(int id, String judul, float nilaiAlur, float nilaiPenokohan, float nilaiAkting) {
        super(id, judul, nilaiAlur, nilaiPenokohan, nilaiAkting);
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", judul=" + judul + ", nilaiAlur=" + nilaiAlur + 
               ", nilaiPenokohan=" + nilaiPenokohan + ", nilaiAkting=" + nilaiAkting + 
               ", rating=" + hitungRating() + '}';
    }
}
