package springAdvanced.startingLesson;


import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class StartingLessonApplication {

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/?directConnection=true");
        MongoDatabase db = mongoClient.getDatabase("pdpjava");

        MongoCollection<Document> postsCollection = db.getCollection("posts");
        FindIterable<Document> documents = postsCollection.find();
//      find(postsCollection);
//      insertOne(postsCollection);
//      insertMany(postsCollection);
//      updateDocument(postsCollection);
//        deleteDocument(postsCollection);



    }

    private static void deleteDocument(MongoCollection<Document> postsCollection) {
        //Bson filter = Filters.regex("post_title","Post.*");
        Bson filter = Filters.empty();/// to delete  all elements on collection
        postsCollection.deleteMany(filter);
//        Bson filter = Filters.eq("_id", new ObjectId("6667ff68c8a4eb1434bc0e21"));
//        postsCollection.deleteOne(filter);
    }

    private static void updateDocument(MongoCollection<Document> postsCollection) {
    /* Bson filter = Filters.regex("title", ".*o.*");
     Bson update = Updates.set("createdAt", new Date());
//        postsCollection.updateOne(filter, update);
     UpdateResult updateResult = postsCollection.updateMany(filter, update);
     if (updateResult.wasAcknowledged()) {
         System.out.println(updateResult.getModifiedCount());


     }
     */
//      find(postsCollection);
//      insertOne(postsCollection);
//      insertMany(postsCollection);
//      insertOne(postsCollection);

        /*Bson filter = Filters.exists("title");
        Bson rename = Updates.rename("title", "post_title");
        UpdateResult updateResult = postsCollection.updateMany(filter, rename);
        System.out.println("updateResult.getModifiedCount() = " + updateResult.getModifiedCount());*/

//        Bson filter=Filters.exists("createdAt");
        Bson filter = Filters.empty();
        Bson createdAt = Updates.unset("createdAt");
        UpdateResult updateResult = postsCollection.updateMany(filter, createdAt);
        System.out.println("updateResult.getModifiedCount() = " + updateResult.getModifiedCount());
    }

    private static void find(MongoCollection<Document> postsCollection) {
    /*    for (Document document : documents) {
            System.out.println("document.getString(\"title\") = " + document.getString("title"));
            document.get("title", String.class);
            System.out.println(document);
        }*/
        Bson filter = Filters.eq("_id", new ObjectId("6667ff68c8a4eb1434bc0e21"));
        Document document = postsCollection.find(filter)
                .first();
        System.out.println("document = " + document);
        Document address = document.get("address", Document.class);
        String string = address.getString("zipcode");
        System.out.println("string = " + string);
    }

    private static void insertMany(MongoCollection<Document> postsCollection) {
        String post1 = """
                { "title" : "Post 3 title",
                  "body" : "Post 3 body"
                }
                """;
        Map<String, Object> map = Map.of(
                "title", "post 2 title",
                "body", "post 2 body"
        );
        List<Document> documents = List.of(
                Document.parse(post1),
                new Document(map)
        );
        InsertManyResult insertManyResult = postsCollection.insertMany(documents);
        if (insertManyResult.wasAcknowledged()) {
            insertManyResult.getInsertedIds().forEach((k, v) -> {
                ObjectId value = v.asObjectId().getValue();
                System.out.println(k + " : " + value.toString());
            });
        }
    }

    private static void insertOne(MongoCollection<Document> postsCollection) {
        Document doc = Document.parse("""
                  {
                    "id": 1,
                    "name": "Leanne Graham",
                    "username": "Bret",
                    "email": "Sincere@april.biz",
                    "address": {
                      "street": "Kulas Light",
                      "suite": "Apt. 556",
                      "city": "Gwenborough",
                      "zipcode": "92998-3874",
                      "geo": {
                        "lat": "-37.3159",
                        "lng": "81.1496"
                      }
                    },
                    "phone": "1-770-736-8031 x56442",
                    "website": "hildegard.org",
                    "company": {
                      "name": "Romaguera-Crona",
                      "catchPhrase": "Multi-layered client-server neural-net",
                      "bs": "harness real-time e-markets"
                    }
                  }
                """);

                /*new Document("title", "how to connect MongoDB to java applications")
                .append("body", "it is easy to use mongoDB-driver-async applications dependency ")
                .append("created_at", new Date());*/

        InsertOneResult insertOneResult = postsCollection.insertOne(doc);

        if (insertOneResult.wasAcknowledged()) {
            BsonValue insertedId = insertOneResult.getInsertedId();
            ObjectId value = insertedId.asObjectId().getValue();
            System.out.println("value.toString() = " + value.toString());
        }

    }

}
