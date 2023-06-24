//dfs
class Solution {
    int ret = 0;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> employeesMap = new HashMap<>();
        for(Employee e: employees){
            employeesMap.put(e.id, e);
        }
        dfs(employeesMap, id);
        return ret;
    }

    public void dfs(HashMap<Integer, Employee> employeesMap, int id){
        Employee employee = employeesMap.get(id);
        ret += employee.importance;
        for (int i : employee.subordinates){
            dfs(employeesMap, i);
        }
    }
}


//bfs
class Solution {
    public int getImportance(List<Employee> employees, int id) {
		HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
		int ret = 0;
        Queue<Employee> queue = new LinkedList<Employee>();
        queue.offer(map.get(id));
        while(!queue.isEmpty()){
            Employee curr_e = queue.poll();
            ret += curr_e.importance;
            for (int i: curr_e.subordinates){
                queue.offer(map.get(i));
            }
        }
        return ret;
    }
}
