package service;

import java.util.Comparator;
import java.util.List;

import model.Produit;
import model.ProduitForm;

public interface ProduitService {

    List<Produit> getAll();
    Produit getOne(int id);

    /**
     * Ajoute un produit si son id n'est partagé par un produit existant.
     * Pas de null autorisé
     * @param toAdd le produit à ajouter
     * @return <code>true</code> si le produit est ajouté; <code>false</code> sinon
     */
    boolean insert(Produit toAdd);
    Produit delete(int id);
    void update(int id, ProduitForm form);

    List<Produit> getAllSorted(Comparator<Produit> comparator);
    Produit getCheapest();
    Produit getMostExpensive();
    List<Produit> getAllByBrand(String brand);



}
