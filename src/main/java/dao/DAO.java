package dao;

import java.util.List;

public interface DAO<T> {
    void save(T t);
    List<T> getAll();
    void update(T t);
    void delete(T t);
}
