package CN.EDU.SEU.文件操作;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by LCN on 2016/3/20.
 */
public class FileUtils {
    /**
     * @param filePath 指定的文件路径
     * @param isNew    true：新建、false：不新建
     * @return 存在返回TRUE，不存在返回FALSE
     * @desc:判断指定路径是否存在，如果不存在，根据参数决定是否新建
     */
    public static boolean isExist(String filePath, boolean isNew) {
        File file = new File(filePath);
        if (!file.exists() && isNew) {
            return file.mkdirs();                //新建文件路径
        }
        return false;
    }

    /**
     * 关闭输入流
     * @param in 输入流
     */
    public static void close(InputStream in) {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
        }
    }


    /**
     * 关闭输出流
     *
     * @param out 输出流
     */
    public static void close(OutputStream out) {
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
        }
    }

    /**
     * 从输入流中读取字符串，使用默认字符集
     *
     * @param in 输入流
     * @return 流内容的字符串
     */
    public static String readString(InputStream in) {
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            return new String(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Could not read stream", e);
        } finally {
            close(in);
            close(out);
        }
    }


    /**
     * 取得文件的后缀名。
     *
     * @param fileName 文件名
     * @return 后缀名
     */
    public static String getExtension(String fileName) {
        //验证文件是否存在
//        if (Validators.isEmpty(fileName)) {
//            return null;
//        }

        int pointIndex = fileName.lastIndexOf(".");
        return pointIndex > 0 && pointIndex < fileName.length() ? fileName.substring(pointIndex + 1).toLowerCase()
                : null;
    }


    /**
     * 复制给定的数组中的内容到输出流中。
     *
     * @param in  需要复制的数组
     * @param out 复制到的输出流
     * @throws IOException 当发生 I/O 异常时抛出
     */
    public static void copy(byte[] in, OutputStream out) throws IOException {
        try {
            out.write(in);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
            }
        }
    }


    //取程序运行时的目录路径不加"/"
    public String getClassPath() throws URISyntaxException {
        String path = "";
        path = new File(this.getClass().getClassLoader().getResource("").toURI()).getPath();
        return path;
    }


    public static void main(String[] args) throws Exception {
        String path = new FileUtils().getClassPath();
        System.out.println(path);

        //获取当前类的所在工程路径
        File f = new File(new FileUtils().getClass().getResource("/").getPath());
        System.out.println(f);

        //获取当前类的绝对路径
        File f1 = new File(new FileUtils().getClass().getResource("").getPath());
        System.out.println(URLDecoder.decode(f1.toString(),"UTF-8"));

        //获取当前类的所在工程路径
        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);

        //只会在classes的根目录下进行查找
        URL xmlpath = new FileUtils().getClass().getClassLoader().getResource("test.txt");
        System.out.println(xmlpath);

        //获取当前工程路径
        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("java.class.path"));

    }
}
