package review.classhandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) {
        // Java反射
        try {
            Method sin = Math.class.getDeclaredMethod("sin", Double.TYPE);
            Double sin1 = (Double) sin.invoke(null, new Integer(1));
            System.out.println(sin1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
