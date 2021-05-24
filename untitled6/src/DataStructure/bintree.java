package DataStructure;

public class bintree<T> {
    public  bintree create(linktable<T> lk){
        queue<bintree<T>.node> q=new queue<>();
        linktable<T>.node  no= lk.head;
        if(lk.isempty()){return null;}
        bintree<T> dt=new bintree<T>(no.next.item);
        bintree<T>.node current=dt.root;
        q.enqueue(dt.root);
        T num;
        no=no.next;
        while(no.next!=null){


                current=q.dequeue();

            no=no.next;
            if(no==null){return  dt;}
            num=no.item;
            if(!num.equals(-1)){
                bintree<T>.node  newnode=new node(null,null,num);
                current.left=newnode;N++;
                q.enqueue(newnode);
            }
            no=no.next;
            if(no==null){return  dt;}
            num=no.item;
            if(!num.equals(-1)){
                bintree<T>.node  newnode=new node(null,null,num);
                current.right=newnode;N++;
                q.enqueue(newnode);

            }
        }
        return dt;

    }
    public node root;
    public int N;
    public bintree(T t){
        this.root=new node(null,null,t);
        this.N=0; }

    public void insertleft(node current, T item){
        node temp=current;

        if(temp.left==null){
            node newnode=new node(null,null,item);
            temp.left=newnode;
            N++;
            return;
        }
        if(temp.right==null){
            node newnode=new node(null,null,item);
            temp.right=newnode;
            N++;
            return;
        }
        insertleft(temp.left,item);
        insertleft(temp.right,item);
    }
    public void insertright(node current, T item){
        node temp=current;
        if(temp.right==null){
            node newnode=new node(null,null,item);
            temp.right=newnode;
            N++;
            return;
        }
        if(temp.left==null){
            node newnode=new node(null,null,item);
            temp.left=newnode;
            N++;
            return;
        }

        insertright(temp.left,item);
        insertright(temp.right,item);
    }
    public void insert(T item){
        node temp=root;
        if(temp.left==null){
            node newnode=new node(null,null,item);
            temp.left=newnode;
            N++;
            return;
        }
        if(temp.right==null){
            node newnode=new node(null,null,item);
            temp.right=newnode;
            N++;
            return;
        }
        insertleft(temp.left,item);
        insertleft(temp.right,item);
    }
    public  node deleteleft(node current){
        node temp=current.left;
        current.left=null;
        N--;
        return temp;
    }
    public  node deleteright(node current){
        node temp=current.right;
        current.right=null;
        N--;
        return temp
                ;
    }
    public  void level(bintree bt){
        queue<bintree.node> q=new queue<>();
        if(bt.root==null){
            System.out.println("空树");return;}
        bintree.node current=null;
        System.out.println(" "+bt.root.item.toString()+" ");
        q.enqueue(bt.root);
        int height=1;
        int n=0;
        while(!q.isempty()){
            current=q.dequeue();
            if(current.left!=null){n++;q.enqueue(current.left);if(n>(int)Math.pow(2,height)){ System.out.printf("\n");height++;n=1; }
                    System.out.printf(" "+current.left.item.toString()+" ");}
                else if(current.left==null){n++;if(n>(int)Math.pow(2,height)){ System.out.printf("\n");height++;n=1; }
                    System.out.printf(" null ");
                }
                if(current.right!=null){n++;q.enqueue(current.right);if(n>(int)Math.pow(2,height)){ System.out.printf("\n");height++;n=1; }System.out.printf(" "+current.right.item.toString()+" ");}
                else if(current.right==null){n++;if(n>(int)Math.pow(2,height)){ System.out.printf("\n");height++;n=1; }
                    System.out.printf(" null ");
                }
            }
    }
    public class node{
        public node left;
        public node right;
        public T item;
        public node(node left, node right, T item){
            this.item=item;
            this.left=left;
            this.right=right;
        }
    }
}