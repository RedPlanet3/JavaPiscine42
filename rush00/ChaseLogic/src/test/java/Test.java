import java.io.IOException;

public class Game {
    public static void main(String[] args) {

        int[][] field = null;
        int [] nextPoint;
        try {
            field = new ReadMap("/Users/elena/21school/JavaPiscine/rush00/src/main/java/map.txt").arrOut();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AlgAStar d = new AlgAStar(field, new int[]{2,3}, new int[]{8,8});
        nextPoint = d.next();
        while (nextPoint!= null) {
            System.out.println(nextPoint[0] + " " + nextPoint[1]);
            nextPoint = d.next();
        }
        System.out.println(d.answ());
    }
}
/*
  0 1 2 3 4 5 6 7 8 9
0 0 0 0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0 0 0 0
2 0 0 0 0 0 1 0 0 0 0
3 0 0 I 0 0 1 0 0 0 0
4 0 0 0 0 0 1 0 0 0 0
5 0 0 0 0 0 1 0 0 0 0
6 0 0 0 1 1 1 0 0 0 0
7 0 0 0 0 0 0 0 0 0 0
8 0 0 0 0 0 0 0 0 E 0
9 0 0 0 0 0 0 0 0 0 0

 */
