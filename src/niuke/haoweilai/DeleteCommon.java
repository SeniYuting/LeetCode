package niuke.haoweilai;

// 测试用例不通过，也许是没有写成nextLine
import java.util.Scanner;

public class DeleteCommon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

//        String s = in.nextLine();
//        String s1 = s.split("\\.")[0].trim();
//        String s2 = s.split("\\.")[1].trim();

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            s1 = s1.replaceAll(c + "", "");
        }

        System.out.println(s1);
    }
}
