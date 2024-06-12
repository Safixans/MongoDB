package springAdvanced.startingLesson.assignment.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import springAdvanced.startingLesson.assignment.entity.Group;
import springAdvanced.startingLesson.assignment.entity.Student;

import java.util.List;

public interface GroupRepository extends MongoRepository<Group,String> {



}
