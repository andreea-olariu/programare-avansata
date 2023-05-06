package org.example.Repositories;
import java.util.List;

public interface AbstractRepository<T> {
    public T create(Object... objects);
    public List<T> findAll();
    public T findById(int id);
    public T findByTitle(String name);
}
