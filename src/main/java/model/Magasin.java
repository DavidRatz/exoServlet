package model;

import java.util.List;

public class Magasin {
    private int id;
    private String nom;
    private String rue;
    private String ville;
    private int codePostal;
    private String numero;
    private float superficie;
    private List<Produit> produitDisponibles;
    public Magasin() {
    }
    public Magasin(int id, String nom, String rue, String ville, int codePostal, String numero, float superficie, List<Produit> produitDisponibles) {
        this.id = id;
        this.nom = nom;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.numero = numero;
        this.superficie = superficie;
        this.produitDisponibles = produitDisponibles;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public int getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public float getSuperficie() {
        return superficie;
    }
    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }
    public List<Produit> getProduitDisponibles() {
        return produitDisponibles;
    }
    public void setProduitDisponibles(List<Produit> produitDisponibles) {
        this.produitDisponibles = produitDisponibles;
    }
    @Override
    public String toString() {
        return "Magasin [codePostal=" + codePostal + ", id=" + id + ", nom=" + nom + ", numero=" + numero
                + ", produitDisponibles=" + produitDisponibles + ", rue=" + rue + ", superficie=" + superficie
                + ", ville=" + ville + "]";
    }
}
