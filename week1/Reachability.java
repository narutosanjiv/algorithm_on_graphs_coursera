import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;

public class Reachability {
    private static int explore(ArrayList<Integer>[] adj, int source, int destination, int [] visited){
        visited[source] = 1;
        
        if(source == destination){
            System.out.println("Found the path from " + source + " to " + destination);
            return 1;   
        }
        // Iterator to traverse the list 
        Iterator iterator = adj[source].iterator();
        while (iterator.hasNext()){
            int nextSource = (int)iterator.next();
            if(visited[nextSource] == 0)
                return explore(adj, nextSource, destination, visited);
        }

        return 0;
    }

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        int [] visited = new int[adj.length];
        for (int i = 0; i < adj.length; i++) {
            visited[i] = 0;
        }
        int isPath = explore(adj, x, y, visited);
        return isPath;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}
