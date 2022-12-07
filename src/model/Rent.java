package model;

public class Rent {
    private String rentDate;
    private String returnDate;
    private Copy associatedCopy;
    private User associatedUser;

    public Rent(String rentDate, String returnDate, Copy associatedCopy, User associatedUser) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.associatedCopy = associatedCopy;
        this.associatedUser = associatedUser;
    }


    public Copy getAssociatedCopy() {
        return associatedCopy;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setAssociatedCopy(Copy associatedCopy) {
        this.associatedCopy = associatedCopy;
    }

    public User getAssociatedUser() {
        return associatedUser;
    }

    public void setAssociatedUser(User associatedUser) {
        this.associatedUser = associatedUser;
    }

    public String toView() {
        return associatedUser.getName()+ ";" + associatedCopy.getId() + ";" + rentDate + ";" + returnDate;
    }
}
