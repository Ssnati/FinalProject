package persistence;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PrivateProperties {

    private final Properties properties;

    public PrivateProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileReader("data/Properties.properties"));
    }

    public String getApplicationName() {
        return properties.getProperty("applicationName");
    }

    public String src_BackgroundImage() {
        return properties.getProperty("src_backgroundImage");
    }

    public String src_UsersButtonImage() {
        return properties.getProperty("src_usersButtonImage");
    }

    public String ac_UsersButton() {
        return properties.getProperty("ac_usersButtonActionCommand");
    }

    public String src_BooksButtonImage() {
        return properties.getProperty("src_booksButtonImage");
    }

    public String ac_BooksButton() {
        return properties.getProperty("ac_booksButtonActionCommand");
    }

    public String src_RentButtonImage() {
        return properties.getProperty("src_rentButtonImage");
    }

    public String ac_getRentButton() {
        return properties.getProperty("ac_rentButtonActionCommand");
    }

    public String getBooksDialogTitle() {
        return properties.getProperty("booksDialogTitle");
    }

    public String getBookInfoDialogTitle() {
        return properties.getProperty("bookInfoDialogTitle");
    }
}
