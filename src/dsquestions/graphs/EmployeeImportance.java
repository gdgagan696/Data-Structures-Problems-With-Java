package dsquestions.graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> graph = new HashMap<>();
        for (Employee employee : employees) {
            graph.put(employee.id, employee);
        }
        return dfs(graph, id);
    }

    public int dfs(Map<Integer, Employee> graph, int src) {

        Employee employee = graph.get(src);
        int total = employee.importance;
        for (int temp : employee.subordinates) {
            total += dfs(graph, temp);
        }
        return total;
    }
}
