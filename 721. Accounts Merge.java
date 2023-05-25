class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        Integer emailCount = 0;
        // maintain two hashMap to store unique email, with index mapping and name mapping
        for (List<String> account: accounts){
            String name = account.get(0);
            int n = account.size();
            for (int i = 1; i<n; i++){
                if(!emailToIndex.containsKey(account.get(i))){    // use account.get(i) not account[i]; [i] only applicable in array, not list
                    emailToIndex.put(account.get(i), emailCount++);
                    emailToName.put(account.get(i), name);
                }
            }
        }
        //UnionFind
        UnionFind uf = new UnionFind(emailCount);
        for (List<String> account: accounts){
            int firstIndex = emailToIndex.get(account.get(1));
            int n = account.size();
            for (int i=2; i<n; i++){
                int nextIndex = emailToIndex.get(account.get(i));
                uf.Union(firstIndex, nextIndex);
            }
        }
        // create new hashMap, grouped index - email list
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email: emailToIndex.keySet()){
            int groupIndex = uf.Find(emailToIndex.get(email));  // don't miss to use uf.Find!!!
            List<String> emailList = indexToEmails.getOrDefault(groupIndex, new ArrayList<String>());
            emailList.add(email);
            indexToEmails.put(groupIndex, emailList);
        }
        // create return answer
        List<List<String>> ans = new ArrayList<List<String>>(); // use ArrayList<List<String>>() instead of List<List<String>>()
        for(List<String> emails : indexToEmails.values()){
            List<String> account = new ArrayList<String>();     // use ArrayList<String>() instead of List<String>()
            String name = emailToName.get(emails.get(0));
            account.add(name);
            Collections.sort(emails);
            account.addAll(emails);
            ans.add(account);
        }
        return ans;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n){
        parent = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
    }

    public void Union(int i, int j){
        parent[Find(i)] = Find(j);
    }

    public int Find(int i){
        if (parent[i] != i){
            parent[i] = Find(parent[i]);
        }
        return parent[i];
    }
}