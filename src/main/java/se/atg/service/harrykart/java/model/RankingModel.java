package se.atg.service.harrykart.java.model;

public class RankingModel {
    private int position;
    private String horse;

    public RankingModel() {
    }
    public RankingModel(int position, String horse) {
        this.position = position;
        this.horse = horse;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public String getHorse() {
        return horse;
    }
    public void setHorse(String horse) {
        this.horse = horse;
    }

    @Override
    public String toString() {
        return "RankingModel{" +
                "position=" + position +
                ", horse='" + horse + '\'' +
                '}';
    }
}
