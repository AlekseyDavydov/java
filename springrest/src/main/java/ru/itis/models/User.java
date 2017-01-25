package ru.itis.models;

import java.util.List;

public class User{
    private int id;
    private String name;
    private int age;
    private List<Auto> auto;

    public User(int id, String name, int age, List<Auto> auto) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.auto = auto;
    }

    public User() {
    }

    public User(UserBuild userBuild) {
        this.id = userBuild.id;
        this.name = userBuild.name;
        this.age = userBuild.age;
        this.auto = userBuild.auto;


    }

    public static class UserBuild {
        private int id;
        private String name;
        private int age;
        private List<Auto> auto;

        public UserBuild id(int value) {
            this.id = value;
            return this;
        }


        public UserBuild name(String value) {
            this.name = value;
            return this;
        }

        public UserBuild age(int value) {
            this.age = value;
            return this;
        }

        public UserBuild auto(List<Auto> value) {
            this.auto = value;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
   // public void setMyAuto(List<Auto> cars){
   //     this.auto=auto;
    //}




    public String toString() {
        return id + " " + name + " " + age + " " + auto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Auto> getAuto() {
        return this.auto;
    }

    public void setAuto(List<Auto> auto) {
        this.auto = auto;
    }

    public void addAuto(Auto auto) {
        this.auto.add(auto);
    }

}
