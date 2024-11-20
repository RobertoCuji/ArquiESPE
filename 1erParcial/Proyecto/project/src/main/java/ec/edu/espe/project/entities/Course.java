package ec.edu.espe.taller.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String state; // IN_CONSTRUCTION, ACTIVE, INACTIVE

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;
}
