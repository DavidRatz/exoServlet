package service;

import java.util.List;
import java.util.function.Predicate;

public interface GenericService<T> {
    List<T> getAll();
    T getOne(int id,Predicate<T> predicate);
    T getBy(Predicate<T> predicate);
    T get(int index);

    boolean insert(T genericModel);
    void update(int id, T genericModel);
    T delete(int id);
    
}
