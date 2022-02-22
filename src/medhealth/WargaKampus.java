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
public abstract class WargaKampus {
    String Nama;
    String Kelas;
    
    /**
     * @return the Nama
     */
    public String getNama() {
        return Nama;
    }

    /**
     * @param Nama the Nama to set
     */
    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    /**
     * @return the Kelas
     */
    public String getKelas() {
        return Kelas;
    }

    /**
     * @param Kelas the Kelas to set
     */
    public void setKelas(String Kelas) {
        this.Kelas = Kelas;
    }
    
    public void setUsername(String text) {}

    public void setPassword(String text) {}

    public void setNo_hp(String text) {}

    public String getUsername() {
       return null;
    }

    public String getPassword() {
        return null;
    }

    public String getNo_hp() {
        return null;
    }

    public void setID(String text) {}

    public void setJenkel(String toString) {}

    public void setKet_sakit(String text) {}

    public void setJenis_obat(String text) {}

    public void setTanggal(String text) {}

    public String getJenkel() {
        return null;
    }

    public String getID() {
        return null;
    }

    public String getKet_sakit() {
        return null;
    }

    public String getJenis_obat() {
        return null;
    }

    public String getTanggal() {
        return null;
    }

    public void setEmail(String string) {}

    public String getEmail() {
        return null;
    }
}
