package CN.EDU.SEU;

import java.util.Scanner;

/**
 * Created by LCN on 2016/4/6.
 */
public class MicroSoftOj {

    private int result;
    private int heightN;
    private int minSize;

    public static int maxFontSize(int paragraphSize, int pageSize, int width, int height, int[] paragraph) {
        int maxSize = Math.min(width, height);
        int minSize = 1;
        int result = maxSize;
        int actualPageSize = 0;
        int remainHeightN = 0;
        boolean firstTime = true;
        while ((maxSize - minSize) > 1) {
            firstTime = false;
            int widthN = width / result;
            int heightN = height / result;
            int totalHeightN = 0;
            for (int i = 0; i < paragraphSize; i++) {
                int tempHeightN = paragraph[i] / widthN;
                if (paragraph[i] % widthN != 0) {
                    tempHeightN++;
                }
                totalHeightN += tempHeightN;
            }

            if (totalHeightN > heightN * pageSize) {
                maxSize = result;
                result = (minSize + maxSize) / 2;
                actualPageSize = 0;
                remainHeightN = 0;
            } else {
                minSize = result;
                result = (minSize + maxSize) / 2;
                actualPageSize = 0;
                remainHeightN = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNum = scanner.nextInt();
        while ((testCaseNum--) > 0) {
            int paragraphSize = scanner.nextInt();
            int pageSize = scanner.nextInt();
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            int[] para = new int[paragraphSize];
            for (int i = 0; i < paragraphSize; i++) {
                para[i] = scanner.nextInt();
            }

            System.out.println(maxFontSize(paragraphSize, pageSize, width, height, para));
        }
    }
}
