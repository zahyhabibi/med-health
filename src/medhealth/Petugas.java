/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medhealth;

import medhealth.Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author ASUS X455L
 */
public class Petugas extends WargaKampus implements PMR{
    private String Username;
    private String Password;
    private String no_hp;

    /**
     * @return the Username
     */
    @Override
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    @Override
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    @Override
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    @Override
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the no_hp
     */
    @Override
    public String getNo_hp() {
        return no_hp;
    }

    /**
     * @param no_hp the no_hp to set
     */
    @Override
    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
    /**
     * @return the Nama
     */
    @Override
    public String getNama() {
        return Nama;
    }

    /**
     * @param Nama the Nama to set
     */
    @Override
    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    /**
     * @return the Kelas
     */
    @Override
    public String getKelas() {
        return Kelas;
    }

    /**
     * @param Kelas the Kelas to set
     */
    @Override
    public void setKelas(String Kelas) {
        this.Kelas = Kelas;
    }
    
    Connection koneksi;
    // INTERFACE METHOD
    @Override
    public void mengisiData(JTextField txtKdObat, JTextField txtMerk, JTextField txtEXP, JComboBox cmbJenis, JTextField txtStok, JTextField txtKet) {
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "db_medhealt");
        
        MedHealth.obat.setKd_obat(txtKdObat.getText());
        MedHealth.obat.setMerk(txtMerk.getText());
        MedHealth.obat.setTanggal_kadaluarsa(txtEXP.getText());
        MedHealth.obat.setJenis_obat(cmbJenis.getSelectedItem().toString());
        MedHealth.obat.setStok_obat(txtStok.getText());
        MedHealth.obat.setKet_obat(txtKet.getText());
        
