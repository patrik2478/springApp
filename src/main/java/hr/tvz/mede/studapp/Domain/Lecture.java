package hr.tvz.mede.studapp.Domain;

public class Lecture {
    private long id;
    private String ime;
    private String prezime;
    private String brojTelefona;

    public Lecture(long id, String ime, String prezime, String brojTelefona) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }
}


