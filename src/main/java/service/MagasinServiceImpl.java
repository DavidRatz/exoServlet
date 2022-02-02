package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import model.Magasin;

public class MagasinServiceImpl extends GenericServiceImpl<Magasin> {
    private final List<Magasin> list = new ArrayList<>();
    private static MagasinServiceImpl _instance;

    @Override
    public MagasinServiceImpl getInstance() {
        // if(_instance == null){
        //     _instance = new ProduitServiceImpl();
        // }
        // return _instance;
        return _instance == null ? _instance = new MagasinServiceImpl() : _instance;
    }

    private MagasinServiceImpl() {
        list.add(new Magasin(1, "Carrefour", "rue du marché", "Liège",4000,"25",300.0f,null));
        list.add(new Magasin(2, "Lidl", "rue du lidl", "Liège",4000,"5",180.2f,null));
    }


}
