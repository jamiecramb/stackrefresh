package org.jcramb.stackrefresh.book.rest.dto;

/**
 * Dto that represents a book.
 * 
 * @author Jamie Cramb
 */
public class BookDto {

    private Long id;

    private String name;

    private String description;

    private String author;

    public BookDto() {
    }

    public BookDto(String name, String description, String author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDto [id=" + id + ", name=" + name + ", description=" + description + ", author=" + author + "]";
    }
}