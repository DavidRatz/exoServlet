package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import model.Magasin;

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
        list.add(new Magasin(1, "Carrefour", "rue du marché", "Liège",4000,"25",300.0f,100));
        list.add(new Magasin(2, "Lidl", "rue du lidl", "Liège",4000,"5",180.2f,80));
    }

    @Override
    public List<Magasin> getAll() {
        return List.copyOf(list);
    }

    @Override
    public Magasin getOne(int id) {
        Optional<Magasin> optProduit = list.stream().filter(p -> p.getId()==id).findFirst();
        // Produit produitFound = null;
        // if(optProduit.isPresent())
        //     produitFound = optProduit.get();
        // return produitFound;
        return optProduit.orElseThrow(() -> new ProduitNotFoundException("Aucun produit !"));

    }

    @Override
    public Magasin getBy(Predicate<Magasin> predicate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Magasin get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(Magasin magasin) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void update(int id, Magasin magasin) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Magasin delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }
}
