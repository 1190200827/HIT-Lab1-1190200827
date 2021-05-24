package DataStructure;
import java.util.Iterator;
public class queue <T>implements Iterable<T>{
    public node head;
    public int N;
    public node last;
    public class node{
        T item;
        node next;
        public node(T t,node next){
            this.item=t;
            this.next=next;
        }
    }
    public queue(){
        this.head =new node(null,null);
        this.last=null;
        this.N=0;
    }
    public boolean isempty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public T dequeue(){
        if(isempty()){
            return null;
        }
        node oldfirst=head.next;
        head.next=oldfirst.next;
        N--;
        if(isempty()){
            last=null;
        }
        return oldfirst.item;
    }
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
    public void enqueue(T t){
        node newnode= new node(t,null);
        if(last==null){
            last =newnode;
            head.next=last;
        }else{
            node oldlast=last;
            last=newnode;
            oldlast.next=last;
        }N++;}
}
