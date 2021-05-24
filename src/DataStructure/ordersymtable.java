package DataStructure;
public class ordersymtable<Key extends Comparable<Key>,Value>{
    public  ordersymtable(){
        this.head=new node(null,null,null);
        this.N=0;
    }
    public void put(Key key,Value value){
        node n=head.next;
        node pre=head;
        while(n!=null&&key.compareTo(n.key)>0){
            pre=n;
            n=n.next;
        }
        if(n!=null&&key.compareTo(n.key)==0){
            n.value=value;
            return ;        }
        node newnode =new node(key,value,n);
        pre.next=newnode;
    }
    public void delete(Key key){
        node n=head;
        while(n.next!=null){
            if(key.equals(n.next.key)){
                n.next=n.next.next;
                N--;
                return;
            }
            n=n.next;
        }
    }
    public Value get(Key key){
        node n =head;
        while(n.next!=null){
            n=n.next;
            if(n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }
    public int size(){ return N;};
    public node head;
    int N;
    private class node{
        public Key key;
        public Value value;
        public node next;
        public node(Key key,Value value,node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
}
