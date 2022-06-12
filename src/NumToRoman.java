import java.util.HashMap;

public class NumToRoman {
    private static Integer[] units = {1000, 500, 100, 50, 10, 5, 1};
    private HashMap<Integer, String> map;
    private static HashMap<Integer, Integer> specialMap;
    private String romanNumeral;
    int number;

    public NumToRoman() {
        number = 0; // last number converted
        romanNumeral = ""; // last conversion, empty to start

        // determines special rule in effect (4 -> IV, 9 -> IX, etc.)
        specialMap = new HashMap<>();
        specialMap.put(1000, 100);
        specialMap.put(500, 100);
        specialMap.put(100, 10);
        specialMap.put(50, 10);
        specialMap.put(10, 1);
        specialMap.put(5, 1);
        specialMap.put(1, 0);

        // partial result Strings
        map = new HashMap<>();
        map.put(1000, "M"); // 1000 -> M
        map.put(900, "CM"); // special rule: 900 -> CM
        map.put(500, "D"); // 500 -> D
        map.put(400, "CD"); // special rule: 400 -> CD
        map.put(100, "C"); // 100 -> C
        map.put(90, "XC"); // special rule: 90 -> XC
        map.put(50, "L"); // 50 -> L
        map.put(40, "XL"); // special rule: 40 -> XL
        map.put(10, "X"); // 10 -> X
        map.put(9, "IX"); // special rule: 9 -> IX
        map.put(5, "V"); // 5 -> V
        map.put(4, "IV"); // special rule: 4 -> IV
        map.put(1, "I"); // 1 -> I
    }

    /**
     * get last Roman numeral converted
     * 
     * @return String
     */
    public String getRomanNumeral() {
        return romanNumeral;
    }

    /**
     * get last number converted
     * 
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * converts +/- int to Roman numeral String
     * 
     * @param int num
     * @return Roman numeralString
     */
    public String toRoman(int x) {
        this.number = x;

        StringBuilder romanBuilder = new StringBuilder();

        if (x < 0) {
            romanBuilder.append('-');
            x = -x;
        }

        // old school
        // x = buildRoman(romanBuilder, x, 1000);
        // // Fix 1990 -> MDCCCXC with second call to recognize 1000
        // x = buildRoman(romanBuilder, x, 1000);
        // // Fix 190 -> CLXXXX with second call to recognize 100
        // x = buildRoman(romanBuilder, x, 500);
        // x = buildRoman(romanBuilder, x, 100);
        // x = buildRoman(romanBuilder, x, 100);
        // x = buildRoman(romanBuilder, x, 50);
        // x = buildRoman(romanBuilder, x, 10);
        // // Fix 9 -> VIIII with second call to recognize 10
        // x = buildRoman(romanBuilder, x, 10);
        // x = buildRoman(romanBuilder, x, 5);
        // x = buildRoman(romanBuilder, x, 1);

        for (Integer unit : units) {
            // 2 calls for each unit value to handle special rules
            x = buildRoman(romanBuilder, x, unit);
            x = buildRoman(romanBuilder, x, unit);
        }

        // TODO why not simplify by traversing specialMap instead?
        // for (Map.Entry<Integer, Integer> set : specialMap.entrySet()) {
        // // 2 calls to handle special rules
        // x = buildRoman(romanBuilder, x, set.getKey());
        // x = buildRoman(romanBuilder, x, set.getKey());
        // }

        this.romanNumeral = romanBuilder.toString();
        return this.romanNumeral;
    }

    /**
     * accumulates Roman numeral string
     * 
     * @param rb StringBuilder to accumulate
     * @param num int to process
     * @param romanUnit int can be 1000, 500, 100, 50, 10, 5, or 1
     */
    private int buildRoman(StringBuilder rb, int num, int romanUnit) {
        int x = romanUnit - specialMap.get(romanUnit);
        // number must be at least big enough to trigger a special rule
        if (num < x)
            return num;
        // handle special rule in effect
        if (num < romanUnit || num == x) {
            rb.append(map.get(x));
            return num - x;
        }
        // otherwise loop appends symbols
        String symbol = map.get(romanUnit);
        while (num >= romanUnit) {
            rb.append(symbol);
            num -= romanUnit;
        }
        return num;
    }
}

