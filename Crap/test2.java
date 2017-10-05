//AP_tut_2_1

import java.util.*;

class test2{

  public static void main(String[] args) {
    String s1 = "aaaaaaa";
    String s2 = "bbbbbbb";

    s1 = s1+ "-" + s2;
    System.out.println(s1);
    String[] s3 = s1.split("-");
    s1 = s3[1];
    s2 = s3[0];
    System.out.println(s1);
    System.out.println(s2);

  }
}
