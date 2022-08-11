package huawei;

import java.util.*;


public class Main2 {

    static class Tree {
        int key;
        List<Tree> chir = new ArrayList<>();
    }

    public static int[] findOrder(int num, int[][] pre) {
        Tree tree = new Tree();
        for (int[] arr : pre) {
            Tree chi = new Tree();
            chi.key = arr[0];
            if (tree.key == arr[1]) {
                tree.chir.add(chi);
            } else {
                add(tree, arr[1], chi);
            }
        }
        Set<Integer> list = new LinkedHashSet<>();
        List<Tree> treeList = new ArrayList<>();
        treeList.add(tree);
        print(treeList, list);
        if (list.size() != num) {
            return new int[0];
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    static void print(List<Tree> treeList, Set<Integer> list) {
        List<Tree> treeList1 = new ArrayList<>();
        for (Tree tree : treeList) {
            treeList1.addAll(tree.chir);
            list.add(tree.key);
        }
        if (treeList1.size() != 0) {
            print(treeList1, list);
        }
    }


    /**
     * 递归tree找key
     *
     * @return
     */
    static Boolean find(Tree tree, Integer key) {
        if (tree.key == key) {
            return true;
        } else {
            for (Tree chi : tree.chir) {
                return find(chi, key);
            }
        }
        return false;
    }

    static void add(Tree tree, int key, Tree add) {
        if (tree.key == key) {
            tree.chir.add(add);
        } else if (tree.chir.size() != 0) {
            for (Tree chi : tree.chir) {
                add(chi, key, add);
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        for (int i : findOrder(4, pre)) {
            System.out.println(i);
        }
    }
}
