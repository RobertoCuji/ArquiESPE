package ec.edu.espe.taller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private String state; // IN_CONSTRUCTION, ACTIVE, INACTIVE
    private Long creatorId; // ID del usuario creador
}
