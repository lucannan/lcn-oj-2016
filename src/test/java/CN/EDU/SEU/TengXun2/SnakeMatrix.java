package CN.EDU.SEU.TengXun2;

public class SnakeMatrix {
    private int[][] data;
    //二维数组的维数
    private int index;
    private int direct;
    public static void main(String[]args){
        SnakeMatrix s = new SnakeMatrix(10);
        s.print();
    }
    public SnakeMatrix(int i){
        if(i<1){
            System.out.println("参数错误");
            System.exit(0);
        }
        index = i;
        data = new int[i][i];
        for(int j=0;j<i;j++){
            for(int k=0;k<i;k++){
                data[j][k] = 0;
            }
        }
        direct = 0;
        //manageData();
        manageDataByMath();

    }
    /**
     * 直接根据二维数组的x,y值来计算这个位置的元素值
     * 一圈为一层，从外到内分别为１，２，３...层
     * 首先得到这个位置元素的层数
     * 然后计算这层左上角元素的值
     * 再计算出这个位置(x,y)相对于左上角元素的偏移量
     * 二者相加，就是这个位置的元素值
     */
    public void manageDataByMath(){
        for(int i=0;i<index;i++){
            for(int j=0;j<index;j++){
                data[i][j] = getDataByPosition(i,j);
            }
        }

    }
    /**
     * 数组被分为四个部分，
     * 只看左上部分，
     * (x,y)位置x,y的较小值就标明了这个位置的层数
     * 其他三个部分与左上部分是对称的
     * 映射一下关系就行了
     * @param i
     * @param j
     * @return
     */
    public int getLevByPosition(int i,int j){
        int mid = (int)index/2;
        int tempi,tempj;
        if((i+1)>mid){
            tempi = index-i-1;
        }else{
            tempi = i;
        }
        if((j+1)>mid){
            tempj = index-j-1;
        }else{
            tempj = j;
        }
        if(tempi<tempj) return tempi+1;
        return tempj+1;
    }
    /**
     * 计算本层左上角的元素值
     * @param i
     * @param j
     * @return
     */
    public int getDataByPosition(int i,int j){
        int lev = getLevByPosition(i,j);
        //每一层左上角第一个元素的值
        int startIndex = 0;
        //计算这个值
        for(int temp=1;temp<lev;temp++){
            startIndex +=((index-2*temp)*4+4);
        }
        return startIndex+getAdd(i,j,lev)+1;
    }
    /**
     * 得到偏移量
     * @param i
     * @param j
     * @param lev
     * @return
     */
    public int getAdd(int i,int j,int lev){
        int add = 0;
        //每一层的边长
        int levEdge = index-2*(lev-1);

        if(i+1 == (index-(lev-1))){
            //这一层的倒数第一行
            add = 2*levEdge-1+(index-lev-1-j);
        }else if(i+1 == lev){
            //这一层的第一行
            add = j-lev+1;
        }else{//中间行
            if(j>((int)index/2)){
                add = levEdge + i-lev;
            }else{
                add = levEdge + levEdge-2 +levEdge+(index-lev-i-1);
            }
        }
        return add;
    }
    private void changeDirect(){
        direct = (direct+1)%4;
    }
    //根据前进方向(direct)判断前方的二维数组元素是否没有赋值
    private boolean check(int j,int k){
        if(direct ==0){
            if((k+1)==index){
                return false;
            }else if(data[j][k+1]!=0){
                return false;
            }
        }else if(direct == 1){
            if((j+1)==index){
                return false;
            }else if(data[j+1][k]!=0){
                return false;
            }
        }else if(direct == 2){
            if(k==0){
                return false;
            }else if(data[j][k-1]!=0){
                return false;
            }
        }else{
            if(j==0){
                return false;
            }else if(data[j-1][k]!=0){
                return false;
            }
        }
        return true;
    }
    /**
     * 直接根据蛇形的前进方向一个一个置二维数组的值
     */
    public void manageData(){
        int j = 0;
        int k = 0;
        data[j][k] = 1;
        for(int i=2;i<index*index+1;i++){
            //判断能否合法赋值
            while(!check(j,k)){
                changeDirect();
            }
            if(direct == 0){
                k++;
            }else if(direct == 1){
                j++;
            }else if(direct == 2){
                k--;
            }else{
                j--;
            }
            data[j][k] = i;
        }

    }
    //仅供参考，数据大了会连在一起
    public void print(){
        for(int i = 0;i<index;i++){
            for(int j = 0;j<index;j++){
                if(data[i][j]<10){
                    System.out.print("   "+data[i][j]);
                }else if(data[i][j]>99){
                    System.out.print(" "+data[i][j]);
                }
                else{
                    System.out.print("  "+data[i][j]);
                }
            }
            System.out.println();
        }
    }

}
