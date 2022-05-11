package com.example.java_practise.统计代码量工具;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CodeLines {
    public static void main(String[] args) {
        String root = "D:\\java\\ideaProjects\\dynamic_validate";
        CodeLines o = new CodeLines();
        o.printCodeLines(root);
    }

    public void printCodeLines(String filePath) {

        String type1 = "(.*\\.java$)";
        String type2 = "(.*\\.jsp$)";
        String type3 = "(.*\\.html$)";
        String type4 = "(.*\\.js$)";
        String type5 = "(.*\\.css$)";
        //String type6 = "(.*)"; // 全部文件数

        //File root = new File(filePath);
        //List<String> filePaths = new ArrayList<String>();
        //int sumFiles = listAll(root, filePaths, type6).size();

        int[] r1 = readByType(filePath, type1);
        int[] r2 = readByType(filePath, type2);
        int[] r3 = readByType(filePath, type3);
        int[] r4 = readByType(filePath, type4);
        int[] r5 = readByType(filePath, type5);
        int[] sums = new int[4];
        for (int j = 0; j < 4; j++) {
            sums[j] = r1[j] + r2[j] + r3[j] + r4[j] + r5[j];
        }

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("  %-20s%-10s%-10s%-10s%-10s%-10s%14s\n", "Language", "files", "sumLines", "blank", "comment", "code", "code/sumLines");
        System.out.println("----------------------------------------------------------------------------------------");
        int s = r1[4] + r2[4] + r3[4] + r4[4] + r5[4];

        System.out.printf("  %-20s%-10d%-10d%-10d%-10d%-10d%6.2f%%\n", "JAVA", r1[0], r1[4], r1[1], r1[2], r1[3], r1[3] * 100.0 / r1[4]);
        System.out.printf("  %-20s%-10d%-10d%-10d%-10d%-10d%6.2f%%\n", "JSP", r2[0], r2[4], r2[1], r2[2], r2[3], r2[3] * 100.0 / r2[4]);
        System.out.printf("  %-20s%-10d%-10d%-10d%-10d%-10d%6.2f%%\n", "HTML", r3[0], r3[4], r3[1], r3[2], r3[3], r3[3] * 100.0 / r3[4]);
        System.out.printf("  %-20s%-10d%-10d%-10d%-10d%-10d%6.2f%%\n", "JS", r4[0], r4[4], r4[1], r4[2], r4[3], r4[3] * 100.0 / r4[4]);
        System.out.printf("  %-20s%-10d%-10d%-10d%-10d%-10d%6.2f%%\n", "CSS", r5[0], r5[4], r5[1], r5[2], r5[3], r5[3] * 100.0 / r5[4]);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("  %-20s%-10d%-10d%-10d%-10d%-10d%6.2f%%\n", "SUM", sums[0], s, sums[1], sums[2], sums[3], sums[3] * 100.0 / s);
        System.out.println("----------------------------------------------------------------------------------------");

    }

    private int[] readByType(String filePath, String type) {
        File root = new File(filePath);
        List<String> filePaths = new ArrayList<String>();
        filePaths = listAll(root, filePaths, type);
        int codeLine = 0;
        int commentLine = 0;
        int blankLine = 0;
        for (String fp : filePaths) {
            int[] re = readOneFile(fp);
            System.out.println("当前文件" + fp);
            System.out.println("代码行数：" + re[0]);
            System.out.println("注释行数：" + re[1]);
            System.out.println("空行数：" + re[2]);
            codeLine += re[0];
            commentLine += re[1];
            blankLine += re[2];
        }
        int files = filePaths.size();
        int sum = codeLine + commentLine + blankLine;
        int[] re = {files, blankLine, commentLine, codeLine, sum};
        return re;
    }

    public int[] readOneFile(String filePath) {
        try {
            String encoding = "UTF-8";

            File file = new File(filePath);
            int codeLine = 0;
            int commentLine = 0;
            int blankLine = 0;

            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);

                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    lineTxt = lineTxt.trim();
                    if (lineTxt.equals("")) {
                        blankLine++;
                    } else if (lineTxt.matches("(^\\s*/{2}.*)|(^\\s*/?\\*.*)")) { // 匹配 1 以任意空格+//或/或*开头的行，就是/**/和//注释 2 以*/结尾的
                        if (lineTxt.matches("(^\\s*/\\*.*)") && !lineTxt.matches("(.*\\*/\\s*$)")) { // 以/*开头 却不以*/结尾。
                            while ((lineTxt = bufferedReader.readLine()) != null) {
                                commentLine++;
                                if (lineTxt.matches("(.*\\*/\\s*$)")) { // 以*/结束
                                    commentLine++;
                                    break;
                                }
                            }
                        }
                    } else {
                        codeLine++;
                    }
                }
                read.close();

                int[] re = {codeLine, commentLine, blankLine};
                return re;
            } else {
                System.out.println("找不到指定的文件");
                return null;
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
            return null;
        }
    }


    private List<String> listAll(File root, List<String> filePaths, String reg) {
        if (root.exists()) {
            File[] files = root.listFiles();
            if (files != null && files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].exists() && files[i].isDirectory()) {
                        listAll(files[i], filePaths, reg);
                    } else {
                        String path = files[i].getAbsolutePath();
                        if (path.matches(reg)) {
                            filePaths.add(path);
                        }
                    }
                }
            }
        }
        return filePaths;
    }
}