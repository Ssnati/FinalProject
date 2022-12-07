package persistence;

import com.google.gson.Gson;
import model.Book;
import model.Copy;
import model.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Persistence {
    public Persistence() throws IOException {
        FileReader reader = new FileReader("data/Books.json");

        List<Copy> rentedCopies = new ArrayList<>();
        rentedCopies.add(new Copy(new Book("sources/covers/Cover1.png","Tittle 1","Author 1","2019","Description 1","ISBN 1"), 1, true));
        User user = new User("sources/icons/Icon1.png","Name 1","Email 1","Address 1","Phone 1", rentedCopies);
        Gson gson = new Gson();
//        System.out.println(gson.toJson(user));
        User[] books = gson.fromJson(reader, User[].class);
        Stream.of(books).forEach(System.out::println);
        //print all books names
        Stream.of(books).forEach(book -> System.out.println(gson.toJson(book)));

        reader.close();
    }

    public static void main(String[] args) {
        /*try {

            new Persistence();
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }*/
        for (int i = 2; i <= 5; i++) {
            System.out.println("{\n" +
                    "    \"associatedBook\": {\n" +
                    "      \"coverSource\": \"sources/covers/Cover4.png\",\n" +
                    "      \"title\": \"Harry Potter y el prisionero de Azkaban\",\n" +
                    "      \"author\": \"J.K. Rowling\",\n" +
                    "      \"year\": \"1999\",\n" +
                    "      \"description\": \"El tercer año de estudios de Harry en Hogwarts se ve amenazado por la fuga de Sirius Black de la prisión de Azkaban. Al parecer, se trata de un peligroso mago que fue cómplice de Lord Voldemort y que intentará vengarse de Harry Potter.\",\n" +
                    "      \"ISBN\": \"978-84-7888-447-6\"\n" +
                    "    },\n" +
                    "    \"id\": "+i+",\n" +
                    "    \"available\": true\n" +
                    "  },");
        }
    }
}
