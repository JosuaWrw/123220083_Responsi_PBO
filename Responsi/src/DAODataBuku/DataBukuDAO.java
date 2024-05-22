package DAODataBuku;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.DataBukuImplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBukuDAO implements DataBukuImplement {
    Connection connection;
    
    final String select = "SELECT * FROM buku";
    final String insert = "INSERT INTO buku (judul, penulis, rating, harga) VALUES (?, ?, ?, ?)";
    final String update = "UPDATE buku SET judul=?, penulis=?, rating=?, harga=? WHERE buku.judul=?";
    final String delete = "DELETE FROM buku WHERE judul=?";
    
    public DataBukuDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(DataBuku b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getJudul());
            statement.setString(2, b.getPenulis());
            statement.setDouble(3, b.getRating());
            statement.setDouble(4, b.getHarga());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()){
                b.setJudul(rs.getString(1));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataBuku> getAll() {
        List<DataBuku> db = null;
        try {
            db = new ArrayList<DataBuku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataBuku buku = new DataBuku();
                buku.setJudul(rs.getString("judul"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setRating(rs.getDouble("rating"));
                buku.setHarga(rs.getDouble("harga"));
                buku.setId(rs.getDouble("id"));
                db.add(buku);
            }
        } catch(SQLException ex) {
            Logger.getLogger(DataBukuDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return db;
    }

    @Override
    public void update(DataBuku b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getJudul());
            statement.setString(2, b.getPenulis());
            statement.setDouble(3, b.getRating());
            statement.setDouble(4, b.getHarga());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()){
                b.setJudul(rs.getString(1));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
