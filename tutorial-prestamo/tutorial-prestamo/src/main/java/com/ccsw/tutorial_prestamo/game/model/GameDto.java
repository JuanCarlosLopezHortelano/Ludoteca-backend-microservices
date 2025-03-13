package com.ccsw.tutorial_prestamo.game.model;

import com.ccsw.tutorial_prestamo.author.model.AuthorDto;
import com.ccsw.tutorial_prestamo.category.model.CategoryDto;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ccsw
 *
 */
public class GameDto {

    private Long id;

    private String title;

    private String age;
    @JsonProperty("category")
    private CategoryDto categoryDto;
    @JsonProperty("author")
    private AuthorDto authorDto;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {

        return this.title;
    }

    /**
     * @param title new value of {@link #getTitle}.
     */
    public void setTitle(String title) {

        this.title = title;
    }

    /**
     * @return age
     */
    public String getAge() {

        return this.age;
    }

    /**
     * @param age new value of {@link #getAge}.
     */
    public void setAge(String age) {

        this.age = age;
    }

    public AuthorDto getAuthorDto() {
        return this.authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    public CategoryDto getCategoryDto() {
        return this.categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}