// Last updated: 22/05/2026, 11:20:53
import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassNode> heap = new PriorityQueue<>((a, b) -> 
            Double.compare(b.gain(), a.gain())
        );

        for (int[] c : classes) {
            heap.offer(new ClassNode(c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            ClassNode best = heap.poll();
            best.addStudent();
            heap.offer(best);
        }

        double totalRatio = 0.0;
        for (ClassNode cls : heap) {
            totalRatio += cls.getRatio();
        }

        return totalRatio / classes.length;
    }

    private static class ClassNode {
        int pass;
        int total;

        public ClassNode(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        public void addStudent() {
            pass += 1;
            total += 1;
        }

        public double getRatio() {
            return (double) pass / total;
        }

        public double gain() {
            double curr = (double) pass / total;
            double next = (double) (pass + 1) / (total + 1);
            return next - curr;
        }
    }
}
