package data_structure;

import tools.Permutation;
import java.util.List;

public class Maze {
//    先定义一个迷宫
//    最短路径问题：在我们没有学更好的寻路算法之前，认为路径长短只跟我们寻路的策略有关
    public static void main(String[] args) {
        Maze maze = new Maze(7);
        maze.initialize();
        maze.shortestWayFrom(1, 1);
        maze.showMaze();
    }

    int step;
    int[][] maze;
    int row, column;

    public Maze(int size) {
        this.row = size;
        this.column = size;
        maze = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    maze[i][j] = 1;
                }
            }
        }
    }

    public Maze(int row, int column) {
        this.row = row;
        this.column = column;
        maze = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == column - 1) {
                    maze[i][j] = 1;
                }
            }
        }
    }

    public void showMaze() {
        for (int[] subArr : maze) {
            for (int i : subArr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void initialize() {
        maze = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == column - 1) {
                    maze[i][j] = 1;
                }
            }
        }
        maze[3][2] = 1;
        maze[1][2] = 1;
        maze[2][2] = 1;
        maze[5][4] = 1;
        maze[4][4] = 1;
        maze[3][4] = 1;
    }

    public void buildWall(int posX, int posY) {
        if (posX >= row || posY >= column) {
            System.out.println("超出迷宫范围！");
        } else {
            maze[posX][posY] = 1;
        }
    }

    public void shortestWayFrom(int startX, int startY) {
        int tempStep = 99;
        int[][] tempMaze = new int[row][column];
        List<List<Integer>> priorList = new Permutation().permute(new int[]{1, 2, 3, 4});
        for (List<Integer> prior : priorList) {
            step = 0;
            findWayFrom(startX, startY, prior);
//            showMaze();
//            System.out.println();
            if (step < tempStep) {
                tempStep = step;
                tempMaze = maze.clone();
            }
            initialize();
        }
        maze = tempMaze.clone();
    }

    public boolean findWayFrom(int posX, int posY, List<Integer> prior) {
        if (maze[row - 2][column - 2] == 2) {
            return true;
        } else {
            if (maze[posX][posY] == 0) {//如果这个点没有走过
                maze[posX][posY] = 2;//先假定这个点可以走通
                step++;
                for (int value : prior) {
                    switch (value) {
                        case 1:
                            if (findWayFrom(posX - 1, posY, prior)) {
                                return true;//上
                            }
                        case 2:
                            if (findWayFrom(posX + 1, posY, prior)) {
                                return true;//下
                            }
                        case 3:
                            if (findWayFrom(posX, posY - 1, prior)) {
                                return true;//左
                            }
                        case 4:
                            if (findWayFrom(posX, posY + 1, prior)) {
                                return true;//右
                            }
                    }
                }
                maze[posX][posY] = 3;
                step--;//maze[][]==1,2,3;
            }
            return false;
        }
    }
}
