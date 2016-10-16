import java.util.Stack;

/**
 * Created by Julie on 04-10-2016.
 */
public class IntTree {
    private IntTreeNode overallRoot;

    public IntTree (int max) {
        if (max < 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        }
        else {
            return new IntTreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
        }
    }


    public void printPreorder(){
        System.out.print("preorder: ");
        printPreorder(overallRoot);
        System.out.println();
    }

    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.println(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public int countLevels() {
        return countLevels(overallRoot);
    }

    private int countLevels(IntTreeNode current) {
        IntTreeNode root = current;
        if (root == null) {
            return 0;
        }
        else {
            return + + Math.max(countLevels(root.left), countLevels(root.right));
        }
    }

    // ---- Ex1 ----
    public int countLeftNodes() {
        if (overallRoot != null) {
            return countLeftNodes(overallRoot);

        }
        return 0;
    }

    private int countLeftNodes(IntTreeNode current) {
        IntTreeNode root = current;
        int count = 0;
        if (root != null) {
           if (root.left != null) {
                count++;
            }
            return count + countLeftNodes(root.left) + countLeftNodes(root.right);
        }
        return 0;


    }

    // ---- Ex2 ----
    public int countEmpty() {
        if (overallRoot != null) {
            return countEmpty(overallRoot);
        }
        return 1;
    }

    private int countEmpty(IntTreeNode current) {
        int count = 0;
        IntTreeNode root = current;
        if (root != null) {
            if ((root.left == null && root.right != null) || (root.right == null && root.left != null)) {
                count++;
            } else if (root.left == null && root.right == null) {
                count = +2;
            }

            return count + countEmpty(root.left) + countEmpty(root.right);
        }

        return 0;
    }

    // ---- Ex4 ----
    public int countEvenBranches() {
        if (overallRoot != null) {
            return countEvenBranches(overallRoot);
        }
        return 0;
    }

    private int countEvenBranches(IntTreeNode current) {
        int count = 0;
        IntTreeNode root = current;
        if (root != null) {
            if (root.left != null && root.right != null) {
                if (root.data % 2 == 0) {
                    count++;
                }
            }

            return count + countEvenBranches(root.left) + countEvenBranches(root.right);
        }

        return 0;
    }

    // ---- Ex5 ----
    public void printLevel(int level) {
        if (overallRoot != null) {
            printLevel(level, overallRoot, 0);
        }
    }

    private void printLevel(int level, IntTreeNode current, int currentLevel2) {
        int currentLevel = currentLevel2;
        IntTreeNode root = current;
        if (currentLevel == level) {
            System.out.print(current.data);
        }
        else {
            printLevel(level, root.left, currentLevel+1);
            printLevel(level, root.right, currentLevel+1);
        }
    }

    // ---- Ex6 ----
    public void printLeaves() {
        if (overallRoot != null) {
            printLeaves(overallRoot);
        }
    }

    private void printLeaves(IntTreeNode current) {
        IntTreeNode root = current;
        if (root != null) {
            if (root.left == null && root.right == null) {
                System.out.print(root.data + " ");
            }
            printLeaves(root.right);
            printLeaves(root.left);
        }

    }

    // ---- Ex7 ----
    public boolean isFull() {
        if (overallRoot == null) {
            return true;
        }
        else {
            return isFull(overallRoot);
        }
    }

    private boolean isFull(IntTreeNode current) {
        IntTreeNode root = current;

        if (root != null) {
            if ((root.left == null && root.right != null) || (root.right == null && root.left != null)) {
                return false;
            }
            else if ((root.left == null && root.right == null) || (root.left != null && root.right != null)) {
               return isFull(root.left) && isFull(root.right);
            }

        }
        return true;
    }

    // ---- Ex8 ----
    public String toString() {
        String temp = "";
        if (overallRoot != null) {
            return  toString(overallRoot, temp);
        }
        return "Tree is empty";
    }

    private String toString(IntTreeNode current, String temp) {
        IntTreeNode root = current;
        String result = temp;
        if (root != null) {
            result = result + "(" + root.data + toString(root.left, result) + toString(root.right, result) + ")";
        }
        return result;
    }

}
