/**
 * Author:Eric
 * DATE:2022/12/4-17:17
 * Decription: 将字符串转为ascii码
 */
public class AsciiCode {
    public static void main(String[] args) {
        char c[] ="lies".toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println((c[i])+":"+(int)c[i]);
            /**
             * l:108
             * i:105
             * e:101
             * s:115
             */
        }
        //9
        System.out.println(429%10);
    }
}
