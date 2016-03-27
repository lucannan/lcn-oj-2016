package CN.EDU.SEU.JVM;

/**
 * Created by LCN on 2016/3/18.
 */
public class RuntimeConstantPool {

    public static void main(String[] args) {
        String s0= "kvill";
        String s1=new String("kvill");
        String s2=new String("kvill");
        System.out.println( s0==s1 );
        System.out.println( "++++++++++++++++++++" );
        s1.intern();
        s2=s2.intern(); //把常量池中“kvill”的引用赋给s2
        System.out.println( s0==s1);
        System.out.println( s0==s1.intern() );
        System.out.println( s0==s2 );
    }
}
