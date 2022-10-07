package com.nisrinekane.bookbroker.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=3, max=30, message="title must be between 3 and 30 characters")
    private String title;
    @Size(min=3, max=30, message="author name must be between 3 and 30 characters")
    private String authorName;

    @Size(min=3, max=500, message="review must be between 5 and 500 characters")
    private String review;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="borrower_id")
    private User borrower;

    public Book() {}

    public Book(Long id, String title, String authorName, String review, Date createdAt, Date updatedAt, User owner, User borrower) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.review = review;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.owner = owner;
        this.borrower= borrower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}

