package string;

/**
 * 字符串去除空格的方法
 */

public class StringWithOutWightSpace {
//    str.trim(); //去掉首尾空格
//    str.replace(" ",""); //去除所有空格，包括首尾、中间
//    str.replaceAll(" ", ""); //去掉所有空格，包括首尾、中间
//    str.replaceAll(" +","");  //去掉所有空格，包括首尾、中间
//    str.replaceAll("\\s*", ""); //可以替换大部分空白字符， 不限于空格 ；

    public static void main(String[] args) {
        String str = "      hi      world  ~        ";
        //方法1：str.trim()
        System.out.println("1--->"+str.trim());
        //方法2：str.repalce(" ","")
        System.out.println("2--->"+str.replace(" ", ""));
        //方法3：str.repalceAll(" ","")
        System.out.println("3--->"+str.replaceAll(" ", ""));
        //方法4：str.repalceAll(" +","")
        System.out.println("4--->"+str.replaceAll(" +", ""));
        //方法5：str.repalceAll("\\s*","")
        System.out.println("4--->"+str.replaceAll("\\s*", ""));
    }

    public String remove(String resource, char ch)
    {
        StringBuffer buffer = new StringBuffer();
        int position = 0;
        char currentChar;

        for (int i = 0; i < resource.length(); i++)
        {
            currentChar = resource.charAt(i);
            if(currentChar != ch) {
                buffer.append(currentChar);
            }
        }
        return buffer.toString();
    }
}
