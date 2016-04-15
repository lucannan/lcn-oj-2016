package CN.EDU.SEU.大话数据结构.图;

/**
 * Created by LCN on 2016/4/15.
 */
public class Edge implements Comparable{
    public int i,j,w;
    public Edge(int i,int j,int w){
        this.i=i;
        this.j=j;
        this.w=w;
    }


    @Override
    public int compareTo(Object o) {
        Edge to=(Edge)o;
        if(this.w>to.w) return 1;
        else if(this.w==to.w) return 0;
        else return -1;

    }
    @Override
    public String toString() {
        return "start="+i+"||end="+j+"||w="+w;
    }
}
