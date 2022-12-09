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

    public String getUsersDialogTitle() {
        return properties.getProperty("usersDialogTitle");
    }

    public String lbl_txt_tittleUserPanel() {
        return properties.getProperty("lbl_txt_tittleUserPanel");
    }

    public String ac_addUser() {
        return properties.getProperty("ac_addUserActionCommand");
    }

    public String btn_txt_userPanelName() {
        return properties.getProperty("btn_txt_userPanelName");
    }

    public String btn_txt_userPanelRentedBooks() {
        return properties.getProperty("btn_txt_userPanelRentedBooks");
    }

    public String ac_UserButtons_() {
        return properties.getProperty("ac_UserButtons_ActionCommand");
    }

    public String getUserInfoDialogTitle() {
        return properties.getProperty("userInfoDialogTitle");
    }

    public String ac_deleteUserButtonUserInfoPanel() {
        return properties.getProperty("ac_deleteUserButtonUserInfoPanelActionCommand");
    }

    public String btn_txt_userInfoPanelEmail() {
        return properties.getProperty("btn_txt_userInfoPanelEmail");
    }

    public String btn_txt_userInfoPanelPhone() {
        return properties.getProperty("btn_txt_userInfoPanelPhone");
    }

    public String btn_txt_userInfoPanelAddress() {
        return properties.getProperty("btn_txt_userInfoPanelAddress");
    }

    public String getAddUserDialogTitle() {
        return properties.getProperty("addUserDialogTitle");
    }

    public String btn_txt_userInfoPanelSaveUserButton() {
        return properties.getProperty("btn_txt_userInfoPanelSaveUserButton");
    }

    public String ac_userInfoPanelSaveUserButton() {
        return properties.getProperty("ac_userInfoPanelSaveUserButtonActionCommand");
    }

    public String lbl_txt_icon() {
        return properties.getProperty("lbl_txt_icon");
    }

    public String src_IconMaleBase() {
        return properties.getProperty("src_iconMaleBase");
    }

    public String ac_maleIcon_() {
        return properties.getProperty("ac_maleIcon_ActionCommand");
    }

    public String src_IconFemaleBase() {
        return properties.getProperty("src_iconFemaleBase");
    }

    public String ac_femaleIcon_() {
        return properties.getProperty("ac_femaleIcon_ActionCommand");
    }

    public String src_AddButton() {
        return properties.getProperty("src_addButton");
    }

    public String lbl_txt_searchLabel() {
        return properties.getProperty("lbl_txt_searchLabel");
    }

    public String txt_SelectCopyId() {
        return properties.getProperty("txt_SelectCopyId");
    }

    public String txt_RemoveCopy() {
        return properties.getProperty("txt_RemoveCopy");
    }

    public String txt_EnterNewCopyId() {
        return properties.getProperty("txt_EnterNewCopyId");
    }

    public String txt_AddCopy() {
        return properties.getProperty("txt_AddCopy");
    }

    public String src_AddBookIcon() {
        return properties.getProperty("src_addBookIcon");
    }

    public String ac_deleteBook() {
        return properties.getProperty("ac_deleteBookActionCommand");
    }

    public String ac_historyBook() {
        return properties.getProperty("ac_historyBookActionCommand");
    }

    public String ac_addCopyBook() {
        return properties.getProperty("ac_addCopyBookActionCommand");
    }

    public String ac_removeCopyBook() {
        return properties.getProperty("ac_removeCopyBookActionCommand");
    }

    public String btn_txt_bookInfoPanelAuthor() {
        return properties.getProperty("btn_txt_bookInfoPanelAuthor");
    }

    public String btn_txt_bookInfoPanelYear() {
        return properties.getProperty("btn_txt_bookInfoPanelYear");
    }

    public String btn_txt_bookInfoPanelDescription() {
        return properties.getProperty("btn_txt_bookInfoPanelDescription");
    }

    public String btn_txt_bookInfoPanelISBN() {
        return properties.getProperty("btn_txt_bookInfoPanelISBN");
    }

    public String btn_txt_bookInfoPanelAvailableCopies() {
        return properties.getProperty("btn_txt_bookInfoPanelAvailableCopies");
    }

    public String btn_txt_bookInfoPanelTotalCopies() {
        return properties.getProperty("btn_txt_bookInfoPanelTotalCopies");
    }

    public String getBooksPath() {
        return properties.getProperty("booksPath");
    }

    public String getUsersPath() {
        return properties.getProperty("usersPath");
    }

    public String getCopiesPath() {
        return properties.getProperty("copiesPath");
    }

    public String getRentsPath() {
        return properties.getProperty("rentsPath");
    }

    public String btn_txt_deleteUserButton() {
        return properties.getProperty("btn_txt_deleteUserButton");
    }

    public String msg_Error() {
        return properties.getProperty("msg_Error");
    }

    public String msg_selectUserAndBook() {
        return properties.getProperty("msg_selectUserAndBook");
    }

    public String msg_BookRented() {
        return properties.getProperty("msg_BookRented");
    }

    public String msg_BookReturned() {
        return properties.getProperty("msg_BookReturned");
    }

    public String msg_NoCopies() {
        return properties.getProperty("msg_NoCopies");
    }

    public String msg_NoBooks() {
        return properties.getProperty("msg_NoBooks");
    }

    public String msg_SelectUserFirst() {
        return properties.getProperty("msg_SelectUserFirst");
    }

    public String msg_BookAddedCorrectly() {
        return properties.getProperty("msg_BookAddedCorrectly");
    }

    public String msg_DataIncorrectly() {
        return properties.getProperty("msg_DataIncorrectly");
    }

    public String msg_IdNotValid() {
        return properties.getProperty("msg_IdNotValid");
    }

    public String msg_IdAlreadyExist() {
        return properties.getProperty("msg_IdAlreadyExist");
    }

    public String msg_BookDeletedCorrectly() {
        return properties.getProperty("msg_BookDeletedCorrectly");
    }

    public String msg_BookHasRentals() {
        return properties.getProperty("msg_BookHasRentals");
    }

    public String msg_UserAddedCorrectly() {
        return properties.getProperty("msg_UserAddedCorrectly");
    }

    public String msg_UserHasBooks() {
        return properties.getProperty("msg_UserHasBooks");
    }

    public String msg_UserDeletedCorrectly() {
        return properties.getProperty("msg_UserDeletedCorrectly");
    }

    public String msg_ErrorSavingData() {
        return properties.getProperty("msg_ErrorSavingData");
    }

    public String getMailAt() {
        return properties.getProperty("mailAt");
    }
}
