import java.util.ArrayList;

public class RecommendationBookManager {
    static class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return title + " by " + author;
        }
    }

    public static void main(String args[]) {
        ArrayList<Book> recommendations = new ArrayList<>();
        recommendations.add(new Book("Effective Java", "Joshua Bloch"));
        recommendations.add(new Book("Clean Code", "Robert C. Martin"));
        recommendations.add(new Book("Java Concurrency", "Brian Goetz"));
        System.out.println(recommendations);
        // TODO 1: Add 3 new books to the recommendation list
        recommendations.add(new Book("Harry Potter", "Rolling"));
        recommendations.add(new Book("Spring MVC", "John Smith"));
        recommendations.add(new Book("Dragonball7", "Toriyama Akira"));
        System.out.println(recommendations);
        /* TODO 2: Update existing recommendations
         * at index 1 (2nd element)
         * at index 2 (3rd element)
         */
        recommendations.add(1, new Book("Effective Java", "Joshua Bloch"));
        recommendations.add(2, new Book("Clean Code", "Robert C. Martin"));
        System.out.println(recommendations);
        /* TODO 3: Remove outdated recommendations
         * at index 0 (first place)
         * at index 3 (fourth place)
         */
        recommendations.removeFirst();
        recommendations.remove(3);
        System.out.println(recommendations);
    }
}
