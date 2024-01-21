//BFS tc: o(m*n) sc: o(m*n)
class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.m = image.length;
        this.n = image[0].length;
        if(image[sr][sc] == color) return image;
        int oc = image[sr][sc];
        Queue<Integer> q = new LinkedList();
        q.add(sr);q.add(sc);
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc] == oc){
                    q.add(nr); q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}
//DFS tc: o(m*n) sc: o(m*n)
class Solution1 {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length ==0) return image;
        this.m = image.length;
        this.n = image[0].length;
        
        if(image[sr][sc] == color) return image;
        int oc = image[sr][sc];
        dfs(image,sr,sc,oc,color,m,n);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldcolor, int color, int m, int n){
        //base
        if(sr==m||sc==n||sr<0||sc<0||image[sr][sc] != oldcolor) return;
        //logic
        image[sr][sc] = color;
        for(int[] dir: dirs){
            int nr = sr+dir[0];
            int nc = sc+dir[1];
            dfs(image,nr,nc,oldcolor, color,m,n);
        }
    }
}
