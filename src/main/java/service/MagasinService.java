package service;

import java.util.List;
import java.util.function.Predicate;

import model.Magasin;
import model.Produit;

public interface MagasinService {
    List<Magasin> getAll();
    Magasin getOne(int id);

    boolean insert(Magasin magasin);
    void update(int id, Magasin magasin);
    Magasin delete(int id);
    Magasin getByName(String nom);
    void delete(String nom, Produit produit);
}
