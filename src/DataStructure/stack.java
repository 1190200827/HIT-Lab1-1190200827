package DataStructure;
import java.util.Iterator;

public class stack<T>implements Iterable<T> {
    public int N;
    public boolean isempty(){
        return N==0;
    }
    public int size(){return N;}
    public T pop(){
        node oldfirst=head.next;
        if(oldfirst==null){
            return null;
        }
        head.next=oldfirst.next;
        N--;
        return oldfirst.item;
    }  public T top(){
        node oldfirst=head.next;
        if(oldfirst==null){
            return null;
        }
        return oldfirst.item;
    }
    public void push(T t){
        if(t.equals(null)){return;}
        node oldfirst=head.next;
        node newnode =new node(t,null);
        head.next=newnode;
        newnode.next=oldfirst;
        N++;
    }
    public node head;
    public class node{
        T item;
        node next;
        public node(T item,node next){
            this.item=item;
            this.next= next;
        }
    }
    public stack(){
        this.head=new node(null,null);
        this.N=0;
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
}

