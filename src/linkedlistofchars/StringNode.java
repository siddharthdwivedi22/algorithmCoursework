/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlistofchars;


/**
 *
 * @author Cos Ierotheou
 */
public class StringNode {
  // Instance variables:
  private String element;
  private StringNode next;
  /** Creates a node with null references to its element and next node. */
  public StringNode() {
    this("", null);
  }
  /** Creates a node with the given element and next node. */
  public StringNode(String e, StringNode n) {
    element = e;
    next = n;
  }
  // Accessor methods:
  public String getElement() {
    return element; 
  }
  public StringNode getNext() { 
    return next;
  }
  // Modifier methods:
  public void setElement(String newElem, int newAge) { 
    element = newElem + newAge; 
  }
  public void setNext(StringNode newNext) {
    next = newNext; 
  }
}

