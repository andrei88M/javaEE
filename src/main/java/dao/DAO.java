package dao;

import java.util.List;

public interface DAO<T> {
    void save(T t);
    List<T> getAll();
    T get(int id);
    void update(T t);
    void delete(T t);
}
