package solution.面试题;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/7/4
 **/
public class Solution {
    /**
     * 判断是否是大小端字节序 -》 [0, 0, 0, 127]
     * 低位放于内存地址高位 -》 JVM 是大端字节序
     *
     * @return
     * @throws IOException
     */
    public boolean isBigEndian() throws IOException {
        int a = 0x01020304;
        ByteOutputStream byteOutputStream = new ByteOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteOutputStream);
        dataOutputStream.writeInt(a);
        byte[] b = byteOutputStream.toByteArray();
        System.out.println(Arrays.toString(b));
        return true;
    }

    /**
     * 单词翻转
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }
        String[] words = s.split(" ");
        Deque<String> stack = new ArrayDeque<>();
        for (String word : words) {
            if ("".equals(word)) {
                continue;
            }
            stack.push(word);
        }
        StringBuilder sb = new StringBuilder();
        for (; !stack.isEmpty(); ) {
            String word = stack.pop();
            sb.append(word).append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.reverseWords("a good   example");
    }
}
