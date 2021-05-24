package DataStructure;
import java.util.Iterator;
public class linktable<T> implements Iterable<T>{
    public linktable(){
        this.head=new node(null,null);
        this.N=0;
    }
    public void clear(){
        this.N=0;
        head.next=null;}
    public boolean isempty(){return N==0;}
    public T get(int i){
        node n=head.next;
        for(int index=0;index<i;index++){
            n=n.next;

        }
        return n.item;
    }
    public int length(){return N;}
    public  void add(T t){
        node n=head;
        while(n.next!=null){
            n=n.next;
        }
        node newnode= new node(t,null);
        n.next=newnode;
        N++;
    }
    public void insert(int i,T t){
        node n=head;
        for(int index=0;index<i;index++){
            n=n.next;
        }
        node cur = n.next;
        node newnode = new node(t,cur);
        n.next=newnode;
        N++;
    }
    public void modify(int i,T t){
        node n =head;
        for(int index=0;index<=i-1;index++){
            n=n.next;
        }
        n.next.item=t;

    }
    public T remove(int i){
        node n =head;
        for(int index=0;index<=i-1;index++){
            n=n.next;
        }
        node cur=n.next;
        node nextnode = cur.next;
        n.next=nextnode;
        N--;

        return cur.item;}
    public int indexof(T t){
        node n= head;
        for(int i=0;n.next!=null;i++){
            n=n.next;
            if(n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    public class node{
        public T item ;
        public node next;
        public node(T item,node next){
            this.item=item;
            this.next=next;

        }
    }
    public  node head;
    int N;
    public Iterator<T> iterator(){
        return new SIteator();
    }
    private class SIteator implements Iterator{
        private node n;
        public SIteator(){
            this.n=head;
        }
        @Override
        public boolean hasNext(){
            return n.next!=null;
        }
        @Override
        public Object next(){
            n=n.next;
            return n.item;
        }
    }
    public void reverse(){
        if(isempty()){
            return;
        }
        reverse((head.next));
    }
    public node reverse(node current){
        if(current.next==null){
            head.next=current;
            return  current;
        }
        node pre= reverse(current.next);
        pre.next=current;
        current.next=null;
        return current;

    }
     public void uncircle(){
        node temp=head;
        for(int i=0;i<N;i++){
            temp=temp.next;
        }
        temp.next=null;
     }
    public void circle() {
        node temp = head;
        for (int i=0; i < N; i++) {
            temp=temp.next;;
        }
        temp.next=head.next;
    }}
