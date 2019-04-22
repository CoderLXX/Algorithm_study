import java.util.Stack;

public class DecodeString {



    static public String ExtractCompressedString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();

        int idx = 0;
        int curNum = 0;
        while (idx < s.length())

        {
            char ch = s.charAt(idx);
            if (Character.isDigit(ch)) {
                // 计算数字大小
                while (Character.isDigit(s.charAt(idx)))
                    curNum = 10 * curNum
                            + (s.charAt(idx++) - '0');
            } else if (ch == '{') {
                resStack.push(res);
                res = "";
                countStack.push(curNum);
                curNum = 0;
                idx++;
            } else if (ch == '}') {
                // 解压字符串过程
                StringBuilder temp =
                        new StringBuilder(resStack.pop());

                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;

            } else {
                //计算花括号内字符串
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = ExtractCompressedString("3{a2{hhc}}iijh2{asd}");
        System.out.println(str);
    }

}
