public final class Ascii {
    private Ascii() {   
    }

    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static char toLowerCase(char c) {
        return isUpperCase(c) ? (char) (c ^ 0x20) : c;
    }

    public static char toUpperCase(char c) {
        return isLowerCase(c) ? (char) (c & 0x5f) : c;
    }

    // tip: Charsequence 是个只读的接口，不是数组。 不能作为 set 中的对象
    public static String toLowerCase(CharSequence chars) {
        if (chars instanceof String) {
            return toLowerCase((String) chars);
        }
        char[] newChars = new char[chars.length()];
        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = toLowerCase(chars.charAt(i));
        }
        return String.valueOf(chars);
    }

     public static String toUpperCase(CharSequence chars) {
        if (chars instanceof String) {
            return toUpperCase((String) chars);
        }
        char[] newChars = new char[chars.length()];
        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = toUpperCase(chars.charAt(i));
        }
        return String.valueOf(chars);
    }

    public static String toLowerCase(String string) {
        int length = string.length();
        // 遍历字符串，当遇到了大写字母的时候开始转换，返回一个副本
        for (int i = 0; i < length; i++) {
            if (isUpperCase(string.charAt(i))) {
             char[] chars = string.toCharArray();
             for (; i < length; i++) {
                 char c = chars[i];
                 if (isUpperCase(c)) {
                     chars[i] = (char) (c ^ 0x20);
                 }
             } 
             return String.valueOf(chars); 
            }
        }
        return string;
    }

    public static String toUpperCase(String string) {
        int length = string.length();
        // 遍历字符串，当遇到了大写字母的时候开始转换，返回一个副本
        for (int i = 0; i < length; i++) {
            if (isLowerCase(string.charAt(i))) {
             char[] chars = string.toCharArray();
             for (; i < length; i++) {
                 char c = chars[i];
                 if (isLowerCase(c)) {
                     chars[i] = (char) (c & 0x5f);
                 }
             } 
             return String.valueOf(chars); 
            }
        }
        return string;
    }

    

}