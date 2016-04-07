package microsoft;



import java.util.Scanner;

/**
 * Created by LCN on 2016/4/6.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNumber = scanner.nextInt();
        while ((testCaseNumber--) > 0) {
            int N = scanner.nextInt();
            int P = scanner.nextInt();
            int W = scanner.nextInt();
            int H = scanner.nextInt();

            int[] paragraphs = new int[N];
            for (int i = 0; i < N; i++) {
                paragraphs[i] = scanner.nextInt();
            }
            System.out.println(maxFontSize(N, P, W, H, paragraphs));
        }
    }


    public static int maxFontSize(int number, int pages, int width, int height, int[] paragraphs) {
        int s = Math.min(width, height);
        int olds = s;
        int widthN = width / s;
        int heightN = height / s;
        int actualPage = 0;
        boolean state = false;
        int lastHeighNumber = 0;
        for (int i = 0; i < number; i++) {
            int heightNumberNeed = paragraphs[i] / widthN;

            if (heightNumberNeed * widthN < paragraphs[i]) {
                heightNumberNeed++;
            }

            heightNumberNeed = heightNumberNeed + lastHeighNumber;

            if (heightNumberNeed >= heightN) {
                actualPage++;
                lastHeighNumber = heightNumberNeed - heightN;
                state = true;
            } else {
                lastHeighNumber = heightNumberNeed;
                state = false;
            }

            if (pages < actualPage) {
                i = -1; //重新开始循环
                olds = s;
                s = s / 2;
                widthN = width / s;
                heightN = height / s;
                actualPage = 0;
                lastHeighNumber = 0;
                continue;
            }

            if (i == (number - 1)) { //最后一个了
                if (state == false) {
                    if (lastHeighNumber != 0) {
                        int temp = lastHeighNumber / heightN;
                        if (temp * heightN < lastHeighNumber) {
                            temp++;
                        }
                        if (temp + actualPage > pages) {
                            i = -1;
                            olds = s;
                            s = s / 2;
                            widthN = width / s;
                            heightN = height / s;
                            actualPage = 0;
                            lastHeighNumber = 0;
                            continue;
                        }
                    }
                }

                if (lastHeighNumber != 0) {
                    int temp = lastHeighNumber / heightN;
                    if (temp * heightN < lastHeighNumber) {
                        temp++;
                    }
                    if (temp + actualPage > pages) {
                        i = -1;
                        olds = s;
                        s = s / 2;
                        widthN = width / s;
                        heightN = height / s;
                        actualPage = 0;
                        lastHeighNumber = 0;
                        continue;
                    } else {
                        return s;
                    }
                } else {
                    if ((olds - s) / 2 == 0) {
                        return s;
                    } else {
                        i = -1;
                        s = s + (olds - s) / 2;
                        widthN = width / s;
                        heightN = height / s;
                        actualPage = 0;
                        lastHeighNumber = 0;
                        continue;
                    }
                }
            }

        }
        return 0;
    }
}
