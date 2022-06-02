package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Graph
 */
public class Graph 
{
    private ArrayList<HashMap<Integer,Integer>> g;
    private int vertices;
    private int edges;
    private int[] parent;
    private int[] entryTime;
    private int[] exitTime;
    public Graph(boolean directed,int vertices,int edges, int[][] edge)
    {
        //directed -> if directed or not
        //vertices -> no of vertices
        // edges -> no of edges
        // edge -> (x,y) signifying an edge
        // weights -> weigh for each edge
        this.vertices = vertices;
        this.edges = edges;
        if (directed) 
        {
            initializeDirectedGraph(vertices,edges,edge);
        }
        else
        {
            initializeUndirectedGraph(vertices,edges,edge);
        }
        
    }

    private void initializeDirectedGraph(int vertices, int edges, int[][] edge) {
    }

    private void initializeUndirectedGraph(int vertices,int edges, int[][] edge) 
    {
        //Each index in arraylsit has a Hashmap
        //each element in hashmap cantake 2 forms 
            // 1. <value,weight> -> value of that vertices and weight of edge b/w them
            // 2. <value,direction> -> in case of directed graphs direction is 1 if forward, -1 if backward and 0 if no direction
        g = new ArrayList<HashMap<Integer,Integer>>(vertices+1);

        for (int i = 1; i <= vertices+1; i++) 
        {
            HashMap<Integer,Integer> list = new HashMap<>();
            g.add(list);       
        }

        for (int[] k : edge) 
        {
            insertEdge(k[0],k[1]);
        }
    
    }

    public void insertEdge(int vertex1, int vertex2 ) 
    {
        // for an unweighted graph value of weights is always 1
        //putting (x,y) int graph
        HashMap<Integer,Integer> vertexForWhichAddEdge = g.get(vertex1);
        vertexForWhichAddEdge.putIfAbsent(vertex2, 1);

        //putting (y,x) in graph
        vertexForWhichAddEdge = g.get(vertex2);
        vertexForWhichAddEdge.putIfAbsent(vertex1, 1);
    }   

    public void printGrapth()
    {
        int i = 0;
        for (HashMap<Integer,Integer> hashMap : g) {
            if(i==0)
            {
                i++;
                continue;
            }
            System.out.println(hashMap.keySet().toString());
        
        }
    }

//#region Breadth First Search
    public void breathFirstSearch() {
        Boolean[] processed = new Boolean[vertices + 1]; /* which vertices have been processed */
        Boolean[] discovered = new Boolean[vertices + 1]; /* which vertices have been found */
        parent = new int[vertices + 1]; /* discovery relation */

        for (int i = 1; i <= vertices; i++) {
            processed[i] = false;
            discovered[i] = false;
            parent[i] = -1;
        }
        for (int i = 1; i <= vertices; i++) {
            if (!discovered[i]) {
                System.out.println("bfs at " + i + " gave us: ");
                bfs(i, processed, discovered, parent);

            }
        }
    }

    private void bfs(int vertex, Boolean[] processed, Boolean[] discovered, int[] parent) {

        Queue<Integer> visited = new LinkedList<Integer>();
        visited.add(vertex);
        discovered[vertex] = true;
        while (!visited.isEmpty()) {
            int v = visited.remove();
            processVertexEarly(v);
            processed[v] = true;

            for (int i : g.get(v).keySet()) {
                if (!processed[i]) {
                    processEdge(v, i);
                }
                if (!discovered[i]) {
                    visited.add(i);
                    discovered[i] = true;
                    parent[i] = v;
                }
            }
            processVertexLate(v);
        }
    }

    private void processVertexLate(int v) {
        System.out.println("End of Processing vertex: " + v);
    }

    private void processEdge(int v, int i) {
        System.out.println("Processed Edge: " + v + " " + i);
    }

    private void processVertexEarly(int v) {
        System.out.println("Start of Processing vertex: " + v);
    }
//#endregion
 

//#region Find Path

    public void findPath(int start, int end)
    {
        if (start == end || end == -1)
        {
            System.out.println(start);
        }
        else
        {
            findPath(start,parent[end]);
            System.out.println(end);
        }

    }
//#endregion


//#region Depth First Search

public void depthFirstSearch()
{
    int time = 0;
    Boolean[] processed = new Boolean[vertices + 1]; /* which vertices have been processed */
    Boolean[] discovered = new Boolean[vertices + 1]; /* which vertices have been found */
    entryTime = new int[vertices + 1]; exitTime = new int[vertices+1]; /* time of entry and exit a vertex */
    parent = new int[vertices+1];
    for (int i = 1; i <= vertices; i++) {
        processed[i] = false;
        discovered[i] = false;
        entryTime[i] = 0;
        exitTime[i] = 0;
        parent[i] = -1;
    }
    
    for(int i = 1 ; i<=vertices ; i++)
    {
        dfs(i,time,processed,discovered,entryTime,exitTime);
    }
}


public int dfs(int v, int time, Boolean[] processed, Boolean[] discovered, int[] entryTime, int[] exitTime)
{
    discovered[v] = true;
    time++;
    entryTime[v] = time;

    processVertexEarly(v);

    for (int i : g.get(v).keySet()) 
    {
        if (!discovered[i]) 
        {
            parent[i] = v;
            processEdge(v, i);
            time = dfs(i, time, processed, discovered, entryTime, exitTime);  
        }
        else if(!processed[i] && parent[v] != i)
        {
            processEdge(v, i);
        }
    }
    processVertexLate(v);
    time++;
    exitTime[v] = time;
    processed[v] = true;
    return time;
}

public static void main(String[] args)
    {
        int vertices = 8;
        int[][] edges = new int[][]{{1,8},{1,7},{1,2},{2,3},{2,5},{2,7},{3,4},{3,5},{4,5},{5,6}};
        Graph g = new Graph(false, vertices, edges.length, edges);
        g.printGrapth();
        System.out.println();
        
        g.breathFirstSearch();
        g.findPath(1, 4);


        int time = 0;
        Boolean[] processed = new Boolean[vertices + 1]; /* which vertices have been processed */
        Boolean[] discovered = new Boolean[vertices + 1]; /* which vertices have been found */
        int [] entryTime = new int[vertices + 1]; int[] exitTime = new int[vertices+1]; /* time of entry and exit a vertex */
        int[] parent = new int[vertices+1];
        for (int i = 1; i <= vertices; i++) {
            processed[i] = false;
            discovered[i] = false;
            entryTime[i] = 0;
            exitTime[i] = 0;
            parent[i] = -1;
        }
        g.dfs(1, time, processed, discovered, entryTime, exitTime); 

    }
}
