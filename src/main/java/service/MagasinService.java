package service;

import java.util.List;
import java.util.function.Predicate;

import model.Magasin;

public interface MagasinService {
    List<Magasin> getAll();
    Magasin getOne(int id);
    Magasin getBy(Predicate<Magasin> predicate);
    Magasin get(int index);

    boolean insert(Magasin magasin);
    void update(int id, Magasin magasin);
    Magasin delete(int id);
}
