package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import exceptions.ProduitNotFoundException;
import model.Produit;
import model.ProduitForm;

public class ProduitServiceImpl implements ProduitService {

    private final List<Produit> list = new ArrayList<>();
    private static ProduitServiceImpl _instance;

    public static ProduitServiceImpl getInstance() {
        // if(_instance == null){
        //     _instance = new ProduitServiceImpl();
        // }
        // return _instance;
        return _instance == null ? _instance = new ProduitServiceImpl() : _instance;
    }

    private ProduitServiceImpl() {
        list.add(new Produit(1, "patate", "les bons légumes", 2.5));
        list.add(new Produit(2, "tomate", "les bons légumes", .99));
    }

    @Override
    public Produit delete(int id) {
        Produit produitRemoved = null;
        try {
            produitRemoved = getOne(id);
            list.remove(produitRemoved);
        } catch (Exception e) {
            //TODO: handle exception
            throw new ProduitNotFoundException("Aucun produit à supprimer !");
        }
        return produitRemoved;
    }

    @Override
    public List<Produit> getAll() {
        return list;
    }

    @Override
    public List<Produit> getAllByBrand(String brand) {
        return list.stream().filter(p -> p.getMarque().equalsIgnoreCase(brand)).toList();
    }

    @Override
    public List<Produit> getAllSorted(Comparator<Produit> comparator) {
        return list.stream().sorted(comparator).toList();
    }

    @Override
    public Produit getCheapest() {
        Optional<Produit> optProduit = list.stream().min(Comparator.comparingDouble(Produit::getPrix));
        Produit produitFound = null;
        if(optProduit.isPresent())
            produitFound = optProduit.get();
        return produitFound;
    }

    @Override
    public Produit getMostExpensive() {
        Optional<Produit> optProduit = list.stream().max(Comparator.comparingDouble(Produit::getPrix));
        Produit produitFound = null;
        if(optProduit.isPresent())
            produitFound = optProduit.get();
        return produitFound;
    }

    @Override
    public Produit getOne(int id) {
        Optional<Produit> optProduit = list.stream().filter(p -> p.getId()==id).findFirst();
        // Produit produitFound = null;
        // if(optProduit.isPresent())
        //     produitFound = optProduit.get();
        // return produitFound;
        return optProduit.orElseThrow(() -> new ProduitNotFoundException("Aucun produit !"));
    }

    @Override
    public boolean insert(Produit toAdd) {
        if(toAdd != null && !list.stream().anyMatch(p -> p.getNom() == toAdd.getNom())){
            list.add(toAdd);
            return true;
        }
        else
            return false;
    }

    @Override
    public void update(int id, ProduitForm form) {
        Produit p = getOne(id);
        int productId = list.indexOf(p);

        p.setNom(form.getNom());
        p.setPrix(form.getPrix());
        
        list.set(productId, p);
        
        
    }
    
}
