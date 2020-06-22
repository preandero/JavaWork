package com.lec.spring;

public class Student {

    String name;
    int age;
    Score score;

    public Student(){
        super();
        System.out.println("Student() 생성");
    }

    public Student(String name, int age, Score score) {
        super();
        System.out.printf("Student(%s, %d, %s) 생성\n", name, age, score.toString());
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score.toString() +
                '}';
    }
}
