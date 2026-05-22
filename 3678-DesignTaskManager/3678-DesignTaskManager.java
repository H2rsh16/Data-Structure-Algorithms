// Last updated: 22/05/2026, 11:19:00
import java.util.*;

class TaskManager {
    private Map<Integer, int[]> taskMap;
    private PriorityQueue<int[]> maxHeap;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (List<Integer> task : tasks) {
            int userId = task.get(0), 
            taskId = task.get(1),
            priority = task.get(2);
            
            taskMap.put(taskId, new int[]{userId, priority});
            maxHeap.offer(new int[]{-priority, -taskId, taskId});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        maxHeap.offer(new int[]{-priority, -taskId, taskId});
    }

    public void edit(int taskId, int newPriority) {
        if (!taskMap.containsKey(taskId)) return;
        int userId = taskMap.get(taskId)[0];
        taskMap.put(taskId, new int[]{userId, newPriority});
        maxHeap.offer(new int[]{-newPriority, -taskId, taskId});
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int taskId = top[2];
            if (!taskMap.containsKey(taskId)) continue;

            int[] data = taskMap.get(taskId);
            int userId = data[0], priority = data[1];
            if (-top[0] == priority) {
                taskMap.remove(taskId);
                return userId;
            }
        }
        return -1;
    }
}
