package com.ensah.ExamPlanner.core.bo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Administrateur extends Personnel {

}
