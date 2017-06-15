public class wordExists {

    public static void main(String[] args) {
        char[][] m = {{'a', 'b', 'c'},
                      {'d', 'e', 'f'},
                      {'g', 'h', 'i'}};
        System.out.println(wordExists(m,"adehc"));
    }

    public static boolean wordExists(char[][] m, String str) {
        int iIndex = 0;
        int jIndex = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == str.charAt(0)) {
                    iIndex = i;
                    jIndex = j;
                    break;
                }
            }
        }
        for(int k =1; k<str.length();k++){
            Point p = getNeighbour(m,str.charAt(k),iIndex,jIndex);
            if(p!=null){
                iIndex = p.x;
                jIndex = p.y;
            }else {
                return false;
            }
        }
        return true;
    }

    public static Point getNeighbour(char[][] m, char a, int iIndex, int jIndex) {
        int i = iIndex - 1;
        int j = jIndex;
        Point p = isNeighbour(m, a, i, j);
        if (p != null) {
            return p;
        }

        i = iIndex + 1;
        j = jIndex;
        p = isNeighbour(m, a, i, j);
        if (p != null) {
            return p;
        }

        i = iIndex - 1;
        j = jIndex - 1;
        p = isNeighbour(m, a, i, j);
        if (p != null) {
            return p;
        }

        i = iIndex;
        j = jIndex - 1;
        p = isNeighbour(m, a, i, j);
        if (p != null) {
            return p;
        }

        i = iIndex + 1;
        j = jIndex - 1;
        p = isNeighbour(m, a, i, j);
        if (p != null) {
            return p;
        }

        i = iIndex - 1;
        j = jIndex + 1;
        p = isNeighbour(m, a, i, j);
        if (p != null) {
            return p;
        }

        i = iIndex;
        j = jIndex + 1;
        p = isNeighbour(m, a, i, j);
        if (p != null) {
            return p;
        }

        i = iIndex + 1;
        j = jIndex + 1;
        p = isNeighbour(m, a, i, j);
        if (p != null) {
            return p;
        }
        return null;
    }

    public static Point isNeighbour(char[][] m, char a, int iIndex, int jIndex) {
        int i = iIndex;
        int j = jIndex;
        if (i < m.length && i >= 0 && j < m.length && j >= 0) {
            if (m[i][j] == a) {
                return new Point(i, j);
            }
        }
        return null;
    }
}