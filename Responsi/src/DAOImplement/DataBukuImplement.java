package DAOImplement;

import java.util.List;
import model.*;

public interface DataBukuImplement {
    public void insert (DataBuku b);
    public void update (DataBuku b);
    public void delete (String judul);
    public List<DataBuku> getAll();
}