        try{
            Statement stmt = koneksi.createStatement();
            String query = "INSERT INTO obat(kd_obat, merk, tanggal_kadaluarsa, jenis_obat, stok_obat, ket_obat)" +
                    " VALUES('" + MedHealth.obat.getKd_obat() + "','" + MedHealth.obat.getMerk() + "','" + MedHealth.obat.getTanggal_kadaluarsa()
                    + "','" + MedHealth.obat.getJenis_obat() + "','" + MedHealth.obat.getStok_obat() + "','" + MedHealth.obat.getKet_obat() + "')";
            
            if(MedHealth.obat.getKd_obat().equals("") || MedHealth.obat.getMerk().equals("") || MedHealth.obat.getTanggal_kadaluarsa().equals("") || MedHealth.obat.getJenis_obat().equals("") || MedHealth.obat.getStok_obat().equals("") || MedHealth.obat.getKet_obat().equals("")){
                JOptionPane.showMessageDialog(null, "Form tidak boleh kosong!", "FAILED", JOptionPane.ERROR_MESSAGE);
                System.out.println(query + " Error!");
                return;
 
            }else{
                System.out.println(query);
                int berhasil = stmt.executeUpdate(query);
                if(berhasil == 1){
                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
                }else{
                    JOptionPane.showMessageDialog(null, "Data gagal ditambahkan");
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // OVERLOAD
    public void mengisiData(JTextField txtNama, JTextField txtKelas, JComboBox cmbJenkel, JTextField txtSakit, JTextField txtTanggal, JTextField txtEmail){
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "db_medhealt");
        
        MedHealth.pasien = new Pasien();
        MedHealth.pasien.setNama(txtNama.getText());
        MedHealth.pasien.setKelas(txtKelas.getText());
        MedHealth.pasien.setJenkel(cmbJenkel.getSelectedItem().toString());
        MedHealth.pasien.setKet_sakit(txtSakit.getText());
        MedHealth.pasien.setTanggal(txtTanggal.getText());
        MedHealth.pasien.setEmail(txtEmail.getText());
        
        try{
            Statement stmt = koneksi.createStatement();
            String query = "INSERT INTO pasien(nama, ruangan, jengkel, ket_sakit, tanggal, email)" +
                            "VALUES('" + MedHealth.pasien.getNama() + "','" + MedHealth.pasien.getKelas()
                    + "','" + MedHealth.pasien.getJenkel() + "','" + MedHealth.pasien.getKet_sakit() + "','" 
                    + MedHealth.pasien.getTanggal() + "','" + MedHealth.pasien.getEmail() +  "')";
                
                if(MedHealth.pasien.getNama().equals("") || MedHealth.pasien.getKelas().equals("") || MedHealth.pasien.getJenkel().equals("[ JENKEL ]") || MedHealth.pasien.getKet_sakit().equals("") || MedHealth.pasien.getTanggal().equals("")){
                JOptionPane.showMessageDialog(null, "Form tidak boleh kosong!", "FAILED", JOptionPane.ERROR_MESSAGE);
                System.out.println(query + " Error!");
                return;
                }else{
                    System.out.println(query);
                    int berhasil = stmt.executeUpdate(query);
                    if(berhasil == 1){
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                    }else{
                        JOptionPane.showMessageDialog(null, "Data gagal dimasukan");
                    } 
                }
            stmt.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Implements Method Edit data obat
    @Override
    public void mengeditData(JTextField txtKdObat, JTextField txtMerk, JTextField txtEXP, JComboBox cmbJenis, JTextField txtStok, JTextField txtKet) {
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "db_medhealt");
        
        MedHealth.obat.setKd_obat(txtKdObat.getText());
        MedHealth.obat.setMerk(txtMerk.getText());
        MedHealth.obat.setTanggal_kadaluarsa(txtEXP.getText());
        MedHealth.obat.setJenis_obat(cmbJenis.getSelectedItem().toString());
        MedHealth.obat.setKd_obat(txtKdObat.getText());
        MedHealth.obat.setStok_obat(txtStok.getText());
        MedHealth.obat.setKet_obat(txtKet.getText());
        
        try{
            Statement stmt = koneksi.createStatement();
            String query = "UPDATE obat SET merk = '" + MedHealth.obat.getMerk() + "'," + "tanggal_kadaluarsa = '" 
                    + MedHealth.obat.getTanggal_kadaluarsa() + "'," 
                    + "jenis_obat = '" + MedHealth.obat.getJenis_obat() 
                    + "'," + "stok_obat = '" + MedHealth.obat.getStok_obat() + "'," 
                    + "ket_obat = '" + MedHealth.obat.getKet_obat() + "' WHERE kd_obat ='" + MedHealth.obat.getKd_obat() + "'";
            System.out.println(query);
            int berhasil = stmt.executeUpdate(query);
            if(berhasil == 1){
                JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            }else{
                JOptionPane.showMessageDialog(null, "Data gagal diubah");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // OVERLOAD method untuk mengedit data
    public void mengeditData(String txtID, JTextField txtNama, JTextField txtKelas, JComboBox cmbJenkel, JTextField txtSakit, JTextField txtTanggal, JTextField txtEmail){
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "db_medhealt");
        
        MedHealth.pasien.setID(txtID);
        MedHealth.pasien.setNama(txtNama.getText());
        MedHealth.pasien.setKelas(txtKelas.getText());
        MedHealth.pasien.setJenkel(cmbJenkel.getSelectedItem().toString());
        MedHealth.pasien.setKet_sakit(txtSakit.getText());
        MedHealth.pasien.setTanggal(txtTanggal.getText());
        MedHealth.pasien.setEmail(txtEmail.getText());
        
        try{
            Statement stmt = koneksi.createStatement();
            String query = "UPDATE pasien SET nama ='" + MedHealth.pasien.getNama() + "'," 
                    + "ruangan = '" + MedHealth.pasien.getKelas() + "'," + "jengkel = '" + MedHealth.pasien.getJenkel() + "'," 
                    + "ket_sakit = '" + MedHealth.pasien.getKet_sakit() +  "'," 
                    + "tanggal = '" + MedHealth.pasien.getTanggal() + "'," + "email = '" + MedHealth.pasien.getEmail() 
                    + "' WHERE id ='" + MedHealth.pasien.getID() + "'";
            System.out.println(query);
            int berhasil = stmt.executeUpdate(query);
            if(berhasil == 1){
                JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            }else{
                JOptionPane.showMessageDialog(null, "Data gagal diubah");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
