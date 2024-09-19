package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_image")
    private int codeImage;

    @Column(name = "name_image")
    private String nameImage;

    @Column(name = "is_icon")
    private boolean isIcon;

    @Column(name = "url")
    private String url;

    @Column(name = "data_image", columnDefinition = "LONGTEXT")
    @Lob
    private String dataImage;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "code_book", nullable = false)
    private Book book;
}
