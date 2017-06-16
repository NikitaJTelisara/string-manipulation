public class zigzag {
    public static void main(String[] args) {
        String kk = convert("paypalishiring", 3);
        System.out.println(kk);
    }

    public static String convert(String s, int numRows) {
        if(s.length() <= numRows){
            return s;
        }
        int numCol = getColCount(s, numRows);
        char[][] m = new char[numCol][numRows];
        String s1 = new String();
        int k = 0;
        int jIndex = 0;
        int i = 0;
        while (i < numCol) {
            for (int j = 0; j < numRows; j++) {
                if (k >= s.length()) {
                    break;
                }
                m[i][j] = s.charAt(k);
                k++;
                jIndex = j;
            }
            jIndex--;
            i++;
            while (i < numCol && jIndex > 0) {
                if (k >= s.length()) {
                    break;
                }
                m[i][jIndex] = s.charAt(k);
                i++;
                jIndex--;
                k++;
            }
        }
        for (int ii = 0; ii < numRows; ii++) {
            for (int j = 0; j < numCol; j++) {
                s1 += m[j][ii];
            }
        }
        return s1;
    }


    public static int getColCount(String s, int numRows) {
        int gap = numRows - 2;
        int i = numRows - 1;
        int numCol = 1;
        while (i <= s.length()) {
            if (i + gap > s.length()) {
                return numCol;
            }
            i += gap;
            numCol += gap;
            if (i + numRows > s.length()) {
                return numCol;
            }
            i += numRows;
            numCol++;
        }
        return numCol;
    }
}

/*output pahnaplsiigyir */
