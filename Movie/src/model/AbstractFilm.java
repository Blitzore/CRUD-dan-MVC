/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nbnrc
 */
public abstract class AbstractFilm implements FilmInterface {
    protected String judul;
    protected float nilaiAlur;
    protected float nilaiPenokohan;
    protected float nilaiAkting;
    protected int id;
    
    public AbstractFilm() {
    }
    
    public AbstractFilm(String judul, float nilaiAlur, float nilaiPenokohan, float nilaiAkting) {
        this.judul = judul;
        this.nilaiAlur = nilaiAlur;
        this.nilaiPenokohan = nilaiPenokohan;
        this.nilaiAkting = nilaiAkting;
    }
    
    public AbstractFilm(int id, String judul, float nilaiAlur, float nilaiPenokohan, float nilaiAkting) {
        this.id = id;
        this.judul = judul;
        this.nilaiAlur = nilaiAlur;
        this.nilaiPenokohan = nilaiPenokohan;
        this.nilaiAkting = nilaiAkting;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getJudul() {
        return judul;
    }

    @Override
    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Override
    public float getNilaiAlur() {
        return nilaiAlur;
    }

    @Override
    public void setNilaiAlur(float nilaiAlur) {
        this.nilaiAlur = nilaiAlur;
    }

    @Override
    public float getNilaiPenokohan() {
        return nilaiPenokohan;
    }

    @Override
    public void setNilaiPenokohan(float nilaiPenokohan) {
        this.nilaiPenokohan = nilaiPenokohan;
    }

    @Override
    public float getNilaiAkting() {
        return nilaiAkting;
    }

    @Override
    public void setNilaiAkting(float nilaiAkting) {
        this.nilaiAkting = nilaiAkting;
    }
    
    @Override
    public float hitungRating() {
        return (nilaiAlur + nilaiPenokohan + nilaiAkting) / 3;
    }
}
