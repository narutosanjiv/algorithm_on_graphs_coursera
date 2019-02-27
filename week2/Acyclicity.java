import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Acyclicity {

    private static int explore(ArrayList<Integer>[] adj, int source, int [] visited){
        visited[source] = 1;

        // Iterator to traverse the list
        Iterator iterator = adj[source].iterator();
        while (iterator.hasNext()) {
            int nextSource = (int) iterator.next();
            if (visited[nextSource] == 1)
                return 1;
            if (visited[nextSource] == 0)
                return explore(adj, nextSource, visited);
        }

        return 0;
    }
    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
        int n=adj.length;
        int isPath=0;
        int [] visited = new int[adj.length];
    
        for(int i=0;i < n;i++){
            for (int j = 0; j < adj.length; j++) {
                visited[j] = 0;
            }
            isPath = explore(adj, i, visited);
            if(isPath == 1)
                break;
        }
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
        }
        System.out.println(acyclic(adj));
    }
}

