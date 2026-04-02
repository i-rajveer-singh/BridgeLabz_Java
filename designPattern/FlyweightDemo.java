package designpattern;

import java.util.HashMap;
import java.util.Map;

// 1. Flyweight Class
class TextStyle {

    private String fontName;
    private int size;

    public TextStyle(String fontName, int size) {
        this.fontName = fontName;
        this.size = size;
    }

    public void applyStyle(String character) {
        System.out.println("Character: " + character +
                " | Font: " + fontName +
                " | Size: " + size);
    }
}

// 2. Flyweight Factory
class TextStyleFactory {

    private static final Map<String, TextStyle> stylePool = new HashMap<>();

    public static TextStyle getStyle(String fontName, int size) {

        String key = fontName + size;

        if (!stylePool.containsKey(key)) {
            stylePool.put(key, new TextStyle(fontName, size));
        }

        return stylePool.get(key);
    }
}

// 3. Context Class
class DocumentCharacter {

    private String value;
    private TextStyle style;

    public DocumentCharacter(String value, TextStyle style) {
        this.value = value;
        this.style = style;
    }

    public void display() {
        style.applyStyle(value);
    }
}

// 4. Main Class
public class FlyweightDemo {

    public static void main(String[] args) {

        TextStyle style1 = TextStyleFactory.getStyle("Arial", 12);
        TextStyle style2 = TextStyleFactory.getStyle("Arial", 12);

        DocumentCharacter c1 = new DocumentCharacter("A", style1);
        DocumentCharacter c2 = new DocumentCharacter("B", style2);

        c1.display();
        c2.display();

        System.out.println("Same style object? " + (style1 == style2));
    }
}