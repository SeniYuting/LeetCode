package qiuzhao.wangyi;

// 100%
// 迷宫，非算法

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] wAh = sc.nextLine().split(" ");
            int w = Integer.parseInt(wAh[0]);
            int h = Integer.parseInt(wAh[1]);
            char[][] m = new char[h][w];
            int startI = 0;
            int startJ = 0;
            char dir = ' ';
            for (int j = 0; j < h; j++) {
                m[j] = sc.nextLine().toCharArray();
                for (int k = 0; k < w; k++) {
                    if (m[j][k] == 'S') {
                        startI = j;
                        startJ = k;

                        if (j == 0) {
                            dir = 'd';
                        } else if (j == h - 1) {
                            dir = 'u';
                        } else if (k == 0) {
                            dir = 'r';
                        } else if (k == w - 1) {
                            dir = 'l';
                        } else {
                            System.out.println("error input!");
                            return;
                        }
                    }
                }
            }

            System.out.println(leftHandCount(m, startI, startJ, dir));
        }

    }

    private static long leftHandCount(char[][] m, int startI, int startJ, char dir) {
        int i = startI;
        int j = startJ;
        long count = 1;

        while (m[i][j] != 'E') {
            count++;
            switch (dir) {
                case 'd':
                    i++;
                    if (faceDeadEnd(m, i, j, dir)) {
                        dir = 'u';
                    } else if (m[i][j + 1] == '.' || m[i][j + 1] == 'E') {
                        dir = 'r';
                    } else if (m[i + 1][j] == '.' || m[i + 1][j] == 'E') {
                        dir = 'd';
                    } else if (m[i][j - 1] == '.' || m[i][j - 1] == 'E') {
                        dir = 'l';
                    }
                    break;
                case 'u':
                    i--;
                    if (faceDeadEnd(m, i, j, dir)) {
                        dir = 'd';
                    } else if (m[i][j - 1] == '.' || m[i][j - 1] == 'E') {
                        dir = 'l';
                    } else if (m[i - 1][j] == '.' || m[i - 1][j] == 'E') {
                        dir = 'u';
                    } else if (m[i][j + 1] == '.' || m[i][j + 1] == 'E') {
                        dir = 'r';
                    }
                    break;
                case 'r':
                    j++;
                    if (faceDeadEnd(m, i, j, dir)) {
                        dir = 'l';
                    } else if (m[i - 1][j] == '.' || m[i - 1][j] == 'E') {
                        dir = 'u';
                    } else if (m[i][j + 1] == '.' || m[i][j + 1] == 'E') {
                        dir = 'r';
                    } else if (m[i + 1][j] == '.' || m[i + 1][j] == 'E') {
                        dir = 'd';
                    }
                    break;
                case 'l':
                    j--;
                    if (faceDeadEnd(m, i, j, dir)) {
                        dir = 'r';
                    } else if (m[i + 1][j] == '.' || m[i + 1][j] == 'E') {
                        dir = 'd';
                    } else if (m[i][j - 1] == '.' || m[i][j - 1] == 'E') {
                        dir = 'l';
                    } else if (m[i - 1][j] == '.' || m[i - 1][j] == 'E') {
                        dir = 'u';
                    }
                    break;
            }
        }

        return count;
    }

    private static boolean faceDeadEnd(char[][] m, int i, int j, char dir) {
        if (m[i][j] == 'E') {
            return true;
        }
        switch (dir) {
            case 'd':
                return m[i + 1][j] == '#' && m[i][j + 1] == '#' && m[i][j - 1] == '#';
            case 'u':
                return m[i - 1][j] == '#' && m[i][j + 1] == '#' && m[i][j - 1] == '#';
            case 'r':
                return m[i - 1][j] == '#' && m[i + 1][j] == '#' && m[i][j + 1] == '#';
            case 'l':
                return m[i - 1][j] == '#' && m[i + 1][j] == '#' && m[i][j - 1] == '#';
            default:
                return false;
        }
    }
}
