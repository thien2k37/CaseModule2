package model;

public class Machine {
    private int namePC;
    static int id = 1;
    private String statusPC;

    public Machine(String statusPC) {
        namePC = id++;
        this.statusPC = statusPC;
    }

    public int getNamePC() {
        return namePC;
    }

    public void setNamePC(int namePC) {
        this.namePC = namePC;
    }

    public String getStatusPC() {
        return statusPC;
    }

    public void setStatusPC(String statusPC) {
        this.statusPC = statusPC;
    }

    @Override
    public String toString() {
        return getNamePC() + "," + getStatusPC();
    }
}
