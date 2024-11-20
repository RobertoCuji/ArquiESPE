package ec.edu.espe.taller.services;

import ec.edu.espe.taller.dto.SubscriptionDTO;
import ec.edu.espe.taller.entities.Course;
import ec.edu.espe.taller.entities.Subscription;
import ec.edu.espe.taller.entities.User;
import ec.edu.espe.taller.exceptions.ResourceNotFoundException;
import ec.edu.espe.taller.repositories.SubscriptionRepository;
import ec.edu.espe.taller.repositories.CourseRepository;
import ec.edu.espe.taller.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void subscribeToCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));

        Subscription subscription = Subscription.builder()
                .user(user)
                .course(course)
                .subscriptionDate(LocalDateTime.now())
                .build();

        subscriptionRepository.save(subscription);
    }

    public void cancelSubscription(Long userId, Long courseId) {
        Subscription subscription = subscriptionRepository.findByUserIdAndCourseId(userId, courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found"));
        subscriptionRepository.delete(subscription);
    }

    public List<SubscriptionDTO> getUserSubscriptions(Long userId) {
        return subscriptionRepository.findByUserId(userId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private SubscriptionDTO mapToDTO(Subscription subscription) {
        return SubscriptionDTO.builder()
                .id(subscription.getId())
                .userId(subscription.getUser().getId())
                .courseId(subscription.getCourse().getId())
                .subscriptionDate(subscription.getSubscriptionDate().toString())
                .build();
    }
}
