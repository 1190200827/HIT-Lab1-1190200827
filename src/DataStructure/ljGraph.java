package DataStructure;
public class ljGraph {
    class Vnode{
        char code;
        Enode firstedge;
    }
    class Enode{
        Enode next;
        int cost;
        int place;
    }
    int size;
    Vnode[]  Vertex=new Vnode[size];
}