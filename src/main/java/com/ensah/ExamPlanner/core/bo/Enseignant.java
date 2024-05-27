package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("E")
public class Enseignant extends Personnel {

}
