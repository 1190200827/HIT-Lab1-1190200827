package DataStructure;
import java.util.Scanner;
public class tstack {
    public int[] item=new int[100];
    int N=0;
    public void setT(int[] item) { this.item=item; }
    public  int[] getItem(){ return  item; }
    String[] pointerone=new String[100];
    String[] pointertwo=new  String[100];
    String[] pointerthree=new String[100];
    public class stack{
        public stack(String[] pointer){ this.pointer=pointer; }
        String[] pointer;
        public void setPointer(String[] pointer){ this.pointer=pointer; }
        public int  pop(){
            int i=0;
            if(pointer[i]==null){return -1;}
            for(i=0;pointer[i]!=null;i++){}
            int temp=item[Integer.parseInt(pointer[i-1])];
           int s=Integer.parseInt(pointer[i-1]);
            pointer[i-1]=null;
            item[s]=0;N--;
            return temp;}
        public void push(int t){int i=0,j=0;
        if(N==0){item[0]=t;  N++; pointer[0]="0";return;}
         while(pointer[j]!=null){j++;}pointer[j]=""+N;
            item[N]=t;
            N++;
        }}
    stack stack1=new stack(pointerone);
    stack stack2=new stack(pointertwo);
    stack stack3=new stack(pointerthree);
    public void push(int num){
        if(num<80){stack1.push(num);}
        if(num<=100&&80<=num){stack2.push(num);}
        if(num>100){stack3.push(num);}
    }

    public static void main(String[] args) {
       tstack ts=new tstack();
        int k=0;
        System.out.println("请向栈内输入元素（-1为标识请不要存储-1）（继续输入请输入y，停止输入请输入n）：");
        Scanner input =new Scanner(System.in);
        int num=0;String ch="y";
        while(ch.equals("y")){
            System.out.println("请输入：");num=input.nextInt();ts.push(num);
            System.out.println("继续输入吗？（y继续/n停止）");ch=input.next();}

        System.out.printf("存储空间：");
        int i=0;
        while(i<= ts.N-1){
            System.out.printf("%d ",ts.item[i]);i++;
        }
        int temp;
        temp=ts.stack1.pop();
        System.out.println();
        System.out.printf(" 栈1元素：");
        while(temp!=-1){
            System.out.printf("%d ",temp);
            temp=ts.stack1.pop();
        }  System.out.printf("\n 栈2元素：");
        temp=ts.stack2.pop();
        while(temp!=-1){
            System.out.printf("%d ",temp);
            temp=ts.stack2.pop();
        }
        System.out.printf("\n 栈3元素：");
        temp=ts.stack3.pop();
        while(temp!=-1){
            System.out.printf("%d ",temp);
            temp=ts.stack3.pop();
        }
        System.out.println();
        System.out.printf("清栈后的存储空间：");i=0;while(i<= ts.N-1){
            System.out.printf("%d ",ts.item[i]);i++;
        }
      }}
