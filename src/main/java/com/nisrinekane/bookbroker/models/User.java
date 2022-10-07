package com.nisrinekane.bookbroker.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Name is required!")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String name;

    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;

    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
//    @Pattern(regexp = "^(?=.?[A-Z]).{8,}$", message = "At least one uppercase letter required")
//    @Pattern(regexp = "^(?=.?[a-z]).{8,}$", message = "At least one lowercase letter required")
//    @Pattern(regexp = "^(?=.*?[0-9]).{8,}$", message = "At least one number required")
    private String password;

    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Book> ownedBooks;

    @OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY)
    private List<Book> borrowedBooks;

    public User() {

    }

    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> getOwnedBooks() {
        return ownedBooks;
    }


    public void setOwnedBooks(List<Book> ownedBooks) {
        this.ownedBooks = ownedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
