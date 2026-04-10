package fr.ensai.mediaplayer;

public class Artist {

    // Attributes
    private String firstName;
    private String lastName;
    private String nationality;

    public Artist(String firstName, String lastName, String nationality) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    public String toString() {

        return this.firstName.concat(this.lastName);

    }
}
