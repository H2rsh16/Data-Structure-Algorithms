// Last updated: 22/05/2026, 11:20:24
class Robot {
    int width, height;
    int x = 0, y = 0;
    int dir = 0;
    
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    String[] dname = {"East", "North", "West", "South"};
    
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void step(int num) {
        int cycle = 2 * (width + height) - 4;
        
        if (cycle == 0) return;
        
        num %= cycle;
        
        if (num == 0) num = cycle;
        
        while (num > 0) {
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];
            
            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4;
            } else {
                x = nx;
                y = ny;
                num--;
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dname[dir];
    }
}