public class solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];

        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair : prerequisites) {
            if (!map.containsKey(pair[1])) {
                Set<Integer> set = new HashSet<Integer>();
                set.add(pair[0]);
                map.put(pair[1], set);
            } else map.get(pair[1]).add(pair[0]);
        }

        if (map.size() == numCourses) return new int[0];
        Stack<Integer> stack = new Stack<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        for (int key : map.keySet()) {
            if (!visited.contains(key) && !dfs(stack, visited, map, key)) return new int[0];
        }

        int size = stack.size();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            list.add(stack.pop());
        }

        for (int i = 0; i < numCourses; i++) {
            if (!list.contains(i)) list.add(i);
        }

        int[] ret = new int[list.size()];

        int index = 0;
        for(int i : list) {
            ret[index++] = i;
        }
        return ret;
    }

    private static boolean dfs(Stack<Integer> stack, Set<Integer> visited, HashMap<Integer, Set<Integer>> map, int key) {
        if (visited.contains(key) && stack.search(key) == -1) return false;
        if (visited.contains(key)) return true;

        visited.add(key);
        if (map.get(key) != null) {
            for (int course : map.get(key)) {
                if (!dfs(stack, visited, map, course)) return false;
            }
        }
        stack.push(key);

        return true;
    }
}
