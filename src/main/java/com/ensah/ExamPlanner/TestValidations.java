package com.ensah.ExamPlanner;

import jakarta.validation.constraints.NotBlank;

public class TestValidations {

    @NotBlank
    private String text;

    public static void main(String[] args) {
        TestValidations tv = new TestValidations();

        tv.setText(null);
        System.out.println(tv.getText());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
