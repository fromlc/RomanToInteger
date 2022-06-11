import java.util.HashMap;

public class NumToRoman {
    private HashMap<Integer, String> map;

    public NumToRoman() {
        map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(8, "VIII");
        map.put(7, "VII");
        map.put(6, "VI");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(3, "III");
        map.put(2, "II");
        map.put(1, "I");
    }

    /**
     * @param int num
     * @return Roman numeralString
     */
    public String toRoman(int num) {
        int x = num;
        StringBuilder romanBuilder = new StringBuilder("");

        if (x < 0) {
            romanBuilder.append('-');
            x = -x;
        }
        while (x >= 1000) {
            romanBuilder.append('M');
            x -= 1000;
        }
        while (x >= 500) {
            if (x / 100 == 9) {
                romanBuilder.append("CM");
                x -= 900;
                break;
            }
            romanBuilder.append('D');
            x -= 500;
        }
        while (x >= 100) {
            if (x / 100 == 4) {
                romanBuilder.append("CD");
                x -= 400;
                break;
            }
            romanBuilder.append('C');
            x -= 100;
        }
        while (x >= 50) {
            if (x / 10 == 9) {
                romanBuilder.append("XC");
                x -= 90;
                break;
            }
            romanBuilder.append('L');
            x -= 50;
        }
        while (x >= 10) {
            if (x / 10 == 4) {
                romanBuilder.append("XL");
                x -= 40;
                break;
            }
            romanBuilder.append('X');
            x -= 10;
        }
        if (x >= 5) {
            if (x == 9) {
                romanBuilder.append("IX");
                x = 0;
            } else {
                romanBuilder.append('V');
                x -= 5;
            }
        }
        if (x == 4)
            romanBuilder.append("IV");
        else {
            while (x > 0) {
                romanBuilder.append('I');
                x--;
            }
        }
        return romanBuilder.toString();
    }
}

