package src.my.test.operators;

import static net.mindview.util.Print.print;

public class Main {
    public static void main(String[] args) {
        long bigValue = 0x12222F2L;
        Integer integerValue = 0x12312;
        char charValue = 'd';
        char charValueH = 78;
        char charValueAnother = '\u9901';
        long bigValueOri = 1234L;

//        print(Long.toHexString(bigValue));
//        print(Long.toOctalString(bigValue));
//        print(Long.toBinaryString(bigValue));
//        print(Long.toString(bigValue));

        print(charValue);


        print(charValueH);

        print(charValueAnother);

        print(charValue);
    }

}
