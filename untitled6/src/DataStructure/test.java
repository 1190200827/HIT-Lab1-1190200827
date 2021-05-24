package DataStructure;

public class test {
    public static void main(String[] args) {
        bintree<String> dt=new bintree<>("521");
        bintree.node no= dt.root.right ;
        dt.insert("13");
        dt.insert("14");
        dt.insertleft(dt.root.right,"12");
        dt.insert("15");
        dt.insert("16");
        dt.insert("17");
        dt.insert("18");
        System.out.println(dt.root.item+"---"+dt.root.right.left.item+"---"+dt.root.left.item);
    }
}
