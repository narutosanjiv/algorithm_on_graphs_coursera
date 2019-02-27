import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class ConnectedComponents {
    private static int explore(ArrayList<Integer>[] adj, int source, boolean [] visited){
        visited[source] = true;

        // Iterator to traverse the list 
        Iterator iterator = adj[source].iterator();
        while (iterator.hasNext()){
            int nextSource = (int)iterator.next();
            if(!visited[nextSource])
                return explore(adj, nextSource, visited);
        }

        return 0;
    }
    
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        //write your code here
        //write your code here
        int total_no_vertics = adj.length;
        boolean [] visited = new boolean[total_no_vertics];
        for (int i = 0; i < adj.length; i++) {
            visited[i] = false;
        }
        for(int i = 0; i < total_no_vertics; i++){
            if(!visited[i]){
                explore(adj, i, visited);
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

