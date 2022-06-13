package edu.miu.post.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Qiyao
 * @Date:6/10/22 14:34
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String title;

    private String picture;

    @Lob
    @NotBlank
    private String content;

    @Column(updatable = false)
    private LocalDate postedDate;

    private long userId;

    @OneToMany(mappedBy = "post")
    private List<Reaction> reactions = new ArrayList<>();

    private LocalDate updateDate;

    public Post(String title, String picture, String content ) {
        this.title = title;
        this.picture = picture;
        this.content = content;
    }

    public Post(long id, String title, String picture, String content) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.content = content;
    }

    @PrePersist
    private void prePersist() {
        setPostedDate(LocalDate.now());
    }

    @PreUpdate
    private void preUpdate() {
        setUpdateDate(LocalDate.now());
    }

}
