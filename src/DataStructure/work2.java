package DataStructure;

public class work2 {
    public static void main(String[] args) {
        int[] random =new int[100];
        int[] maxplace =new int[100];
        for(int i=0;i<=99;i++){
            random[i]=(int)(Math.random()*200);
        }
        for(int i=0;i<=99;i++){
            System.out.printf("%d ",random[i]);
        }
        System.out.printf("\n");
        System.out.println("-----------------------------");
        int max=random[0];
        int j=0;
        for(int i=0;i<=99;i++){
            if(random[i]>max){
                for(int a=0;a<=99;a++){maxplace[a]=-1;}
                max=random[i];
                j=0;
            }
            if(random[i]==max){
                maxplace[j]=i;
             j++;
            }
        }
        for(int i=0;i<=99;i++){
            if(maxplace[i]!=-1){
                System.out.println(maxplace[i]+1);
            }
        }
    }
}
