package springAdvanced.startingLesson.assignmentOfJavaMongoDB.entities;

import lombok.*;
import org.bson.Document;

import javax.swing.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public Company(Document document) {
        this.name = document.getString("name");
        this.name = document.getString("catchPhrase");
        this.name = document.getString("bs");
    }

}
