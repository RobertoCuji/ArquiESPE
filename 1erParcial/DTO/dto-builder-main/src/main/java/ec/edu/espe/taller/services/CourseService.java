package ec.edu.espe.taller.services;

import ec.edu.espe.taller.dto.CourseDTO;
import ec.edu.espe.taller.entities.Course;
import ec.edu.espe.taller.entities.User;
import ec.edu.espe.taller.exceptions.ResourceNotFoundException;
import ec.edu.espe.taller.repositories.CourseRepository;
import ec.edu.espe.taller.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public CourseDTO createCourse(CourseDTO courseDTO) {
        User creator = userRepository.findById(courseDTO.getCreatorId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + courseDTO.getCreatorId()));
        Course course = Course.builder()
                .name(courseDTO.getName())
                .description(courseDTO.getDescription())
                .state(courseDTO.getState())
                .creator(creator)
                .build();
        course = courseRepository.save(course);
        return mapToDTO(course);
    }

    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setState(courseDTO.getState());
        course = courseRepository.save(course);
        return mapToDTO(course);
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        courseRepository.delete(course);
    }

    public CourseDTO getCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        return mapToDTO(course);
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void changeCourseState(Long id, String state) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        course.setState(state);
        courseRepository.save(course);
    }

    private CourseDTO mapToDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .state(course.getState())
                .creatorId(course.getCreator().getId())
                .build();
    }
}
