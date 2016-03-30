package CN.EDU.SEU;

/**
 * Created by LCN on 2016/3/22.
 */
public class App {

    @org.junit.Test
    public void test() {
        String[] totalTypeArr = {"IQC", "Test-xx","Test-232"};
        for (int i = 0; i < totalTypeArr.length; i++) {
            totalTypeArr[i] = totalTypeArr[i].replace("-", "_");
            System.out.println(totalTypeArr[i]);
        }
        boolean isReplaced = false;
        for (int i = 0; i < totalTypeArr.length; i++) {
            if (!isReplaced) {
                if (totalTypeArr[i].matches("Test_.+")) {
                    totalTypeArr[i] = "Test_TEST";
                    isReplaced = true;
                }
            }

            System.out.println(totalTypeArr[i]);
        }

    }
}

abstract class Test {
    abstract void test();
}