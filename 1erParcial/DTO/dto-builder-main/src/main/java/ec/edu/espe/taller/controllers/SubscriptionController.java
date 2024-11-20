package ec.edu.espe.taller.controllers;

import ec.edu.espe.taller.dto.SubscriptionDTO;
import ec.edu.espe.taller.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Void> subscribeToCourse(@RequestParam Long userId, @RequestParam Long courseId) {
        subscriptionService.subscribeToCourse(userId, courseId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> cancelSubscription(@RequestParam Long userId, @RequestParam Long courseId) {
        subscriptionService.cancelSubscription(userId, courseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<SubscriptionDTO> getUserSubscriptions(@RequestParam Long userId) {
        return subscriptionService.getUserSubscriptions(userId);
    }
}
