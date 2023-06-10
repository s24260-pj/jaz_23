package pl.pjatk.demo.movie.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 255)
    @Schema(description = "Movie Name")
    private String name;

    @Column(name = "is_available")
    @Schema(description = "Movie Status")
    private Boolean isAvailable = false;

    @Enumerated(EnumType.STRING)
    @NotBlank
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
