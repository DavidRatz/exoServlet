package service;

import java.util.ArrayList;
import java.util.List;

import model.Personne;

public class PersonneServiceImpl implements PersonneService{
    List<Personne> lPersonnes = new ArrayList<>(){{
        add(new Personne("toto","T"));
        add(new Personne("toto","D"));
    }};

    @Override
    public List<Personne> getAll() {
        
        return lPersonnes;
    }
    
}
