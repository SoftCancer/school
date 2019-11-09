package com.dol.school.common.utils;

import com.dol.school.entity.Student;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * @description:
 * @author: YaoGuangXun
 * @date: 2019/9/14 10:26
 */
public class Test {

    public static void main(String[] args) {
        Student student = new Student("1", "yao");
        Student student1 = new Student("1", "yao");

        System.out.println(student == student1);

        // 用equals 比较两个实例，必须在实例中重写equals 方法,才比较值是否相等，否则比较两个引用是否相等。
        System.out.println(student.equals(student1));

        System.out.println("--------------------------");
        String s1 = "1234";
        String s2 = "1234";
        String s3 = new String("1234");
        String s4 = new String("1234");

        System.out.println(s1 == s2);  // 引用类型比较引用地址： true
        System.out.println(s1 == s3);   // false
        System.out.println(s3 == s4);   // false
        System.out.println(s3.equals(s4)); // true

       BigInteger re = getNFaction(5);
        System.out.println(re);

        HashMap map = new HashMap();
        map.put("","");

        test();
    }

    public static BigInteger getNFaction(int n) {

       BigInteger result = new BigInteger("1");
        if (n == 0 || n == 1) {
            return result;
        }

        for (int i=1 ;i<=n; i++){
            BigInteger num = new BigInteger(String.valueOf(i));
            result = result.multiply(num);
        }
        return result;
    }


    public static void test(){
        Integer i =100;
       int  j =100;
       System.out.println(i==j);
       System.out.println(i.equals(j));
    }
}
