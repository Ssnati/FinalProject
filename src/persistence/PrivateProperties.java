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

    public String ac_RentButton() {
        return properties.getProperty("ac_rentButtonActionCommand");
    }

    public String getBooksDialogTitle() {
        return properties.getProperty("booksDialogTitle");
    }

    public String getBookInfoDialogTitle() {
        return properties.getProperty("bookInfoDialogTitle");
    }

    public String btn_txt_deleteBookButton() {
        return properties.getProperty("btn_txt_deleteBookButton");
    }

    public String btn_txt_historyBookButton() {
        return properties.getProperty("btn_txt_historyBookButton");
    }

    public String btn_txt_addCopyBookButton() {
        return properties.getProperty("btn_txt_addCopyBookButton");
    }

    public String btn_txt_removeCopyBookButton() {
        return properties.getProperty("btn_txt_removeCopyBookButton");
    }

    public String getSplitter() {
        return properties.getProperty("splitter");
    }

    public String getBookHistoryDialogTitle() {
        return properties.getProperty("bookHistoryDialogTitle");
    }

    public String tbl_0_column() {
        return properties.getProperty("tbl_0_column");
    }

    public String tbl_1_column() {
        return properties.getProperty("tbl_1_column");
    }

    public String tbl_2_column() {
        return properties.getProperty("tbl_2_column");
    }

    public String tbl_3_column() {
        return properties.getProperty("tbl_3_column");
    }

    public String getAddBookDialogTitle() {
        return properties.getProperty("addBookDialogTitle");
    }

    public String src_AddCoverPath() {
        return properties.getProperty("src_addCoverPath");
    }

    public String ac_AddCover() {
        return properties.getProperty("ac_addCoverActionCommand");
    }

    public String btn_txt_saveBookButton() {
        return properties.getProperty("btn_txt_saveBookButton");
    }

    public String ac_SaveBook() {
        return properties.getProperty("ac_saveBookActionCommand");
    }

    public String btn_txt_addTittleLabel() {
        return properties.getProperty("btn_txt_addTittleLabel");
    }

    public String btn_txt_addDescriptionLabel() {
        return properties.getProperty("btn_txt_addDescriptionLabel");
    }

    public String btn_txt_addAuthorLabel() {
        return properties.getProperty("btn_txt_addAuthorLabel");
    }

    public String btn_txt_addYearLabel() {
        return properties.getProperty("btn_txt_addYearLabel");
    }

    public String btn_txt_addISBNLabel() {
        return properties.getProperty("btn_txt_addISBNLabel");
    }

    public String btn_txt_addCopyNumberLabel() {
        return properties.getProperty("btn_txt_addCopyNumberLabel");
    }

    public String fc_description() {
        return properties.getProperty("fc_description");
    }

    public String fc_extension_1() {
        return properties.getProperty("fc_extension_1");
    }

    public String fc_extension_2() {
        return properties.getProperty("fc_extension_2");
    }

    public String src_BasicCoverPath() {
        return properties.getProperty("src_basicCoverPath");
    }

    public String lbl_txt_tittleBooksPanel() {
        return properties.getProperty("lbl_txt_tittleBooksPanel");
    }

    public String ac_pnl_addBook() {
        return properties.getProperty("ac_pnl_addBookActionCommand");
    }

    public String ac_BookButtons_() {
        return properties.getProperty("ac_BookButtons_ActionCommand");
    }

    public String getSelectionDialogTitle() {
        return properties.getProperty("selectionDialogTitle");
    }

    public String src_BackgroundImage2() {
        return properties.getProperty("src_backgroundImage2");
    }

    public String btn_txt_rentButton() {
        return properties.getProperty("btn_txt_rentButton");
    }

    public String btn_txt_returnButton() {
        return properties.getProperty("btn_txt_returnButton");
    }

    public String ac_rentButtonSelectionPanel() {
        return properties.getProperty("ac_rentButtonSelectionPanelActionCommand");
    }

    public String ac_returnButtonSelectionPanel() {
        return properties.getProperty("ac_returnButtonSelectionPanelActionCommand");
    }

    public String getOperationDialogTitle() {
        return properties.getProperty("operationDialogTitle");
    }

    public String btn_txt_selectUserButton() {
        return properties.getProperty("btn_txt_selectUserButton");
    }

    public String btn_txt_selectBookButton() {
        return properties.getProperty("btn_txt_selectBookButton");
    }

    public String btn_txt_rentActionButton() {
        return properties.getProperty("btn_txt_rentActionButton");
    }

    public String btn_txt_returnActionButton() {
        return properties.getProperty("btn_txt_returnActionButton");
    }

    public String src_AddUserIcon() {
        return properties.getProperty("src_addUserIcon");
    }

    public String ac_selectUserButtonToRent() {
        return properties.getProperty("ac_selectUserButtonToRentActionCommand");
    }

    public String ac_selectBookButtonToRent() {
        return properties.getProperty("ac_selectBookButtonToRentActionCommand");
    }

    public String ac_rentBookButton() {
        return properties.getProperty("ac_rentBookButtonActionCommand");
    }

    public String ac_returnBookButton() {
        return properties.getProperty("ac_returnBookButtonActionCommand");
    }
}
