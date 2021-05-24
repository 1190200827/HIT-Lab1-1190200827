package DataStructure;

public class Graph{
    public int vertex;
    public int[][]  A=new int[vertex][vertex];
    int[] indegree=new int[vertex];
    public int edgenum;
    public Graph(int vertex,int[][] A){
        this.vertex=vertex;
        this.A=A;
    }

}
