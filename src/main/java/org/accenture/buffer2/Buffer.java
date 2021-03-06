package org.accenture.buffer2;

import java.util.LinkedList;
import java.util.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Buffer<T> {
  private Queue<T> buffer;
  private int capacity;
  int numberOfPut = 0;
  int numberOfGet = 0;

  private static final Logger LOGGER = LogManager.getLogger(Buffer.class);
  
  /**
   * Constructor
   * 
   * @param bufferSize
   */
  public Buffer(int bufferSize) {
    capacity = bufferSize;
    buffer = new LinkedList<T>();
  }

  public void put(T element) throws BufferException {
    if (buffer.size() == capacity)
      throw new BufferException("Buffer está lleno");

    LOGGER.info("Element inserted");

    buffer.add(element);
    numberOfPut++;
  }

  public T get() throws BufferException {
    if (buffer.isEmpty())
      throw new BufferException("Buffer está vacío");

    T value = buffer.remove();
    LOGGER.info("Element extracted");

    numberOfGet++;
    return value;
  }

  public int getNumberOfElements() {
    return buffer.size();
  }

  public int getNumberOfHoles() {
    return capacity - buffer.size();
  }

  public int getCapacity() {
    return capacity;
  }

  public int getNumberOfOperations() {
    return (numberOfPut + numberOfGet);
  }
}
