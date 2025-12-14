package dsquestions.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance {

    private Map<String, List<String>> childMap;
    private Map<String, String> parentMap;
    private String kingName;
    List<String> inheritanceOrder;

    public ThroneInheritance(String kingName) {

        this.kingName = kingName;
        this.childMap = new HashMap<>();
        this.parentMap = new HashMap<>();
        this.inheritanceOrder = new ArrayList<>();
        childMap.put(kingName, new ArrayList<>());
        parentMap.put(kingName, null);
    }

    public void birth(String parentName, String childName) {

        childMap.putIfAbsent(parentName, new ArrayList<>());
        childMap.get(parentName).add(childName);
        parentMap.put(childName, parentName);

    }

    public void death(String name) {

        parentMap.remove(name);
    }


    public List<String> getInheritanceOrder() {

        List<String> result = new ArrayList<>();
        dfs(kingName, result);
        return result;
    }

    private void dfs(String current, List<String> result) {

        if (parentMap.containsKey(current)) {
            result.add(current);
        }
        for (String child : childMap.getOrDefault(current, new ArrayList<>())) {
            dfs(child, result);
        }
    }

    public static void main(String[] args) {

        ThroneInheritance throneInheritance = new ThroneInheritance("king");
        throneInheritance.birth("king", "andy");
        throneInheritance.birth("king", "bob");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("andy", "matthew");
        throneInheritance.birth("bob", "alex");
        throneInheritance.birth("bob", "asha");
        System.out.println(throneInheritance.getInheritanceOrder());
        throneInheritance.death("bob");
        System.out.println(throneInheritance.getInheritanceOrder());


    }

}
