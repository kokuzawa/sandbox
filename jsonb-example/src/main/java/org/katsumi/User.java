package org.katsumi;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class User
{
    private final String name;
    private final int age;

    @JsonbCreator
    public User(
            @JsonbProperty("name") String name,
            @JsonbProperty("age") int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }
}
