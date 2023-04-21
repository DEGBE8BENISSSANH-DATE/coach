package modele;

public class Profil {
    private static final Integer minFemme=15;
    private static final Integer maxFemme=30;
    private static final Integer minHomme=10;
    private static final Integer maxHomme=25;



    private Integer poids;
    private Integer taille;
    private Integer Age;
    private Integer sexe;
    private Float Img;
    private String message;

    public Profil(Integer poids, Integer taille, Integer Age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
         this .Age = Age;
        this.sexe = sexe;
        this.calculimg();
        this.result();
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return Age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public Float getImg() {
        return Img;
    }

    public String getMessage() {
        return message;
    }
    private void calculimg(){

        float tailleM =((float) taille)/100;
        this.Img=(float)((1.2*poids/(tailleM*tailleM))+(0.23*Age)-(10.83*sexe)-5.4);
    }
    private void result() {
        Integer min;
        Integer max;
        if (sexe ==0) {
            min = minFemme;
            max =maxFemme;
        }else {
            min = minHomme;
            max = maxHomme;
        }
            message="normal";
            if(Img<min){
                message ="moyen";

            }else {
                if(Img>max) {
                    message = "naz";
                }
            }

        }

}
