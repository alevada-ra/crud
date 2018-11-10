package dogsmanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "DOGS")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @NotNull
    @Size(min = 1, max = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOG_NAME", length = 100)
    private String dogName;

    @NotNull
    @Past(message = "Date of birth should be set in past")
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DOG_BIRTH")
    private Date dogBirth;

    @NotNull
    @Column(name = "DOG_HEIGHT")
    private float dogHeight;

    @NotNull
    @Column(name = "DOG_WEIGHT")
    private float dogWeight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public Date getDogBirth() {
        return dogBirth;
    }

    public void setDogBirth(Date dogBirth) {
        this.dogBirth = dogBirth;
    }

    public float getDogHeight() {
        return dogHeight;
    }

    public void setDogHeight(float dogHeight) {
        this.dogHeight = dogHeight;
    }

    public float getDogWeight() {
        return dogWeight;
    }

    public void setDogWeight(float dogWeight) {
        this.dogWeight = dogWeight;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", dogName='" + dogName + '\'' +
                ", dogBirth='" + dogBirth + '\'' +
                ", dogHeight=" + dogHeight +
                ", dogWeight=" + dogWeight +
                '}';
    }
}
