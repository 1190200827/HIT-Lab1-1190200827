package P3test;


public class FriendshipGraph {
    int num;
    Person head;
    int[][] relationship;
    public FriendshipGraph(){
        this.num=0;
        this.head=new Person(null);
        this.relationship=new int[10000][10000];
    }

    public void addEdge(Person a,Person b ){
        int aid=search(a.name);
        int bid=search(b.name);
        if(aid==10001||bid==10001) {
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
    public void addVertex(Person q){
        Person p=new Person(q.name);
        Person oldhead=head;
        while(oldhead.next!=null) {
            if(oldhead.next.name==q.name)
                System.out.println("您违背了不同名原则！");
            oldhead=oldhead.next;
        }
        oldhead.next=p;
        p.id=num;
        num++;
    }
    public int getDistance(Person a,Person b){
        int[][] road=new int[num][num];
        for(int i=0;i<=num-1;i++){
            for(int j=0;j<=num-1;j++){
                road[i][j]=relationship[i][j];
            }
        }
        if(a==b)return 0;
        int aid=search(a.name);
        int bid=search(b.name);
        if(aid==10001||bid==10001){
            System.out.println("上述两人中有人不存在！");
            return -1;
        }
        for(int k=0;k<=num-1;k++){
            for(int i=0;i<=num-1;i++){
                for(int j=0;j<=num-1;j++){
                        if(road[i][j]<=relationship[i][k]+relationship[k][j]&&relationship[i][k]!=0&&relationship[k][j]!=0){
                            road[i][j]=relationship[i][k]+relationship[k][j];
                        }}}}


        return road[aid][bid]==0?-1:road[aid][bid];
    }

}
