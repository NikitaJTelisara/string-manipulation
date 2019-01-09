package ArraysAndString;


import java.util.ArrayList;

public class findWord {
    public static void main(String[] args) {
        Cell[][] a1 = {
                {new Cell(0, 0, 8), new Cell(0, 1, 9), new Cell(0, 2, 16)},
                {new Cell(1, 0, 3), new Cell(1, 1, 7), new Cell(1, 2, 5)},
                {new Cell(2, 0, 2), new Cell(1, 1, 5), new Cell(2, 2, 2)},
        };
        int[] x = {9,7,5};
        System.out.println(findword(a1, x));
    }

    public static boolean findword(Cell[][] m, int[] str) {
        Cell c = null;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j].val == str[0]) {
                    c = m[i][j];
                }
            }
        }
        if (c != null) {
            return findneighIndexes(m, str, c, 1);
        }
        return false;
    }

    public static boolean findneighIndexes(Cell[][] m, int[] str, Cell curr, int i) {
        if (i < str.length) {
            ArrayList<Cell> neigh = curr.getMatchNeigh(m, str[i]);
            System.out.println(curr.val + " has " + neigh.size() + " neigh of " + str[i]);
            if (neigh.size() > 0) {
                for (int j = 0; j < neigh.size(); j++) {
                    Cell c1 = neigh.get(j);
                    if (c1.route == 0) {
                        c1.prev = curr;
                        return findneighIndexes(m, str, c1, i + 1);
                    }
                    if (j == neigh.size() - 1 && c1.route != 0) {
                        System.out.println("Quit2 and block ");
                        return false;

                    }
                }
            } else if (neigh.size() == 0) {
                System.out.println("Quit1 and block ");
                curr.route = -1; //inactivate this route
                return findneighIndexes(m, str, curr.prev, i - 1);
            }
        }
        return true;
    }
}