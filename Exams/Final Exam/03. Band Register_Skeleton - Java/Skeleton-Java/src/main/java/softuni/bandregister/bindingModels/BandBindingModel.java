package softuni.bandregister.bindingModels;

public class BandBindingModel {

    private String name;
    private String members;
    private double honorarium;
    private String genre;

    public BandBindingModel(String name, String members, double honorarium, String genre) {
        this.name = name;
        this.members = members;
        this.honorarium = honorarium;
        this.genre = genre;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public double getHonorarium() {
        return honorarium;
    }

    public void setHonorarium(double honorarium) {
        this.honorarium = honorarium;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BandBindingModel() {
    }
}
