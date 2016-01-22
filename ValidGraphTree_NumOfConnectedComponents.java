public class solution {
    public static boolean validTree(int n, int[][] edges) {
        if (edges.length <= 1) return true;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return false;
        }
        return uf.count() == 1; //for number of connect components, just return uf.count();
    }

    public static class UnionFind {
        int[] groups;
        int count;
        UnionFind(int num) {
            count = num;
            groups = new int[num];
            for (int i = 0; i < num; i++) {
                groups[i] = i;
            }
        }
        public boolean union(int n1, int n2) {
            int group1 = find(n1);
            int group2 = find(n2);
            if (group1 == group2) return false;
            for (int i = 0; i < groups.length; i++){
                if (groups[i] == group1) groups[i] = group2;
            }
            count--;
            return true;
        }
        public int find(int node) {
            return groups[node];
        }
        public boolean areConnected(int n1, int n2) {
            return find(n1) == find(n2);
        }
        public int count() {
            return this.count;
        }

    }
}
