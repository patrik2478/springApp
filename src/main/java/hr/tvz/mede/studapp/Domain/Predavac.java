package hr.tvz.mede.studapp.Domain;

public class Predavac {
    private String ime;
    private String datumUpisa;
    private long id;
    private String pozicija;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getDatumUpisa() {
        return datumUpisa;
    }

    public void setDatumUpisa(String datumUpisa) {
        this.datumUpisa = datumUpisa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }


}
