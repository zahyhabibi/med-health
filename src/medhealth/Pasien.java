/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medhealth;

/**
 *
 * @author ASUS X455L
 */
public class Pasien extends WargaKampus{
   private String ID;
   private String Jenkel;
   private String ket_sakit;
   private String Tanggal;
   private String Email;
   
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
     * @return the ID
     */
    @Override
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    @Override
    public void setID(String ID) {
        this.ID = ID;
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

    /**
     * @return the Jenkel
     */
    @Override
    public String getJenkel() {
        return Jenkel;
    }

    /**
     * @param Jenkel the Jenkel to set
     */
    @Override
    public void setJenkel(String Jenkel) {
        this.Jenkel = Jenkel;
    }

    /**
     * @return the ket_sakit
     */
    @Override
    public String getKet_sakit() {
        return ket_sakit;
    }

    /**
     * @param ket_sakit the ket_sakit to set
     */
    @Override
    public void setKet_sakit(String ket_sakit) {
        this.ket_sakit = ket_sakit;
    }
    
    /**
     * @return the Tanggal
     */
    @Override
    public String getTanggal() {
        return Tanggal;
    }

    /**
     * @param Tanggal the Tanggal to set
     */
    @Override
    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }

    /**
     * @return the Email
     */
    @Override
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    @Override
    public void setEmail(String Email) {
        this.Email = Email;
    }
}
