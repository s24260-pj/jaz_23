package pl.pjatk.demo.movie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "is_available")
    private Boolean isAvailable = false;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
}
