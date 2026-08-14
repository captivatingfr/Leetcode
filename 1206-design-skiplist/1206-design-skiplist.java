class Skiplist {
    static final int MAX_LEVEL = 16;

    class Node {
        int val;
        Node[] next;

        Node(int val, int level) {
            this.val = val;
            this.next = new Node[level];
        }
    }

    Node head;

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
    }
    private int randomLevel() {
        int level = 1;

        while (Math.random() < 0.5 && level < MAX_LEVEL) {
            level++;
        }

        return level;
    }

    public boolean search(int target) {

        Node current = head;

        for (int level = MAX_LEVEL - 1; level >= 0; level--) {

            while (current.next[level] != null &&
                   current.next[level].val < target) {

                current = current.next[level];
            }
        }
        current = current.next[0];

        return current != null && current.val == target;
    }

    public void add(int num) {

        Node[] update = new Node[MAX_LEVEL];

        Node current = head;

        for (int level = MAX_LEVEL - 1; level >= 0; level--) {

            while (current.next[level] != null &&
                   current.next[level].val < num) {

                current = current.next[level];
            }

            update[level] = current;
        }

        int level = randomLevel();

        Node newNode = new Node(num, level);
        for (int i = 0; i < level; i++) {

            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public boolean erase(int num) {

        Node[] update = new Node[MAX_LEVEL];

        Node current = head;

        for (int level = MAX_LEVEL - 1; level >= 0; level--) {

            while (current.next[level] != null &&
                   current.next[level].val < num) {

                current = current.next[level];
            }

            update[level] = current;
        }

        current = current.next[0];

        if (current == null || current.val != num) {
            return false;
        }

        for (int level = 0; level < MAX_LEVEL; level++) {
            if (update[level].next[level] != current) {
                break;
            }

            update[level].next[level] = current.next[level];
        }
        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */