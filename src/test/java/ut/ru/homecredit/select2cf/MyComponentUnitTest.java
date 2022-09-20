package ut.ru.homecredit.select2cf;

import org.junit.Test;
import ru.homecredit.select2cf.api.MyPluginComponent;
import ru.homecredit.select2cf.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}
