package ArraysAndString;

import java.util.ArrayList;

public class Cell {
    int x;
    int y;
    int route;
    Cell prev;
    int val;

    public Cell(int x, int y, int val) {
        this.x = x;
        this.y = y;
        route = 0;
        this.val = val;
    }

    public ArrayList<Cell> getMatchNeigh(Cell[][] m, int val) {
        int x1 = -1;
        int y1 = -1;
        ArrayList<Cell> result = new ArrayList<Cell>();
        /*
       check
       x,y+1   ,
       x,y-1
       x+1,y
       x-1,y

       x+1,y+1   ,
       x+1,y-1
       x-1, y+1
       x-1,y-1

        */
        x1 = x;
        y1 = y + 1;
        if (check1(x1, y1, m, val)) {
            result.add(m[x1][y1]);
        }
        x1 = x;
        y1 = y - 1;
        if (check1(x1, y1, m, val)) {
            result.add(m[x1][y1]);
        }
        x1 = x + 1;
        y1 = y;
        if (check1(x1, y1, m, val)) {
            result.add(m[x1][y1]);
        }
        x1 = x - 1;
        y1 = y;
        if (check1(x1, y1, m, val)) {
            result.add(m[x1][y1]);
        }
        x1 = x + 1;
        y1 = y + 1;
        if (check1(x1, y1, m, val)) {
            result.add(m[x1][y1]);
        }
        x1 = x + 1;
        y1 = y - 1;
        if (check1(x1, y1, m, val)) {
            result.add(m[x1][y1]);
        }
        x1 = x - 1;
        y1 = x + 1;
        if (check1(x1, y1, m, val)) {
            result.add(m[x1][y1]);
        }
        x1 = x - 1;
        y1 = y - 1;
        if (check1(x1, y1, m, val)) {
            result.add(m[x1][y1]);
        }
        return result;
    }

    public boolean check1(int x1, int y1, Cell[][] m, int val) {
        if (x1 >= 0 && x1 < m.length && y1 >= 0 && y1 < m[0].length) {
            return (m[x1][y1].val == val ? true : false);
        }
        return false;
    }

}
