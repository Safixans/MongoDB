package springAdvanced.startingLesson.assignment.exeptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
    public StudentNotFoundException() {
        super();
    }
}
