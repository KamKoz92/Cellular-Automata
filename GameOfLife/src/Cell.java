package GameOfLife.src;

import java.awt.Color;

public class Cell {
    private boolean state;

    public Cell(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

	public Color getColor() {
		if(state) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }
     
}
