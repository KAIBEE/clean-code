package fr.kaibee.cleancode.conditional;

public class ConditionalExamples {

    public void someMethod(Item[] items) {
        for (int i = 0; i < items.length; i++) {
            if (!isNotAgedBrie(items[i])) {
                System.out.println("I'm aged brie");
            } else {
                System.out.println("I'm not aged brie");
            }
        }

    }

    private static boolean isNotAgedBrie(Item items) {
        return !items.name.equals("Aged Brie");
    }
}

class Item {
    String name;
    int quality;
}
