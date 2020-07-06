package Data_Structure;

public class Maze {
//    先定义一个迷宫
//    最短路径问题：在我们没有学更好的寻路算法之前，认为路径长短只跟我们寻路的策略有关
    public static void main(String[] args) {
        Maze maze = new Maze(7);
        maze.buildWall(3, 2);
        maze.buildWall(1, 2);
        maze.buildWall(2, 2);
        maze.buildWall(5, 4);
        maze.buildWall(4, 4);
        maze.buildWall(3, 4);
//        maze.findWayFrom(1, 1);
//        maze.showMaze();
    }

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
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == column - 1) {
                    maze[i][j] = 1;
                }
            }
        }
    }

    public void buildWall(int posX, int posY) {
        if (posX >= row || posY >= column) {
            System.out.println("超出迷宫范围！");
        } else {
            maze[posX][posY] = 1;
        }
    }

    public void shortestWayFrom(int startX,int startY){
        int step;
        int tempStep;
        int[][] tempMaze;
    }

    public boolean findWayFrom(int posX, int posY) {
        if (maze[row - 2][column - 2] == 2) {
            return true;
        } else {
            if (maze[posX][posY] == 0) {//如果这个点没有走过
                maze[posX][posY] = 2;//先假定这个点可以走通
//                寻路的顺序，下右上左
                if (findWayFrom(posX + 1, posY)) {//下
                    return true;
                }else if (findWayFrom(posX, posY + 1)) {
                    return true;//右
                } else if (findWayFrom(posX - 1, posY)) {
                    return true;//上
                } else if (findWayFrom(posX, posY - 1)) {
                    return true;//左
                } else {//实在走不通
                    maze[posX][posY] = 3;
                    return false;
                }
            } else return false;//maze[][]==1,2,3;
        }
    }
}
