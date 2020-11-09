import java.awt.Color;

public class Cell {

    public static final int PREY_LIFE = 100;
    public static final int PREDATOR_LIFE = 100;

    private Color color;
    private int lifetime;

    public Cell(Color color) {
        this.color = color;
        this.lifetime = 0;
    }

    public Color getColor() {
        return color;
    }

    public int getLifetime() {
        return lifetime;
    }
    
    public void increaseLifeTime() {
        lifetime++;
    }

    public boolean isPrey() {
        return color == Color.green;
    }
    
    public boolean isPredator() {
        return color == Color.red;
    }

    public boolean isEmpty() {
        return color == Color.black;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
