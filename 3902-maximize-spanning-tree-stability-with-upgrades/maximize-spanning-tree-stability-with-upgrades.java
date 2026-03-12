class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return false;

            if(rank[pa] < rank[pb])
                parent[pa] = pb;
            else if(rank[pb] < rank[pa])
                parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int low = 0, high = (int)1e9;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(can(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);
        int upgrades = 0;
        int used = 0;

        // mandatory edges
        for(int[] e : edges) {

            int u = e[0], v = e[1];
            int s = e[2], must = e[3];

            if(must == 1) {

                if(!dsu.union(u, v))
                    return false;

                used++;

                if(s < target)
                    return false;
            }
        }

        // normal edges without upgrade
        for(int[] e : edges) {

            int u = e[0], v = e[1];
            int s = e[2], must = e[3];

            if(must == 0 && s >= target) {
                if(dsu.union(u, v))
                    used++;
            }
        }

        // edges with upgrade
        for(int[] e : edges) {

            int u = e[0], v = e[1];
            int s = e[2], must = e[3];

            if(must == 0 && s < target && 2 * s >= target) {

                if(dsu.union(u, v)) {
                    upgrades++;
                    used++;

                    if(upgrades > k)
                        return false;
                }
            }
        }

        return used == n - 1;
    }
}