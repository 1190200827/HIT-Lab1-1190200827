package P3;
import DataStructure.linktable;
import P3.Person;

public class FriendshipGraph {
    int num;
    Person head;
    int[][] relationship=new int[10000][10000];
    public FriendshipGraph(){
        this.head=new Person(null);
        this.num=0;
    }
    public void addEdge(String a,String b ){
        int aid=search(a);
        int bid=search(b);
        if(aid==1000||bid==1000) {
            System.out.println("上述两人中有人不存在！");
            return ;
        }
        else {
            relationship[aid][bid] = 1;
            relationship[bid][aid] = 1;
        }
    }
    public int search(String name){
        Person node=head.next;
        while(node!=null){
            if(node.name==name)
                return node.id;
            else
                node=node.next;
        }
        return 10001;
    }
    public void addVertex(String name){
        Person p=new Person(name);
        Person oldhead=head;
        while(oldhead.next!=null) {
            if(oldhead.next.name==name)
                System.out.println("您违背了不同名原则！");
            oldhead=oldhead.next;
        }
        oldhead.next=p;
        p.id=num;
        num++;
    }
    public int getDistance(String a,String b){
        int[][] road=new int[num][num];
        for(int i=0;i<=num-1;i++){
            for(int j=0;j<=num-1;j++){
                road[i][j]=relationship[i][j];
            }
        }
        int aid=search(a);
        int bid=search(b);
        if(aid==10001||bid==10001){
            System.out.println("上述两人中有人不存在！");
            return -1;
        }
        for(int k=0;k<=num-1;k++){
            for(int i=0;i<=num-1;i++){
                for(int j=0;j<=num-1;j++){
                    if(road[i][j]!=0){
                        if(road[i][j]>relationship[i][k]+relationship[k][j]){
                            road[i][j]=relationship[i][k]+relationship[k][j];
                        }}}}}


        return road[aid][bid]==0?-1:road[aid][bid];
    }

}
