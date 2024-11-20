package ec.edu.espe.taller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO {
    private Long id;
    private Long userId; // ID del consumidor
    private Long courseId; // ID del curso
    private String subscriptionDate;
}
