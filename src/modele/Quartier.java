package modele;

public class Quartier {
    private String nom = "";
    private String type = "";
    private String caracteristiques = "";
    private int coutConstruction = 0;
    public static final String[] TYPE_QUARTIERS  = {"RELIGIEUX", "MILITAIRE", "NOBLE", "COMMERCANT", "MERVEILLE"};
    private boolean embelli;

    // Méthode pour obtenir l'information si le quartier est embelli
    public boolean getEmbelli() {
        return embelli;
    }

    // Méthode pour définir si le quartier est embelli
    public void setEmbelli(boolean embelli) {
        this.embelli = embelli;
    }

    // Méthode pour obtenir le nom du quartier
    public String getNom(){
        return this.nom;
    }

    // Méthode pour définir le nom du quartier
    public void setNom(String nom){
        this.nom = nom;
    }

    // Méthode pour obtenir le type du quartier
    public String getType(){
        return this.type;
    }

    // Méthode pour définir le type du quartier
    public void setType(String type){
        boolean condition = false;
        for(int i=0; i<5; i++){
            if(type == TYPE_QUARTIERS[i]){
                this.type = type;
                condition = true;
            }
        }
        if(condition == false){
            this.type = "";
        }
    }

    // Méthode pour obtenir les caractéristiques du quartier
    public String getCaracteristiques(){
        return this.caracteristiques;
    }

    // Méthode pour définir les caractéristiques du quartier
    public void setCaracteristiques(String caracteristiques){
        this.caracteristiques = caracteristiques;
    }

    // Méthode pour obtenir le coût de construction du quartier
    public int getCout(){
        return this.coutConstruction;
    }

    // Méthode pour définir le coût de construction du quartier
    public void setCout(int coutConstruction){
        if(coutConstruction <= 6 && coutConstruction >= 1){
            this.coutConstruction = coutConstruction;
        } else {
            this.coutConstruction = 0;
        }
    }

    // Méthode pour embellir le quartier
    public void embellir(){
        if(!this.getEmbelli()){
            this.coutConstruction += 1;
            this.setEmbelli(true);
            System.out.println("Le quartier a bien été embelli");
        } else {
            System.out.println("Quartier déjà embelli");
        }
    }

    // Constructeur par défaut
    public Quartier(){
    }

    // Constructeur avec nom, type et coût de construction
    public Quartier(String nom, String type, int cout){
        setNom(nom);
        setType(type);
        setCout(cout);
        setEmbelli(false);
    }

    // Constructeur avec nom, type, coût de construction et caractéristiques
    public Quartier(String nom, String type, int cout, String caracteristiques){
        setNom(nom);
        setType(type);
        setCout(cout);
        setCaracteristiques(caracteristiques);
        setEmbelli(false);
    }
}
