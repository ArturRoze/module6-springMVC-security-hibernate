package productManagementSystem.dao;

import java.util.List;

public interface Dao<T> {

    void create(T value);

    List<T> read();

    void update(T value);

    void delete(T value);
}
