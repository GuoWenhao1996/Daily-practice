/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package exp1;

/**
 *
 * @author guowh
 */
public class ABCDE {

    public static void main(String[] args) {
        String A = "";
        String B = "";
        String C = "";
        String D = "";
        String E = "";
        Integer ji = 12345;
        Integer ji2 = 12345;
        for (Integer num = 12345; num <= 98765; num++) {
            for (int i = 1; i < 10; i++) {
                ji = num * i;
                if(ji>99999)
                    continue;
                A = ji.toString().substring(0, 1);
                B = ji.toString().substring(1, 2);
                C = ji.toString().substring(2, 3);
                D = ji.toString().substring(3, 4);
                E = ji.toString().substring(4, 5);
                if(A.equals(B)||A.equals(C)||A.equals(D)||A.equals(E)||B.equals(C)||B.equals(D)||B.equals(E)||C.equals(D)||C.equals(E)||D.equals(E))
                    continue;
                ji=Integer.parseInt(E+D+C+B+A);
                if(ji.equals(num))
                    System.out.println(num+"*"+i+"="+num * i);
            }
        }

    }

}
