/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medhealth;

import medhealth.Views.v_Login;

/**
 *
 * @author LENOVO
 */
public class MedHealth {

    public static WargaKampus pasien = new Pasien();
    public static WargaKampus petugas = new Petugas();
    public static Obat obat = new Obat();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        v_Login vlog = new v_Login();
        vlog.setVisible(true);
    }
    
}
