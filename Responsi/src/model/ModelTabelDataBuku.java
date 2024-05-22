package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelDataBuku extends AbstractTableModel {
    
    List<DataBuku> db;
    public ModelTabelDataBuku (List<DataBuku>db){
        this.db = db;
    }
    
    @Override
    public int getRowCount (){
        return db.size();
    }
    
    @Override
    public int getColumnCount (){
        return 5;
    }
    
    public String getColumnName (int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Penulis";
            case 2:
                return "Rating";
            case 3:
                return "Harga";
            case 4:
                return "id";
            default:
                return null;
        }
    }
    
    public Object getValueAt (int row, int column){
        switch (column){
            case 0:
                return db.get(row).getJudul();
            case 1:
                return db.get(row).getPenulis();
            case 2:
                return db.get(row).getRating();
            case 3:
                return db.get(row).getHarga();
            case 4:
                return db.get(row).getId();
            default:
                return null;
        }
    }
}
