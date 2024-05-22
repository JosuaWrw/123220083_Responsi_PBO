package model;

public class DataBuku {
    private String judul;
    private String penulis;
    private double rating;
    private double harga;
    private double id;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String Judul) {
        this.judul = Judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String Penulis) {
        this.penulis = Penulis;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
