package se.atg.service.harrykart.java.model;

public class HarryKartModel {
    public int lane;
    public String name;
    public int basespeed;
    public int finishTime;

    public HarryKartModel() {}
    public HarryKartModel(int lane, String name, int basespeed) {
        this.name = name;
        this.basespeed = basespeed;
        this.lane = lane;
    }
    public HarryKartModel(int lane, String name, int basespeed, int finishTime) {
        this.lane = lane;
        this.name = name;
        this.basespeed = basespeed;
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "HarryKartModel{" +
                "lane=" + lane +
                ", name='" + name + '\'' +
                ", basespeed=" + basespeed +
                ", finishTime=" + finishTime +
                '}';
    }
}

