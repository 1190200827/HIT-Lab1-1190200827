package DataStructure;

public class work3 {
    /*  统计Pi选手所战胜的人*/
    public static int[] win(int i,int[][] table){
        int[] result=new int[table[i].length];
        int n=0;
        for(int b=0;b<=table[i].length-1;b++){
            if(table[i][b]==1&&b!=i){
                result[n]=b;
                n++;
            }
        }
        int[]  target=new int[n];
        System.arraycopy(result,0,target,0,n);
        return target;
    }
    /* 判断九个数字是否相等*/
    public  static boolean isequal(int a,int b,int c,int d,int e,int f,int g,int h,int i){
        int[]  tool=new int[9];
        for(int j=0;j<=8;j++){
            tool[j]=0;
        }
        tool[a]++;
        tool[b]++;
        tool[c]++;
        tool[d]++;
        tool[e]++;
        tool[f]++;
        tool[g]++;
        tool[h]++;
        tool[i]++;
        for(int q=0;q<=8;q++){
            if(tool[q]==0){return false;}
        }
        return true;
    }
    public static void main(String[] args) {
        int[][]  table=new int[9][9];/*记录九个选手之间互相的胜负状况*/
        /*随机生成九个选手之间的胜负状况*/
        for(int i=0;i<=8;i++){
            for(int j=i;j<=8;j++){
                table[i][j]=(Math.random()>0.5?0:1);
            }
        }
        for(int i=0;i<=8;i++){
            for(int j=0;j<=i;j++){
                if(table[j][i]==0){table[i][j]=1;}
                if(table[j][i]==1){table[i][j]=0;}
            }
        }
        /*若P(i)战胜了P(j)则记table[i][j]=1,反之记为0，并将表打印出来*/
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                System.out.printf("%d ",table[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.println("-----------------------------------------------------");
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                if(i!=j){
                    if(table[i][j]==1){}
                }
            }
        }
        /*统计每个选手所战胜的对手*/
        int[][] man=new int[9][];
        man[0]=win(0,table);
        man[1]=win(1,table);
        man[2]=win(2,table);
        man[3]=win(3,table);
        man[4]=win(4,table);
        man[5]=win(5,table);
        man[6]=win(6,table);
        man[7]=win(7,table);
        man[8]=win(8,table);
        for(int k=0;k<=8;k++){
            /*P(k)站胜了P(man[k])*/
            for(int a=k;a<=man[k].length-1;a++){
                /*P(man[k])站胜了P(man[man[k][a]) 以此类推至循环体结束*/
                for(int b=0;b<=man[man[k][a]].length-1;b++){
                    for(int c=0;c<=man[man[man[k][a]][b]].length-1;c++){
                        for(int d=0;d<=man[man[man[man[k][a]][b]][c]].length-1;d++){
                            for(int e=0;e<=man[man[man[man[man[k][a]][b]][c]][d]].length-1;e++){
                                for(int f=0;f<=man[man[man[man[man[man[k][a]][b]][c]][d]][e]].length-1;f++){
                                    for(int g=0;g<=man[man[man[man[man[man[man[k][a]][b]][c]][d]][e]][f]].length-1;g++){
                                        for(int h=0;h<=man[man[man[man[man[man[man[man[k][a]][b]][c]][d]][e]][f]][g]].length-1;h++){
                                            /*经过上述循环后，显然满足前面的选手战胜了后边的选手，接下来只要判断九个选手中无重复即可求出一个满足条件的序列*/
                                            if(isequal(k,man[k][a],man[man[k][a]][b],man[man[man[k][a]][b]][c],man[man[man[man[k][a]][b]][c]][d],man[man[man[man[man[k][a]][b]][c]][d]][e],man[man[man[man[man[man[k][a]][b]][c]][d]][e]][f],man[man[man[man[man[man[man[k][a]][b]][c]][d]][e]][f]][g],man[man[man[man[man[man[man[man[k][a]][b]][c]][d]][e]][f]][g]][h])){
                                                System.out.printf("%d %d %d %d %d %d %d %d %d\n",k+1,man[k][a]+1,man[man[k][a]][b]+1,man[man[man[k][a]][b]][c]+1,man[man[man[man[k][a]][b]][c]][d]+1,man[man[man[man[man[k][a]][b]][c]][d]][e]+1,man[man[man[man[man[man[k][a]][b]][c]][d]][e]][f]+1,man[man[man[man[man[man[man[k][a]][b]][c]][d]][e]][f]][g]+1,man[man[man[man[man[man[man[man[k][a]][b]][c]][d]][e]][f]][g]][h]+1);
                                            }}}}}}}}}}}}

