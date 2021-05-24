package P1;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;
public class Magicsquare {
    public static void main(String[] args) throws Exception{
        Scanner input =new Scanner(System.in);
        for(int i=0;i<=4;i++) {
            System.out.println("请输入文件的地址：");
            String filename=input.nextLine();
            System.out.println("第"+(i+1)+"次的结果："+isLegalMagicSquare(filename));
        }
        System.out.println("请输入一个奇数：");
        filewrite(generateMagicSquare(input.nextInt()));
        System.out.println("请输入文件的地址：");
        input.nextLine();
        String filename=input.nextLine();
        System.out.println("结果为："+isLegalMagicSquare(filename));
    }
  static  boolean  isLegalMagicSquare(String fileName) throws Exception{
        int[][] square=fileread(fileName);
        if(square==null){
            System.out.println("请重新输入！");
            return false;
        }
      System.out.println("矩阵为：");
        for(int i=0;i<=square.length-1;i++){
            System.out.println();
            for(int j=0;j<=square.length-1;j++)
                System.out.printf(square[i][j]+" ");
        }
      System.out.println();
        int sum1=0;
        int tempsum=0;
        for(int i=0;i<=square.length-1;i++) {
            tempsum=0;
            for (int j = 0; j <= square.length - 1; j++) {
                tempsum = tempsum + square[i][j];
            }
            if (i == 0) sum1 = tempsum;
            else{
                if(sum1!=tempsum) return  false;
            }
        }
        int sum2=0;
      for(int i=0;i<=square.length-1;i++) {
          tempsum=0;
          for (int j = 0; j <= square.length - 1; j++) {
              tempsum = tempsum + square[j][i];
          }
          if (i == 0) sum2 = tempsum;
          else{
              if(sum2!=tempsum) return  false;
          }
      }
      int sum3=0,sum4=0 ;
      for(int i=0;i<=square.length-1;i++){
          sum3=sum3+square[i][i];
      }
      for(int i=0;i<=square.length-1;i++){
          sum4=sum4+square[i][square.length-1-i];
      }

        return sum1==sum2&&sum3==sum4&&sum1==sum3;
    }
    static int[][] fileread(String filename)throws Exception{
        FileReader fr=new FileReader(filename);
        int m=0,n=0;
        stack<String> st=new stack<>();
        int b=fr.read();
        if(!(b==10||b==-1||b=='\t'||b==13||b==32||(b>=48&&b<=57))) {
            System.out.println("您的输入不规范！");
            return null;}//遇见非法字符退出
        st.push(""+(b-48));
        b=fr.read();
        while (b!=10&&b!=-1){//遇见换行符和结尾符跳出循环
            if(b==32||b=='\t'){
                b=fr.read();
                if(!(b==10||b==-1||b=='\t'||b==13||b==32||(b>=48&&b<=57))) {
                    System.out.println("您的输入不规范！");
                    return null;}
                if(st.top()!=" ")
                st.push(" ");
            }
            if(b==13){ //换行符之前的一个符号，将其读走
                b=fr.read();
                if(!(b==10||b==-1||b=='\t'||b==13||b==32||(b>=48&&b<=57))) {
                    System.out.println("您的输入不规范！");
                    return null;}             }
            if(b!=32&&b!=10) {
                if((st.top()!=" "&&st.top()!=null)){
                    st.push(st.pop()+(""+(b-48)));
                }
                else if(st.top()==null||st.top()==" "){
                    st.push(""+(b-48));
                }
                b=fr.read();
                if(!(b==10||b==-1||b=='\t'||b==13||b==32||(b>=48&&b<=57))) {
                    System.out.println("您的输入不规范！");
                    return null;}           }
        }  m=st.N;
        n++;
        int[][] square=new int[(m-1)/2+1][(m-1)/2+1];
        int i=(m-1)/2+1;
        while(!st.isempty()) {
            if(st.top()!=" "&&st.top()!=null) {
                square[n - 1][i - 1] = Integer.parseInt(st.pop());
                i--;
            }
                else
                st.pop();
        }
        b=fr.read();
        if(!(b==10||b==-1||b=='\t'||b==13||b==32||(b>=48&&b<=57))) {
            System.out.println("您的输入不规范！");
            return null;}
        while(b!=-1){
            while (b!=10&&b!=-1){//遇见换行符和结尾符跳出循环
                if(b==32||b=='\t'){
                b=fr.read();
                    if(!(b==10||b==-1||b=='\t'||b==13||b==32||(b>=48&&b<=57))) {
                        System.out.println("您的输入不规范！");
                        return null;}
                    st.push(" ");
                }
                if(b==13){ //换行符之前的一个符号，将其读走
                    b=fr.read();
                    if(!(b==10||b==-1||b=='\t'||b==13||b==32||(b>=48&&b<=57))) {
                        System.out.println("您的输入不规范！");
                        return null;}                 }
                if(b!=32&&b!=10) {
                    if((st.top()!=" "&&st.top()!=null)){
                        st.push(st.pop()+(""+(b-48)));
                    }
                    else if(st.top()==null||st.top()==" "){
                        st.push(""+(b-48));
                    }
                    b=fr.read();
                    if(!(b==10||b==-1||b=='\t'||b==13||b==32||(b>=48&&b<=57))) {
                        System.out.println("您的输入不规范！");
                        return null;}          }
          }
            if(st.N!=0){
                n++;}
            if(m!=st.N&&st.N!=0) {
                System.out.println("每行个数不相等");
                return null;}
           i=(m-1)/2+1;
            while(!st.isempty()) {
                if(st.top()!=" "&&st.top()!=null) {
                    square[n - 1][i - 1] = Integer.parseInt(st.pop());
                    i--;
                }
                else
                    st.pop();
            }
        b=fr.read();
            if(!(b==10||b==-1||b=='\t'||b==13||b==32||(b>=48&&b<=57))) {
                System.out.println("您的输入不规范！");
                return null;}    }
           if(n!=(m-1)/2+1){
            System.out.println("行数和列数不匹配");
            return null;}
        fr.close();
        return square;

}
    public static int[][] generateMagicSquare(int n) {
        int magic[][] = new int[n][n];
        int row = 0, col = n / 2, i, j, square = n * n;
        for (i = 1; i <= square; i++) {
            magic[row][col] = i;
            if (i % n == 0)
                row++;
            else {
                if (row == 0)
                    row = n - 1;
                else
                    row--;
                if (col == (n - 1))
                    col = 0;
                else
                    col++;
            } }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(magic[i][j] + "\t");
            System.out.println();
        }
        return magic;
    }
    public static void filewrite(int[][] square)throws Exception{
        FileOutputStream fos=new FileOutputStream("src/P1/txt/6.txt");
        for(int i=0;i<=square.length-1;i++){
            for(int j=0;j<=square.length-1;j++){
                fos.write((""+square[i][j]).getBytes());
                fos.write(' ');
            }
            fos.write('\n');
        }
        fos.close();

    }
}

