package algorithm;

public class HanoiTower {
    public static void main(String[] args) {
        HanoiTower t = new HanoiTower();
        t.solve(3, 'A', 'B', 'C');
    }


    /**
     * 分治算法解汉诺塔问题
     *
     * @param plate 要完成几层汉诺塔的移动，当前移动的是第几个盘
     * @param t1    当前移动的起始柱
     * @param t2    当前移动的中转柱
     * @param t3    当前移动的终点柱
     */
    public void solve(int plate, char t1, char t2, char t3) {
        if (plate == 1) {
            System.out.println("移动第 1 个盘，从 " + t1 + " 到 " + t3);
        } else {
            /*
            倒推，比如：要完成4层的汉诺塔，要把上面三层从A放到B，第四层从A放到C，再把三层从B到C
            又，要把3层从A到B，得把两层从A到C，再把第三层从A到B，再把两层从C到B
            再，要把2层从A到C，得把1层从A到B，再把第二层从A到C，再把1层从B到C
            可以看到每次把起始和目标之外的那个柱子作为中转柱，而且自顶向下，为了实现上层的目标，下层必须把上层的中转柱作为目标
            由此形成了每个柱任务自然的切换，也就是方法参数的变化。

            返回上一栈也是非常自然，比如完成了2层从A到C的第一步，1层从A到B以后，也就是执行完2层栈的第一条语句，
            自然返回到2层的栈中，执行第二步，把2层从A到C，因此移动的是第几个盘也能完美对上
            */
            solve(plate - 1, t1, t3, t2);
            System.out.println("移动第 " + plate + " 个盘，从 " + t1 + " 到 " + t3);
            solve(plate - 1, t2, t1, t3);
        }
    }
}
