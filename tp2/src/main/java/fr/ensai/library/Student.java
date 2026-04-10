package fr.ensai.library;

import java.util.ArrayList;

/**
 * Represents a student
 * Attributes : name, age, and a list of notes.
 */
public class Student {
    // -------------------------------------------------------
    // Attributes
    // -------------------------------------------------------
    private String name;
    private int age;
    private ArrayList<Double> notes;

    /**
     * Constructs a new Student object with the given name and age.
     * 
     * @param name The name of the student.
     * @param age  The age of the student.
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.notes = new ArrayList<>(); // empty list
    }

    // -------------------------------------------------------
    // Getters and Setters (to access private attributes)
    // -------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the student.
     * 
     * @param age The age to set. It should be greater than zero.
     * @throws IllegalArgumentException if the provided age is not greater than
     *                                  zero.
     */
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero.");
        }
        this.age = age;
    }

    // -------------------------------------------------------
    // Methods
    // -------------------------------------------------------

    /**
     * @return A string representation of the Student object.
     */
    @Override
    public String toString() {
        return String.format("Student(name='%s', age=%d)", this.name, this.age);
    }

    /**
     * Adds a note to the student's list of notes.
     * 
     * @param note The note to be added.
     */
    public void addNote(double note) {
        this.notes.add(note);
    }

    /**
     * Computes the average note of the student.
     * 
     * @return The average note of the student.
     * @throws ArithmeticException if there are no notes present.
     */
    public double computeAverage() {
        if (this.notes.isEmpty()) {
            throw new ArithmeticException("Cannot compute average. No notes available.");
        }

        double sum = 0.0;
        for (double note : this.notes) {
            sum += note;
        }
        return sum / this.notes.size();
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        Student student = new Student("Eva", 20);
        student.addNote(17.5);
        student.addNote(12.0);
        student.addNote(20.0);

        System.out.println(student);
        System.out.println("Average Note: " + student.computeAverage());
    }
}