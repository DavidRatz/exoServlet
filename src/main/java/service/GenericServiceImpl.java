package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GenericServiceImpl<T> implements GenericService<T> {
    private final List<T> list = new ArrayList<>();
    
    private static GenericServiceImpl<?> _instance = null;

    public static GenericServiceImpl<?> getInstance() {
        // if(_instance == null){
        //     _instance = new ProduitServiceImpl();
        // }
        // return _instance;
        return _instance == null ? _instance = new GenericServiceImpl<>() : _instance;
    }

    @Override
    public List<T> getAll() {
        return List.copyOf(list);
    }

    @Override
    public T getOne(int id, Predicate<T> predicate) {
        Optional<T> opt = list.stream().filter(predicate).findFirst();
        return opt.orElseThrow(() -> new IllegalArgumentException("Aucun élément !"));
    }

    @Override
    public T getBy(Predicate<T> predicate) {
        Optional<T> opt = list.stream().filter(predicate).findAny();
        return opt.orElseThrow(() -> new IllegalArgumentException("Aucun élément !"));
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public boolean insert(T genericModel, Predicate<T> predicate) {
        if(genericModel != null && !list.stream().anyMatch(predicate)){
            list.add(genericModel);
            return true;
        }
        else
            return false;
    }

    @Override
    public void update(int id, T genericModel,Predicate<T> predicate) {
        T toUpdate = getOne(id, predicate);
        int productId = list.indexOf(toUpdate);
        
        list.set(productId, genericModel);
    }

    @Override
    public T delete(int id,Predicate<T> predicate) {
        T toRemove = null;
        try {
            toRemove = getOne(id,predicate);
            list.remove(toRemove);
        } catch (Exception e) {
            //TODO: handle exception
            throw new IllegalArgumentException("Aucun élément !");
        }
        return toRemove;
    }
    
}
