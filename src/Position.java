import java.util.Objects;

public class Position {

    private int position_X, position_Y;

    public Position(int position_X, int position_Y) {
        this.position_X = position_X;
        this.position_Y = position_Y;
    }

    public int getPosition_X() {
        return position_X;
    }

    public int getPosition_Y() {
        return position_Y;
    }

    public void setPosition_X(int position_X) {
        this.position_X = position_X;
    }

    public void setPosition_Y(int position_Y) {
        this.position_Y = position_Y;
    }

    public boolean equals(int x,int y){
        return this.position_X == x && this.position_Y == y;
    }

}