package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exceptions.ProduitNotFoundException;
import model.Magasin;
import model.Produit;

public class MagasinServiceImpl implements MagasinService {
    private final List<Magasin> list = new ArrayList<>();
    private static MagasinServiceImpl _instance;

    
    public static MagasinServiceImpl getInstance() {
        // if(_instance == null){
        //     _instance = new ProduitServiceImpl();
        // }
        // return _instance;
        return _instance == null ? _instance = new MagasinServiceImpl() : _instance;
    }

    private MagasinServiceImpl() {
        list.add(new Magasin(1, "Carrefour", "rue du marché", "Liège",4000,"25",300.0f,new ArrayList<>()));
        list.add(new Magasin(2, "Lidl", "rue du lidl", "Liège",4000,"5",180.2f,new ArrayList<>()));
    }

    @Override
    public Magasin delete(int id) {
        Magasin magasinRemoved = null;
        try {
            magasinRemoved = getOne(id);
            list.remove(magasinRemoved);
        } catch (Exception e) {
            //TODO: handle exception
            throw new ProduitNotFoundException("Aucun Magasin à supprimer !");
        }
        return magasinRemoved;
    }

    @Override
    public List<Magasin> getAll() {
        return list;
    }

    @Override
    public Magasin getOne(int id) {
        Optional<Magasin> optProduit = list.stream().filter(p -> p.getId()==id).findFirst();
        // Magasin magasinFound = null;
        // if(optProduit.isPresent())
        //     magasinFound = optProduit.get();
        // return magasinFound;
        return optProduit.orElseThrow(() -> new ProduitNotFoundException("Aucun Magasin !"));
    }

    @Override
    public boolean insert(Magasin toAdd) {
        if(toAdd != null && !list.stream().anyMatch(p -> p.getNom() == toAdd.getNom())){
            list.add(toAdd);
            return true;
        }
        else
            return false;
    }

    @Override
    public void update(int id, Magasin magasin) {
        Magasin p = getOne(id);
        int productId = list.indexOf(p);


        
        list.set(productId, p);
        
        
    }

    @Override
    public Magasin getByName(String nom) {
        Optional<Magasin> optMagasin = list.stream().filter(p -> p.getNom().equalsIgnoreCase(nom)).findFirst();
        // Magasin magasinFound = null;
        // if(optProduit.isPresent())
        //     magasinFound = optProduit.get();
        // return magasinFound;
        return optMagasin.orElseThrow(() -> new ProduitNotFoundException("Aucun Magasin !"));
    }

    @Override
    public void delete(String nom, Produit produit) {
        // TODO Auto-generated method stub
        Magasin magasin = getByName(nom);
        List<Produit> listProduitByMaga = magasin.getProduitDisponibles();
        listProduitByMaga.remove(produit.getId());
        magasin.setProduitDisponibles(listProduitByMaga);
    }


}
