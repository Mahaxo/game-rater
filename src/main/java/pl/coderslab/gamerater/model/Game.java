package pl.coderslab.gamerater.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank
    private String name;
    @ManyToOne
    private Genre genre;
    @Max(value = 18)
    private Integer minimumAge;
    @ManyToOne
    private Publisher publisher;
    @OneToMany(mappedBy = "game")
    private List<Platform> platforms = new ArrayList<>();
    private Double rating;
    private LocalDate releaseDate;
    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    public Game() {
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", minimumAge=" + minimumAge +
                ", publisher=" + publisher +
                ", platforms=" + platforms +
                ", rating=" + rating +
                ", releaseYear=" + releaseDate +
                ", comments=" + comments +
                '}';
    }
}
