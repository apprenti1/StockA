package entity;
import java.util.List;
public class CommandeFournitureComporteFourniture {
    private int id;
    private CommandeFourniture commandeFourniture;
    private List<Fourniture> fournitures;
    public CommandeFournitureComporteFourniture(int id, CommandeFourniture commandeFourniture, List<Fourniture> fournitures) {
        this.id = id;
        this.commandeFourniture = commandeFourniture;
        this.fournitures = fournitures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CommandeFourniture getCommandeFourniture() {
        return commandeFourniture;
    }

    public void setCommandeFourniture(CommandeFourniture commandeFourniture) {
        this.commandeFourniture = commandeFourniture;
    }

    public List<Fourniture> getFournitures() {
        return fournitures;
    }

    public void setFournitures(List<Fourniture> fournitures) {
        this.fournitures = fournitures;
    }

    @Override
    public String toString() {
        return "CommandeFournitureComporteFourniture{" +
                "id=" + id +
                ", commandeFourniture=" + commandeFourniture +
                ", fournitures=" + fournitures +
                '}';
    }
}