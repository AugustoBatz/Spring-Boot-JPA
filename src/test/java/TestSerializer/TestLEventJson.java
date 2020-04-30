/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.mytest.model.Event;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

/**
 *
 * @author augustobatz
 */
public class TestLEventJson {

    private JacksonTester<Event> json;

    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void testWriteJson() throws IOException {
        final Event event = new Event();
        event.setId(null);
        event.setDate(null);
        event.setLocations(null);
        event.setPlace("test");
        event.setName("test");
        assertThat(json.write(event)).isEqualToJson("event.json");
    }
    
    @Test
    public void testDeserialize() throws IOException {
        final Event event = new Event();
        event.setId(null);
        event.setDate(null);
        event.setLocations(null);
        event.setPlace("test");
        event.setName("test");
        final Event eventDes = json.readObject("event.json");
        assertThat(event)
                .isEqualTo(eventDes);
    }
}
