package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        List<String> methods = new ArrayList<String>();
        for (Method method : Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                methods.add("Method " + method.getName() + " returns a value of type "
                        + method.getReturnType().getSimpleName());
            }
        }
        System.out.println(methods);
        // END
    }
}
