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
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    /**
     * @param int num
     * @return Roman numeralString
     */
    public String toRoman(int x) {
        StringBuilder romanBuilder = new StringBuilder();

        if (x < 0) {
            romanBuilder.append('-');
            x = -x;
        }
        x = buildRoman(romanBuilder, x, 1000, 100);
        // Fix 1990 -> MDCCCXC with second call to recognize 1000
        x = buildRoman(romanBuilder, x, 1000, 100);
        x = buildRoman(romanBuilder, x, 500, 100);
        x = buildRoman(romanBuilder, x, 100, 10);
        // Fix 190 -> CLXXXX with second call to recognize 100
        x = buildRoman(romanBuilder, x, 100, 10);
        x = buildRoman(romanBuilder, x, 50, 10);
        x = buildRoman(romanBuilder, x, 10, 1);
        // Fix 9 -> VIIII with second call to recognize 10
        x = buildRoman(romanBuilder, x, 10, 1);
        x = buildRoman(romanBuilder, x, 5, 1);
        x = buildRoman(romanBuilder, x, 1, 0);

        return romanBuilder.toString();
    }

    /**
     * 
     * @param rb StringBuilder to use
     * @param num int being converted
     * @param romanUnit int 1000, 500, 100, 50, 10, 5, 1
     * @param z int checks for special rule in play
     */
    private int buildRoman(StringBuilder rb, int num, int romanUnit, int z) {
        int x = romanUnit - z;
        // number must be at least the unit size minus z-factor
        if (num < x)
            return num;
        // handle special rule in effect
        if (num < romanUnit || num == x) {
            rb.append(map.get(x));
            return num - x;
        }
        // otherwise loop appends symbols
        while (num >= romanUnit) {
            rb.append(map.get(romanUnit));
            num -= romanUnit;
        }
        return num;
    }
}

