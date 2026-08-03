class BSTIterator {

    ArrayList<Integer> list = new ArrayList<>();
    int start = 0;

    public void inOrder(TreeNode root) {

        if (root == null)
            return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public BSTIterator(TreeNode root) {
        inOrder(root);
    }

    public int next() {
        return list.get(start++);
    }

    public boolean hasNext() {
        return start < list.size();
    }
}