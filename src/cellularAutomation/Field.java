package cellularAutomation;

import java.util.ArrayList;

/**
 *将细胞填入整个网格；
 */
public class Field {

    private int WIDTH;     //网格的宽度即格子的列数；
    private int HEIGHT;      //网格的高度即格子的行数；
    private Cell[][] cells ;

    //初始化网格大小；
    public Field(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        cells = new Cell[HEIGHT][WIDTH];
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    //将细胞放在网格中；
    public Cell place(int x, int y, Cell cell) {
        return cells[x][y] = cell;
    }

    //获取某个细胞的信息
    public Cell get(int x, int y) {
        return cells[x][y];
    }

    //获取该细胞周围（8个网格）存活的细胞数；
    public Cell[] getNeighbour(int x, int y) {
        ArrayList<Cell> list = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int X = x + i;
                int Y = y + j;
                if (X > -1 && X < HEIGHT && Y > -1 && Y < WIDTH &&
                        !(X == x && Y == y) ) {
                    list.add(cells[X][Y]);
                }
            }
        }
        return list.toArray(new Cell[list.size()]);
    }

    public void clear() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].die();
            }
        }
    }
}
