package review.permcomb;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        Character[] array = {'a', 'b', 'c', 'd', 'e'};
        begin(array, 3);
    }

    public static void begin(Character[] array, int size) {
        List<Character> temp = new ArrayList<>();
        combination(array, 0, size, temp);
    }

    private static void combination(Character[] array, int index, int size, List<Character> temp) {
        if (size == temp.size()) {  // 判断组合是否结束，字母数足够
            for (Object c : temp.toArray()) {
                System.out.print(c + " ");
            }
            System.out.println();
            return;
        }

        if (index == array.length) {
            return;
        }

        temp.add(array[index]);
        combination(array, index + 1, size, temp);
        temp.remove(array[index]);
        combination(array, index + 1, size, temp);
    }
}
