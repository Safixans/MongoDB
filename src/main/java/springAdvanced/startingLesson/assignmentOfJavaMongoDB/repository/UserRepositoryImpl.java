package springAdvanced.startingLesson.assignmentOfJavaMongoDB.repository;

import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import lombok.NonNull;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import springAdvanced.startingLesson.assignmentOfJavaMongoDB.entities.UserEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private static final MongoClient CLIENT = MongoClients.create("mongodb://assignment:123@localhost:27017/assignment");
    private static final MongoDatabase DB = CLIENT.getDatabase("assignment");
    private static final MongoCollection<Document> COLLECTION = DB.getCollection("users");

    @Override
    public UserEntity get(String id) {
        Bson filter = Filters.eq("_id", new ObjectId(id));
        Document first = COLLECTION.find(filter).first();
        if (first == null) {
            return null;
        }
        return new UserEntity(first);
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> users = new ArrayList<>();
        FindIterable<Document> documents = COLLECTION.find();
        for (Document document : documents) {
            users.add(new UserEntity(document));
        }
        return users;
    }

    @Override
    public List<UserEntity> getAll(int page, int size) {

        List<UserEntity> users = new ArrayList<>();
        Bson id = Sorts.ascending("id");
        Bson sort = Sorts.orderBy(id);
        Bson name = Sorts.ascending("name");
        Bson filter = Filters.regex(name.toString(), "^A[A-Za-z]*$");
        FindIterable<Document> documents = COLLECTION.find(filter)
                .sort(sort)
                .skip(size * page)
                .limit(size);
        for (Document document : documents) {
            users.add(new UserEntity(document));
        }

        return users;
    }

    @Override
    public UserEntity save(@NonNull UserEntity userEntity) {
        Document document = new Document(Map.of(
                "id", userEntity.getId(),
                "name", userEntity.getName(),
                "username", userEntity.getUsername(),
                "email", userEntity.getEmail(),
                "address", userEntity.getAddress(),
                "geo", userEntity.getAddress().getGeo(),
                "phone", userEntity.getPhone(),
                "website", userEntity.getWebsite(),
                "company", userEntity.getCompany()
        ));

        InsertOneResult insertOneResult = COLLECTION.insertOne(document);
        if (insertOneResult.wasAcknowledged()) {
            ObjectId mongoId = insertOneResult.getInsertedId().asObjectId().getValue();
            userEntity.setMongoId(mongoId);
            return userEntity;
        }
        return null;
    }

    @Override
    public List<UserEntity> saveAll(@NonNull List<UserEntity> users) {
        for (UserEntity user : users) {
            save(user);
        }
        return users;
    }

    @Override
    public boolean delete(String id) {
        Bson filter = Filters.eq("_id", new ObjectId(id));
        DeleteResult deleteResult = COLLECTION.deleteOne(filter);
        return deleteResult.wasAcknowledged();
    }

    @Override
    public boolean update(UserEntity user) {
        Bson filter = Filters.eq("_id", user.getMongoId());
        Bson update = Updates.combine(
                Updates.set("catchPhrase", user.getCompany().getCatchPhrase()),
                Updates.set("lng", user.getAddress().getGeo().getLng())
        );
        return COLLECTION.updateOne(filter, update).wasAcknowledged();
    }
}
