package generalManage;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface General<T> {
    void add() throws IOException;
    void edit() throws IOException;
    void delete() throws IOException;
    void display() throws IOException;
    int findIndexById(int id);

}
