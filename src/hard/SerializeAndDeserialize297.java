package hard;

import tools.TreeNode;
import tools.TreeNodeTool;

import java.util.Arrays;

public class SerializeAndDeserialize297 {

    public static void main(String[] args) {
        SerializeAndDeserialize297 t = new SerializeAndDeserialize297();
        t.test();
    }

    private void test() {
        Integer[][] eg = {{1, 2, 3, null, null, 4, 5}, {3, 9, 20, null, null, 15, 7}, {2, null, 3, null, 4, null, 5, null, 6}, {},
                {4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2}};
        for (Integer[] e : eg) {
            TreeNode de = TreeNodeTool.deserialize(Arrays.toString(e));
            System.out.println(TreeNodeTool.serialize(de));
        }
    }


}
