package middle;

public class videoStitching1024 {
    public static void main(String[] args){
        videoStitching1024 t=new videoStitching1024();
        int[][] eg1=new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int eg1T=10;
        int[][] eg2=new int[][]{{0,1},{1,2}};
        int eg2T=5;
        int[][] eg3=new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},
                {6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        int eg3T=9;
        int[][] eg4=new int[][]{{0,4,},{2,8},};
        int eg4T=5;

        int res= t.videoStitching(eg4,eg4T);
        System.out.println(res);
    }


    private int pick;

    /* 贪心算法？1、从List中找覆盖了最多的片段
    * 2、从将List中对应的片段除去
    * 3、重复 */
    public int videoStitching(int[][] clips, int T) {
        greedy(clips,0,T);
        return pick;
    }

    public void greedy(int[][] clips,int from,int to){
        if(from>=to){
            return;
        }
        int cover=0,curCover,pickFrom=-1,pickTo=-1,pickIndex=-1;

        for(int i=0;i<clips.length;i++){
            //覆盖要求的范围最多的
            curCover=Math.min(clips[i][1], to)-Math.max(clips[i][0], from);
            //将其选中
            if(curCover>cover){
                pickFrom=clips[i][0];
                pickTo=clips[i][1];
                pickIndex=i;
                cover=curCover;
            }
        }
        if(cover>0){
            //完成一次覆盖
            pick++;
            //这样就去掉了选过的覆盖（区间变成0，无法再覆盖）
            clips[pickIndex][1]=clips[pickIndex][0];
        }else {
            //如果一次遍历都完全没有可以覆盖到的
            pick=-1;
        }
        //任意一边不能cover都结束了
        if(pick!=-1) {
            greedy(clips, from, pickFrom);
        }
        if(pick!=-1) {
            greedy(clips, pickTo, to);
        }
    }
}
