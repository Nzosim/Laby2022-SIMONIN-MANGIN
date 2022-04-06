/**
 * Classe Position
 */
public class Position {

    /**
     * attribut prive de la classe Position
     * position_X qui determine la position en X
     * position_Y qui determine la position en Y
     */
    private int position_X;
    private int position_Y;

    /**
     * constructeur de la classe Position qui initialise la position en x et en y
     *
     * @param position_X la position en x
     * @param position_Y la position en y
     */
    public Position(int position_X, int position_Y) {
        this.position_X = position_X;
        this.position_Y = position_Y;
    }

    /**
     * methode getPosition_X qui retourne la position en X
     * @return position en X
     */
    public int getPosition_X() {
        return position_X;
    }

    /**
     * methode getPosition_Y qui retourne la position en Y
     * @return position en Y
     */
    public int getPosition_Y() {
        return position_Y;
    }

    /**
     * methode setPosition_X qui modifie la position en X
     * @param position_X La nouvelle position de x
     */
    public void setPosition_X(int position_X) {
        this.position_X = position_X;
    }

    /**
     * methode setPosition_Y qui modifie la position en Y
     * @param position_Y La nouvelle position de y
     */
    public void setPosition_Y(int position_Y) {
        this.position_Y = position_Y;
    }

    /**
     * methode equals qui verifie si la position est egal ou non
     * @param x position en x
     * @param y position en y
     * @return si oui ou non les positions sont les memes
     */
    public boolean equals(int x, int y) {
        return this.position_X == x && this.position_Y == y;
    }

    /**
     * methode equals qui verifie si la position est egal à une autre Objet Position
     * @param p position a tester
     * @return si oui ou non les positions sont les memes
     */
    public boolean equals(Position p) {
        return this.equals(p.position_X, p.position_Y);
    }

}
