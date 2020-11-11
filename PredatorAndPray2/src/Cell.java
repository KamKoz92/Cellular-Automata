package PredatorAndPray2.src;

import java.awt.Color;

public class Cell {
    
    private Color color;

    public Cell(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isPrey() {
        return color == Color.GREEN;
    }

    public boolean isPredator() {
        return color == Color.RED;
    }

    public boolean isEmpty() {
        return color == Color.BLACK;
    }
}
