package springAdvanced.startingLesson.assignmentOfJavaMongoDB.entities;


import lombok.*;
import org.bson.Document;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserEntity {
    private ObjectId mongoId;

    private Integer id;
    private String name;
    private String username;
    private String email;

    private Address address;


    private String phone;
    private String website;

    private Company company;

    public UserEntity(Document document) {
        this.mongoId = document.getObjectId("_id");
        this.id = document.getInteger("id");
        this.name = document.getString("name");
        this.username = document.getString("username");
        this.email = document.getString("email");
        Document addressDoc = document.get("address", Document.class);
        if (addressDoc != null) {
            this.address = new Address(addressDoc);
        }

        this.phone = document.getString("phone");
        this.website = document.getString("website");

        Document companyDoc = document.get("company", Document.class);
        if (companyDoc != null) {
            this.company = new Company(companyDoc);
        }

    }

  /*  public Post(Document document) {
        this.mongoID = document.getObjectId("_id");
        this.id = document.getInteger("id");
        this.userId = document.getInteger("userId");
        this.title = document.getString("title");
        this.body = document.getString("body");

    }*/
}
