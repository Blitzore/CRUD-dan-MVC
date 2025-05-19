/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author nbnrc
 */
public interface FilmInterface {
    public String getJudul();
    public void setJudul(String judul);
    
    public float getNilaiAlur();
    public void setNilaiAlur(float nilaiAlur);
    
    public float getNilaiPenokohan();
    public void setNilaiPenokohan(float nilaiPenokohan);
    
    public float getNilaiAkting();
    public void setNilaiAkting(float nilaiAkting);
    
    public float hitungRating();
}
