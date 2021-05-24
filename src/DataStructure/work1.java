package DataStructure;
import way.*;
public class work1 {
    public static String translate(String str){
        char[] strcopy=new char[str.length()];
        for (int i = 0;i < str.length(); i++) {
          if('0'<=str.charAt(i)&&str.charAt(i)<='9'){
              strcopy[i]=(char)(str.charAt(i)+'Z'-'0'+1);
          }
          else{
              strcopy[i]=str.charAt(i);
          }
        }
        return new String(strcopy);
    }
    public static String re(String str){
        char[] strcopy=new char[str.length()];
        for (int i = 0;i < str.length(); i++) {
            if(('Z'+1)<=str.charAt(i)&&str.charAt(i)<=('Z'+10)){
                strcopy[i]=(char)(str.charAt(i)-'Z'+'0'-1);
            }
            else{
                strcopy[i]=str.charAt(i);
            }
        }
        return new String(strcopy);
    }
    public static void main(String[] args) {
        /*字符数组存储字符串*/
        String[] str={"PAB","5C","PABC","CXY","CRSI","7","B899","B9"};
        String[] patternstr=new String[str.length];
        for(int i=0;i<=str.length-1;i++){
            patternstr[i]=translate(str[i]);
        }
       quick<String> quick=new quick<>();
       quick.quickpx(patternstr,0,patternstr.length-1);
        for(int i=0;i<=str.length-1;i++){
            patternstr[i]=re(patternstr[i]);
        }
        for(int i=0;i<= patternstr.length-1;i++) {
            System.out.println(patternstr[i]);
        }

    }}
