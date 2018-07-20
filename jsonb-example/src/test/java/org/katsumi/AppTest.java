package org.katsumi;

import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppTest
{
    /**
     * JavaオブジェクトをJSONに変換するテスト
     */
    @Test
    public void testToJson()
    {
        final Jsonb jsonb = JsonbBuilder.create();
        final String result = jsonb.toJson(new User("katsumi", 40));
        assertThat(result, is("{\"age\":40,\"name\":\"katsumi\"}"));
    }

    /**
     * JSONをJavaオブジェクトに変換するテスト
     */
    @Test
    public void testFromJson()
    {
        final Jsonb jsonb = JsonbBuilder.create();
        final String text = "{\"age\":40,\"name\":\"katsumi\"}";
        final User user = jsonb.fromJson(text, User.class);
        assertThat(user.getAge(), is(40));
        assertThat(user.getName(), is("katsumi"));
    }
}
