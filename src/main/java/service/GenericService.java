package service;

import java.util.List;
import java.util.function.Predicate;

public interface GenericService<T> {
    List<T> getAll();
    T getOne(int id,Predicate<T> predicate);
    T getBy(Predicate<T> predicate);
    T get(int index);

    boolean insert(T genericModel,Predicate<T> predicate);
    void update(int id, T genericModel,Predicate<T> predicate);
    T delete(int id,Predicate<T> predicate);
    
}
