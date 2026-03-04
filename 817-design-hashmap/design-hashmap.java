class MyHashMap {

    Bucket[] keys;
    public MyHashMap() {
        keys = new Bucket[200];
    }
    
    public void put(int key, int value) {
        int hash = key%200;
        if(keys[hash] == null) {
            keys[hash] = new Bucket();
        }
        keys[hash].insert(key, value);
    }
    
    public int get(int key) {
        int hash = key%200;
        if(keys[hash] == null) {
            return -1;
        }
        return keys[hash].get(key);
    }
    
    public void remove(int key) {
        int hash = key%200;
        if(keys[hash] == null) {
            return;
        }
        keys[hash].remove(key);
    }
}

class TreeNode {
    int key;
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket{
    TreeNode root;

    public void insert(int key, int value) {
        root = insert(root, key, value);
    }

    private TreeNode insert(TreeNode root, int key, int value) {
        if(root == null) {
            return new TreeNode(key, value);
        }
        if(root.key>key) {
            root.left = insert(root.left, key, value);
        } else if (root.key<key) {
            root.right = insert(root.right, key, value);
        } else {
            root.key = key;
            root.value = value;
        }
        return root;
    }

    public int get(int key) {
        return get(root, key);
    }

    private int get(TreeNode root, int key) {
        if(root == null) {
            return -1;
        }

        if(root.key == key) {
            return root.value;
        }

        if(root.key>key) {
            return get(root.left, key);
        } else {
            return get(root.right, key);
        }
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    private TreeNode remove(TreeNode root, int key) {
        if(root == null) {
            return root;
        }

        if(root.key>key) {
            root.left = remove(root.left, key);
        } else if(root.key < key){
            root.right = remove(root.right, key);
        } else {
            return delete(root);
        }
        return root;
    }

    private TreeNode delete(TreeNode root) {
        if(root == null) {
            return null;
        }

        if(root.left == null && root.right == null) {
            return null;
        }

        if(root.left == null) {
            return root.right;
        }

        if(root.right == null) {
            return root.left;
        }
        TreeNode head = root.right;
        TreeNode right = root.right;
        TreeNode left = root.left;
        while(right.left != null) {
            right = right.left;
        }
        right.left = left; 
        root.right = null;
        root.left = null;
        return head;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */