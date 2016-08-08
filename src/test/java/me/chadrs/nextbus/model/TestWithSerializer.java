package me.chadrs.nextbus.model;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import static org.junit.Assert.assertEquals;

/**
 * Base test incase we change how Persister is configured.
 */
abstract class TestWithSerializer {

    final public Serializer serializer = new Persister();

    public <T> void assertDeserialized(final String xml, final T expected, final Class<T> ref) throws Exception {
        assertEquals(serializer.read(ref, xml), expected);
    }
}
