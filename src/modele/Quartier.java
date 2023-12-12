package modele;
public class Quartier {
    private String nom = "";
    private String type = "";
    private String caracteristiques = "";
    private int coutConstruction = 0;
    public static final String[] TYPE_QUARTIERS  = {"RELIGIEUX", "MILITAIRE", "NOBLE", "COMMERCANT", "MERVEILLE"};
    private boolean embelli;

    public boolean getEmbelli() {
        return embelli;
    }

    public void setEmbelli(boolean embelli) {
        this.embelli = embelli;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getType(){
        return this.type;
    }

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

    public String getCaracteristiques(){
        return this.caracteristiques;
    }

    public void setCaracteristiques(String caracteristiques){
        this.caracteristiques = caracteristiques;
    }

    public int getCout(){
        return this.coutConstruction;
    }

    public void setCout(int coutConstruction){
        if(coutConstruction <= 6 && coutConstruction >= 1){
            this.coutConstruction = coutConstruction;
        }else{
            this.coutConstruction = 0;
        }
    }

    public void embellir(){
        if(!this.getEmbelli()){
            this.coutConstruction+=1;
            this.setEmbelli(true);
            System.out.println("Le quartier à bien été embelli");
        }else{
            System.out.println("Quartier déjà embelli");
        }
    }

    public Quartier(){
    }

    public Quartier(String nom, String type, int cout){
        setNom(nom);
        setType(type);
        setCout(cout);
        setEmbelli(false);
    }

    public Quartier(String nom, String type, int cout, String caracteristiques){
        setNom(nom);
        setType(type);
        setCout(cout);
        setCaracteristiques(caracteristiques);
        setEmbelli(false);
    }


    
}
