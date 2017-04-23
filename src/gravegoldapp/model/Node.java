package gravegoldapp.model;

import gravegoldapp.until.Label.LABEL;
import gravegoldapp.until.Label;

/**
 * Each {@link Node} is part of Environment. Agent will find out that way to
 * catch gold in this Environment
 *
 * @author beepi
 */
public class Node {

    private Node mLeftNode;
    private Node mRightNode;
    private Node mUpperNode;
    private Node mBottomNode;
    private int mPosition;
    private LABEL mLabel;

    private Node mNode;

    public static Node createNode(int postion) {
        if (postion < 0 || postion > 15) {
            return null;
        }
        return new Node(postion);
    }

    private Node(int postion) {
        mPosition = postion;
        mLabel = LABEL.NULL;
    }

    public Node getLeftNode() {
        return mLeftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.mLeftNode = leftNode;
    }

    public Node getRightNode() {
        return mRightNode;
    }

    public void setRightNode(Node rightNode) {
        this.mRightNode = rightNode;
    }

    public Node getUpperNode() {
        return mUpperNode;
    }

    public void setUpperNode(Node upperNode) {
        this.mUpperNode = upperNode;
    }

    public Node getBottomNode() {
        return mBottomNode;
    }

    public void setBottomNode(Node mBottomNode) {
        this.mBottomNode = mBottomNode;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        this.mPosition = position;
    }

    public LABEL getLabel() {
        return mLabel;
    }

    public void setLabel(LABEL mLabel) {
        this.mLabel = mLabel;
    }

    public void tranmissionMsg(int postison) {

    }

}
