package controller;

import java.util.List;
import DAODataBuku.DataBukuDAO;
import DAOImplement.DataBukuImplement;
import model.*;
import view.MainView;

public class DataBukuController {
    MainView frame;
    DataBukuImplement impldataBuku;
    List<DataBuku> db;
    
    public DataBukuController (MainView frame){
        this.frame = frame;
        impldataBuku = new DataBukuDAO();
        db = impldataBuku.getAll();
    }
    public void isitabel (){
        db = impldataBuku.getAll();
        ModelTabelDataBuku mt = new ModelTabelDataBuku(db);
        frame.getTabelDataBuku().setModel(mt);
    }
    
    public void insert (){
        DataBuku db = new DataBuku();
        db.setJudul(frame.getjTjudul().getText());
        db.setPenulis(frame.getjTpenulis().getText());
        Double rating = Double.parseDouble(frame.getjTrating().getText());
        db.setRating(rating);
        Double hargapinjam = Double.parseDouble(frame.getjThargapinjam().getText());
        Double harga = hargapinjam + 500 + (rating * 100);
        db.setHarga(harga);
        impldataBuku.insert(db);
    }
    
    public void update (){
        DataBuku db = new DataBuku();
        db.setJudul(frame.getjTjudul().getText());
        db.setPenulis(frame.getjTpenulis().getText());
        Double rating = Double.parseDouble(frame.getjTrating().getText());
        db.setRating(rating);
        Double hargapinjam = Double.parseDouble(frame.getjThargapinjam().getText());
        Double harga = hargapinjam + 500 + (rating * 100);
        db.setHarga(harga);
    }
    
    public void delete (){
        String judul = frame.getjTjudul().getText();
        impldataBuku.delete(judul);
    }
}
