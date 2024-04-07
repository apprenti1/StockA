package entity;

public class LinkFournitureCommandeFourniture {

    // attribute déclaration
    private int id;
    private int quantite;
    private Fourniture fourniture;
    private CommandeFourniture commandeFourniture;


    public LinkFournitureCommandeFourniture(int id, int quantite, Fourniture fourniture, CommandeFourniture commandeFourniture) {
        this.id = id;
        this.quantite = quantite;
        this.fourniture = fourniture;
        this.commandeFourniture = commandeFourniture;
    }


    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public Fourniture getFourniture() {
        return fourniture;
    }

    public CommandeFourniture getCommandeFourniture() {
        return commandeFourniture;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setFourniture(Fourniture fourniture) {
        this.fourniture = fourniture;
    }

    public void setCommandeFourniture(CommandeFourniture commandeFourniture) {
        this.commandeFourniture = commandeFourniture;
    }
}
