package solution.tencent;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/22
 **/
public class Test {
    public static void main(String[] args) {
        foo();
    }

    public static int foo() {
        int c = 0;
        try {

        } finally {
            System.out.println(c);
        }
        return ++c;
    }
}
