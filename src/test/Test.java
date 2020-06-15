package test;

import com.sun.xml.internal.bind.api.impl.NameConverter;

import sun.nio.cs.StandardCharsets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述
 *
 * @author l00365373
 * @since 2020-04-16
 */
class Test {
    public static void main(String[] args) {

        List<String> result = Arrays.asList("informix", "greenplum", "mongodb", "gbase", "aster", "vertica",
            "vectorwise", "uda", "sybaseiq", "oracle", "pt", "gaussdb100v1r3", "gaussdb200", "gaussdb100v3r1",
            "teradatadb", "db2", "mysql");

        System.out.println(result.equals("mongodb"));


        // Integer a1 = 100;
        // Integer a2 = 100;
        // Integer a3 = 150;
        // Integer a4 = 150;
        // System.out.println(a1 == a2);
        // System.out.println(a3 == a4);
        // System.out.println(a3 == 150);

        // try {
        //     FileOutputStream outputStream = new FileOutputStream("test.txt", true);
        //     outputStream.write("ABCDE".getBytes());
        //     outputStream.close();
        // } catch (IOException e) {
        //
        // }

        // int ret = func(2);
        // System.out.println(ret);

        // int count = 0;
        // for (int i = 0; i < 100; i++) {
        //     count = count++;
        // }
        // System.out.println(count);

        // try {
        //     System.out.println("aa:" + func());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // String[] arr = new String[]{"1","2","3","4","5"};
        // List<String> list = Arrays.asList(arr);
        // list.remove("5");
        // list.add("6");

        // Map<String,String> map = new HashMap<>();
        // map.put("1","a");
        // map.put("2","b");
        // List<String> list = new ArrayList<>();
        // list.addAll(map.values());
        // list.addAll(Collections.singleton("c"));

        // List<String> list = Collections.emptyList();
        // list.add("1");

        // char alpha = 'B';
        // int foo = 65;
        // boolean trueExp = true;
        // // System.out.println(trueExp ? alpha : 0);
        // System.out.println(trueExp ? alpha : "foo");
    }

    public static int func() throws Exception {
        int elm = 1;
        for (int i = 1; i < 2; i++) {
            try{
                throw new Exception("bb");
            } catch (Exception ex) {
                throw ex;
            } finally {
                continue;
            }
        }
        return 0;
    }

    // private static int func(int n) {
    //     int[] number = {1, 2, 3, 4};
    //     try {
    //         int ret = number[n] * 2;
    //         return ret;
    //     } catch (Exception e) {
    //         return n * 3;
    //     } finally {
    //         if (n == 2) {
    //             return 0;
    //         }
    //     }
    // }
}
