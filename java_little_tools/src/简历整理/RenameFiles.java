package 简历整理;

import java.io.File;
import java.util.List;

public class RenameFiles {

    public static void main(String[] args) {
        //String exp = "propertys:module,methods:llseek,read,write,open";
        String exp = "propertys:module";
        String[] strs = exp.split("propertys:|,methods:");
        for (int i = 0; i < strs.length; i++) {
            System.out.println("====" + strs[i] + "====");
        }

    }

    public static List<File> getFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();

        }
        return null;
    }
}
