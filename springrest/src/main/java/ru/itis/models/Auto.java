package ru.itis.models;

public class Auto {
    private int id;
    private String model;
    private String color;
    private User user;

    public Auto() {
    }

    private Auto(AutoBuilder auto) {
        this.id = auto.id;
        this.model = auto.model;
        this.color = auto.color;
        this.user =  auto.user;
    }

    public static class AutoBuilder {
        private int id;
        private String model;
        private String color;
        private User user;

        public AutoBuilder id(int value) {
            this.id = value;
            return this;
        }

        public AutoBuilder model(String value) {
            this.model = value;
            return this;
        }

        public AutoBuilder color(String value) {
            this.color = value;
            return this;
        }

        public AutoBuilder user(User value) {
            this.user = value;
            return this;
        }

        public Auto build() {
            return new Auto(this);
        }


    }


    public String toString() {
        return id + " " + model + " " + color;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

