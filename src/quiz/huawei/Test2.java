package quiz.huawei;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ip = sc.nextLine().toUpperCase();
        String[] ipStr = ip.split(":");
        if (ipStr.length != 8 || !isOkIP(ipStr)) {
            System.out.println("Error");
            return;
        }

        switch (ipStr[0].substring(0, 2)) {
            case "FF":  // 组播地址
                System.out.println("Multicast");
                break;

            case "FE": // 链路本地地址 or 站点本地地址

                int temp = 0;
                int c2 = ipStr[0].charAt(2);

                if (c2 - 'A' >= 0 && c2 - 'A' <= 5) {
                    temp = c2 - 'A' + 10;
                } else if (c2 - '0' >= 0 && c2 - '0' <= 9) {
                    temp = c2 - '0';
                }

                if ((temp & 12) == 8) {  // 1000 - 1011 8-A
                    System.out.println("LinkLocal");

                } else if ((temp & 12) == 12) {  // 1100 - 1111 C-F
                    System.out.println("SiteLocal");
                }
                break;

            default:
                for (int i = 0; i <= 6; i++) {
                    if (!ipStr[i].equals("0000")) {
                        System.out.println("GlobalUnicast");  // 全球单播地址
                        return;
                    }
                }
                if (ipStr[7].equals("0000")) {
                    System.out.println("Unspecified");  // 未指定地址 0...0
                } else if (ipStr[7].equals("0001")) {
                    System.out.println("Loopback");  // 环回地址 0...1
                } else {
                    System.out.println("GlobalUnicast");  // 全球单播地址
                }
        }
    }

    public static boolean isOkIP(String[] ipStr) {
        boolean result = true;
        for (int i = 0; i < 8; i++) {
            if (ipStr[i].length() != 4) {
                result = false;
            }
            for (int j = 0; j < 4; j++) {
                boolean ok = (ipStr[i].charAt(j) - 'A' >= 0 && ipStr[i].charAt(j) - 'A' <= 5) || (ipStr[i].charAt(j) - '0' >= 0 && ipStr[i].charAt(j) - '0' <= 9);
                if (!ok) {
                    result = false;
                }
            }
        }
        return result;
    }
}
