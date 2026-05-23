class UnionFind {
    Map<Integer, Integer> par;
    Map<Integer, Integer> rank;

    UnionFind(int n) {
        par = new HashMap<>();
        rank = new HashMap<>();

        for (int i = 0; i < n; i++) {
            par.put(i, i);
            rank.put(i, 1);
        }
    }

    public int find(int x) {
        if (x != par.get(x)) {
            par.put(x, find(par.get(x)));
        }

        return par.get(x);
    }

    public boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2) {
            return false;
        }

        if (rank.get(p1) > rank.get(p2)) {
            par.put(p2, p1);
            rank.put(p1, rank.get(p1) + rank.get(p2));
        } else {
            par.put(p1, p2);
            rank.put(p2, rank.get(p2) + rank.get(p1));
        }

        return true;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToAcc = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAcc.containsKey(email)) {
                    uf.union(i, emailToAcc.get(email));
                } else {
                    emailToAcc.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailToAcc.entrySet()) {
            String email = entry.getKey();
            int accId = entry.getValue();
            int leader = uf.find(accId);
            emailGroup.putIfAbsent(leader, new ArrayList<>());
            emailGroup.get(leader).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(emails);
            res.add(merged);
        }

        return res;
    }
}