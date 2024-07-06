package tn.nasa_service_b.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "apods")
public class Apod {
    @Id
    private Date date;
    private String title;
    private String hdurl;
    @Column(name = "explanation", length = 10000)
    private String explanation;
}
