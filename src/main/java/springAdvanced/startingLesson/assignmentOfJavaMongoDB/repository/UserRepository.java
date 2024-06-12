package springAdvanced.startingLesson.assignmentOfJavaMongoDB.repository;


import lombok.NonNull;
import springAdvanced.startingLesson.assignmentOfJavaMongoDB.entities.UserEntity;
import springAdvanced.startingLesson.posts.Post;

import java.util.List;

public interface UserRepository {
    UserEntity get(String id);
    List<UserEntity> getAll();
    List<UserEntity> getAll(int page,int size);
    UserEntity save(@NonNull UserEntity userEntity);
    List<UserEntity> saveAll(@NonNull List<UserEntity> users);
    boolean delete(String id);
    boolean update(UserEntity users);
}
