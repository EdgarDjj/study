package dynamic_program;

import org.junit.Test;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/2/22
 **/
public class MinDistanceTest {

    @Test
    public void test() {
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("absdsa", "dsadf"));
        System.out.println(minDistance.minDistanceResult("absdsa", "dsadf"));
    }
}