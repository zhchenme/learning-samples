package con.zhchen.generic;

import com.zhchen.generic.GenericFactory;
import com.zhchen.generic.GenericMethodSamples;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/25
 */
public class GenericTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        genericClassSamples();
        genericMethodSamples();
    }

    private static void genericMethodSamples() throws InstantiationException, IllegalAccessException {
        User user = GenericMethodSamples.createInstance(User.class);
        System.out.println(user.name);
        System.out.println(GenericMethodSamples.add(10, 10.0));
    }

    private static void genericClassSamples() throws InstantiationException, IllegalAccessException {
        GenericFactory<User> gf = new GenericFactory<User>(User.class);
        System.out.println(gf.createInstance().name);
    }

    public static class User {
        public String name = "zhchen";
    }
}
