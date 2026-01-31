package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void inspectClass(Class<?> clazz) {
        System.out.println("=== Reflection: Class Info ===");
        System.out.println("Class Name: " + clazz.getSimpleName());

        System.out.println("-- Fields --");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("  " + field.getName() + " (" + field.getType().getSimpleName() + ")");
        }

        System.out.println("-- Methods --");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("  " + method.getName());
        }
        System.out.println("==============================");
    }
}
