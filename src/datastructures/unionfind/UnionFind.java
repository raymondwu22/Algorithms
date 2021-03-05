package datastructures.unionfind;

public class UnionFind {
    private int size; // number of elements in the union find
    private int[] sz; // track the sizes of each of the components
    private int[] id; // id[i] points to the parent of i, if id[i] = i then i is a root node
    private int numComponents; // number of components in the union find

    public UnionFind(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");

        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i; // link to itself (self root)
            sz[i] = 1; // each component is originally size 1
        }
    }

    // Find which component/set 'p' belongs to, takes amortized constant time.
    public int find(int p) {
        // find the root of the component/set
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        // compress the path leading back to the root.
        // allowed amortized constant time complexity.
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    // Return whether or not the elements 'p' and
    // 'q' are in the same components/set.
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // return the size of the components/set 'p' belongs to
    public int componentSize(int p) {
        return sz[find(p)];
    }

    // returns the number of remaining components/sets
    public int components() {
        return numComponents;
    }

    // unify the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        // these elements are already in the same group
        if (root1 == root2) return;

        // else merge 2 components together
        // merge smaller component/set into the larger
        if (sz[root1] < sz[root2]) {
            sz[root2] += sz[root1];
            id[root1] = root2;
        } else {
            sz[root1] += sz[root2];
            id[root2] = root1;
        }

        numComponents--;
    }


}
