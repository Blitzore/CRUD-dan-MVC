/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import view.FilmManagerFrame;

/**
 *
 * @author nbnrc
 */
public class FilmManagerApp {
    public static void main(String[] args) {
        /* Membuat dan menampilkan form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FilmManagerFrame().setVisible(true);
            }
        });
    }
}
