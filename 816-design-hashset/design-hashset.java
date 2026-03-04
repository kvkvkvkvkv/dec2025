// class MyHashSet {
//     Bucket[] buckets;
//     public MyHashSet() {
//         buckets = new Bucket[500];
//     }
    
//     public void add(int key) {
//         int idx = key % 500;
//         if(buckets[idx] == null) {
//             buckets[idx] = new Bucket();
//         }
//         buckets[idx].put(key);
//     }
    
//     public void remove(int key) {
//         int idx = key % 500;
//         if (buckets[idx] == null) {
//             return;
//         }
//         buckets[idx].remove(key);
    
//     }
    
//     public boolean contains(int key) {
//         int idx = key % 500;
//         if (buckets[idx] == null) {
//             return false;
//         }
//         return buckets[idx].contains(key);
//     }
// }

class MyHashSet {
    BSTBucket[] buckets;
    public MyHashSet() {
        buckets = new BSTBucket[500];
    }
    
    public void add(int key) {
        int idx = key % 500;
        if(buckets[idx] == null) {
            buckets[idx] = new BSTBucket();
        }
        buckets[idx].insert(key);
    }
    
    public void remove(int key) {
        int idx = key % 500;
        if (buckets[idx] == null) {
            return;
        }
        buckets[idx].delete(key);
    
    }
    
    public boolean contains(int key) {
        int idx = key % 500;
        if (buckets[idx] == null) {
            return false;
        }
        return buckets[idx].contains(key);
    }
}

class Bucket {
    LinkedList<Integer> values;

    Bucket() {
        values = new LinkedList<>();
    }

    public int put(int value) {
        if (!values.contains(value)) {
            values.add(value);
            return value;
        }
        return -1;
    }

    public boolean contains(int value) {
        if (!values.contains(value)) {
            return false;
        }
        return true;
    }

    public int remove(int value) {
        if (!values.contains(value)) {
            return -1;
        }
        values.remove(Integer.valueOf(value));
        return value;
    }
}

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int key) {
        this.key = key;
        left = null;
        right = null;
    }
}
class BSTBucket {
    TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        root = insertInBST(root, value);
    }

    public TreeNode insertInBST(TreeNode root, int value) {
        if(root == null) {
            return new TreeNode(value);
        }
        if(root.key>value) {
            root.left = insertInBST(root.left, value);
        } else if(root.key<value){
            root.right = insertInBST(root.right, value);
        } 
        return root;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    public boolean contains(TreeNode root, int value) {
        if(root == null) {
            return false;
        }

        if(root.key == value) {
            return true;
        }
        if(root.key>value) {
            if(contains(root.left, value)) {
                return true;
            }
        } else {
            if(contains(root.right, value)) {
                return true;
            }
        } 
        return false;
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        root = deleteInBST(root, value);
    }

    private TreeNode deleteInBST(TreeNode root, int value) {
        if(root == null) {
            return null;
        }

        if(root.key>value) {
            TreeNode child = deleteInBST(root.left, value);
            root.left = child;
        } else if(root.key < value){
            TreeNode child = deleteInBST(root.right, value);
            root.right = child;
        } else {
            return delete(root);
        }
        return root;
    }

    TreeNode delete(TreeNode child) {
        if(child.left == null && child.right == null) {
            return null;
        }
        if(child.left == null) {
            return child.right;
        }
        if(child.right == null) {
            return child.left;
        }
        TreeNode newRoot = child.right;
        TreeNode right = child.right;
        while(right.left != null) {
            right = right.left;
        }
        right.left = child.left;
        child.right = null;
        child.left = null;
        return newRoot;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */