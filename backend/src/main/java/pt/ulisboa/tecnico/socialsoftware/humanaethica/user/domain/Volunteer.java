package pt.ulisboa.tecnico.socialsoftware.humanaethica.user.domain;

import jakarta.persistence.*;
import pt.ulisboa.tecnico.socialsoftware.humanaethica.auth.domain.AuthUser;
import pt.ulisboa.tecnico.socialsoftware.humanaethica.activity.domain.Activity;
import pt.ulisboa.tecnico.socialsoftware.humanaethica.assessment.domain.Assessment;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(User.UserTypes.VOLUNTEER)
public class Volunteer extends User {

    @OneToMany(mappedBy = "volunteer")
    private List<Assessment> assessments = new ArrayList<>();

    public Volunteer() {
    }

    public Volunteer(String name, String username, String email, AuthUser.Type type, State state) {
        super(name, username, email, Role.VOLUNTEER, type, state);
    }

    public Volunteer(String name, State state) {
        super(name, Role.VOLUNTEER, state);
    }

    public List<Assessment> getAssessments() {
        return this.assessments;
    }

    public void addAssessment(Assessment assessment) {
        this.assessments.add(assessment);
    }

}
