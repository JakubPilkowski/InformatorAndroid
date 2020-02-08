package pl.android.informator.models;

public class CommunicationLine {
    private int id;
    private int number;

    public CommunicationLine(int id, int number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }
}
