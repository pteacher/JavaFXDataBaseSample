package sample;

import java.lang.reflect.AnnotatedArrayType;

public class Authors {
    private String authorId;
    private String firstName;
    private String lastName;

    public Authors(String authorId, String firstName, String lastName) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Authors() {

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
