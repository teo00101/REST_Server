/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1;

/**
 *
 * @author informatica
 */
public class Impiegato {
    private int id;
    private String nome;
    private String cognome;
    private String mail;
    private String numTel;

    public Impiegato(int id, String nome, String cognome, String mail, String numTel) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.numTel = numTel;
    }

    public Impiegato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    
    
}
