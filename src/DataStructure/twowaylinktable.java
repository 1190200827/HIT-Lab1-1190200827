package DataStructure;
import java.util.Iterator;

public class twowaylinktable<T>implements Iterable<T> {
    private node  last;
    private node head;
    int N;
    public twowaylinktable(){
        this.head=new node(null,null,null);
        this.last=null;
        this.N=0;
    }
    private class node{
        T item;
        node next;
        node pre;
        public node(T item,node pre,node next){
            this.item=item;
            this.pre=pre;
            this.next=next;
        }
    }
    public void  clear(){
        this.head.next=null;
        this.head.pre=null;
        this.N=0;
        this.head.item=null;
    }
    public int length(){
        return N;
    }
    public boolean isempty(){
        return N==0;
    }
    public T getfirst(){
        if(isempty()){return null;}
        return head.next.item;
    }
    public T getlast(){
        if(isempty()){return null;}
        return last.item;
    }
    public void add(T t){
        if(isempty()){node newnode=new node(t,head,null);
            last=newnode;
            head.next=last;
        }else{
            node oldlast=last;
            node newnode =new node(t,oldlast,null);
            oldlast.next=newnode;
            last=newnode;
        }
        this.N++;
    }
    public void insert(int i,T t){
        node temp=head;
        for(int j=0;j<=i;j++){
            temp=temp.next;
        }
        node tem=temp.next;
        node newnode =new node(t,temp.pre,tem.pre);
        temp.pre.next=newnode;
        newnode.next=tem.pre;
        this.N++;
    }
    public T get(int i){
        node temp=head;
        for(int j=0;j<=i;j++){
            temp=temp.next;
        }
        return temp.item;
    }
    public int indexof(T t) {
        node temp = head;
        int i = 0;
        while (temp!= null) {

            if (temp.next.item.equals(t)) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }
    public T remove(int i){
        node temp=head;
        for(int j=0;j<i;j++){
            temp=temp.next;
        }
        node tem=temp.next;
        temp.next=tem.next;
        tem.next.pre=temp;
        this.N--;
        return temp.next.item;
    }
    public Iterator<T> iterator(){
        return new TIteator();
    }
    private class TIteator implements Iterator{
        private node n;
        public TIteator(){
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

    public void modify(int i,T t){
        node temp=head;
        for(int j=0;j<=i;j++){
            temp=temp.next;
        }
        temp.item=t;
    }
}