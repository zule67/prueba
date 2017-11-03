package org.accenture.buffer2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class BufferTest {

  @Test
  public void shouldConstructorCreateABuffer() {
    int capacity = 4;
    Buffer<Double> buffer = new Buffer<>(capacity);

    assertNotNull(buffer);
    assertEquals(capacity, buffer.getCapacity());
    assertEquals(capacity, buffer.getNumberOfHoles());
    assertEquals(0, buffer.getNumberOfElements());
    assertEquals(0, buffer.getNumberOfOperations());

  }

  @Test(expected = BufferException.class)
  public void shouldAGetOnAnEmptyBufferRaiseAnException() {
    int capacity = 2;
    Buffer<Double> buffer = new Buffer<>(capacity);
    buffer.get();
  }

  @Test(expected = BufferException.class)
  public void shouldPutOnAFullBufferRaiseAnException() {
    int capacity = 2;
    Buffer<Double> buffer = new Buffer<>(capacity);
    buffer.put(2.0);
    buffer.put(3.0);
    buffer.put(4.0);
  }

  @Test
  public void shoulAPutOnEmptyBufferMakeTheBufferContainOneMoreElement() {
    int capacity = 2;
    Buffer<Double> buffer = new Buffer<>(capacity);

    buffer.put(4.0);
    int numberOfElements = buffer.getNumberOfElements();

    buffer.put(5.0);

    assertEquals(numberOfElements + 1, buffer.getNumberOfElements());
    assertEquals(0, buffer.getNumberOfHoles());
    assertEquals(capacity, buffer.getNumberOfElements());
  }

}
