package CN.EDU.SEU.TengXun2;

/**
 * Created by LCN on 2016/4/3.
 */
public  class Powerset {
    public static int line = 0;
    public static void print(String s){
        if(s.length()>line){
            System.out.format("%n%s",s);
            line++;
        }
        else {
            System.out.format(",%s",s);
        }
    }
    public static void subselect(String s,String text,int i,int k){
        if(k==0){
            print(s);
        }else{
            char c = text.charAt(i);

            i++;
            if(i>=text.length()){
                if(k==0)print(s);
                else if(k==1)print(s+c);
            }else{
                subselect(s+c,text,i,k-1);
                subselect(s,text,i,k);
            }
        }
    }

    public static void solve(String text){
        char c = text.charAt(0);
        for(int k=0;k<text.length()-1;k++){
            subselect(c+"",text,1,k);
            subselect("",text,1,k+1);
        }
    }
    public static void main(String[] args) {
        Powerset.solve("abc");
    }

}
