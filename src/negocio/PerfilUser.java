package negocio;

import java.util.ArrayList;

public class PerfilUser {
    private String user;
    private String pass;
    private ArrayList<Afinidade> afinidades;

    public PerfilUser(String user, String pass, ArrayList<Afinidade> afinidades) {
        this.user = user;
        this.pass = pass;
        this.afinidades = afinidades;
    }

    public PerfilUser(ArrayList<Afinidade> afinidades) {
        this.afinidades = afinidades;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<Afinidade> getafinidades() {
        return afinidades;
    }

    public void setAfinidades(ArrayList<Afinidade> afinidades) {
        this.afinidades = afinidades;
    }

    public String getUsername() {
        return user;
    }
}
