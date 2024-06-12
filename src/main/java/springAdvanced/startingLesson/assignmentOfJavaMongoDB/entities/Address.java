
package springAdvanced.startingLesson.assignmentOfJavaMongoDB.entities;

import lombok.*;
import org.bson.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {
    private String street;
    private String suit;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(Document document) {
        this.street = document.getString("street");
        this.suit = document.getString("suit");
        this.city = document.getString("city");
        this.zipcode = document.getString("zipcode");

        Document geoDoc = document.get("geo", Document.class);
        if (geoDoc != null) {
            this.geo = new Geo(geoDoc);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    public static class Geo {
        private String lat;
        private String lng;

        public Geo(Document document) {
            this.lat = document.getString("lat");
            this.lng = document.getString("lng");
        }
    }
}



/*
package springAdvanced.startingLesson.assignmentOfJavaMongoDB.entities;

import lombok.*;
import org.bson.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {
    private String street;
    private String suit;
    private String city;
    private String zipcode;


    public Address(Document document) {
        this.street = document.getString("street");
        this.suit = document.getString("suit");
        this.city = document.getString("city");
        this.zipcode = document.getString("zipcode");
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Geo {
        private String lat;
        private String lng;


        public Geo(Document document) {
            this.lat = document.getString("lat");
            this.lng = document.getString("lng");
        }
    }

}
*/
