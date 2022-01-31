package service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericServiceImpl<T> implements GenericService<T> {

    @Override
    public List<T> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T getOne(int id, Predicate<T> predicate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T getBy(Predicate<T> predicate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(T genericModel) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void update(int id, T genericModel) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
