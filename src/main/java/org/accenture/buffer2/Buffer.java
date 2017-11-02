package org.accenture.buffer2 ;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
  private Queue<Object> buffer ;
  private int capacity ;
  int num_put = 0 ;
  int num_get = 0 ;

  /**
   * Constructor
   * @param bufferSize
   */
  public Buffer(int bufferSize) {
    capacity = bufferSize ;
    buffer = new LinkedList<Object>() ;
  }

  public void put(Object element) {
      if (buffer.size() == capacity)
          System.exit(-1); ;

      System.out.println("Element inserted");

      buffer.add(element) ;
      num_put++ ;
  }

  public Object get() throws Exception {
    if (buffer.isEmpty()) 
        throw new BufferException("Buffer está vacío") ;

    Object value = buffer.remove() ;
  System.out.println("Element extracted");
    
  num_get++ ;
    return value ;
  }

  public int getNumberOfElements() {
    return buffer.size() ;
  }

  public int getNumberOfHoles() {
    return capacity - buffer.size() ;
  }

  public int getCapacity() {
    return capacity ;
  }
  
  public double getNumberOfOperations() {
      return num_put + num_get ;
  }
}