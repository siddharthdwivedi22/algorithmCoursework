/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rootfindingmethods;


/**
 *
 * @author Cos Ierotheou
 */
public class DoubleNode {
  // Instance variables:
  private Double element;
  private DoubleNode next;
  /** Creates a node with null references to its element and next node. */
  public DoubleNode() {
    this(0.0, null);
  }
  /** Creates a node with the given element and next node. */
  public DoubleNode(Double e, DoubleNode n) {
    element = e;
    next = n;
  }
  // Accessor methods:
  public Double getElement() {
    return element; 
  }
  public DoubleNode getNext() { 
    return next;
  }
  // Modifier methods:
  public void setElement(Double newElem) { 
    element = newElem; 
  }
  public void setNext(DoubleNode newNext) {
    next = newNext; 
  }
}

