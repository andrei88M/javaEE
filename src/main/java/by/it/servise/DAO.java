package by.it.servise;

public interface DAO<Model, Key> {
    void save(Model model);
    Model get(Key key);
    void update(Model model);
    void delete(Model model);
}
