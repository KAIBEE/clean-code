package fr.kaibee.cleancode.conditional;

public class ConditionalExamples {

    // Negative conditionals
    public void someMethod(Item[] items) {
        for (int i = 0; i < items.length; i++) {
            if (!isNotAgedBrie(items[i])) {
                System.out.println("I'm aged brie");
            } else {
                System.out.println("I'm not aged brie");
            }
        }
    }

    // encapsulate conditionals
    public void someOtherMethod(User user, Country currentCountry) {
        if (user.getAge() >= 18 && user.getNationalite().equals(currentCountry)) {
            System.out.println(user.getName() + " can vote");
        } else {
            System.out.println(user.getName() + " cannot vote");
        }
    }

    private static boolean isNotAgedBrie(Item items) {
        return !items.name.equals("Aged Brie");
    }

    private static class Item {
        String name;
        int quality;
    }

    private static class User {

        public User(int age, Country nationalite, String name) {
            this.age = age;
            this.nationalite = nationalite;
            this.name = name;
        }

        private int age;
        private Country nationalite;
        private String name;


        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Country getNationalite() {
            return nationalite;
        }

        public void setNationalite(Country nationalite) {
            this.nationalite = nationalite;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private enum Country {

    }
}
