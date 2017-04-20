package gravegoldapp.model;

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
    private String mLabel;

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

    public String getmLabel() {
        return mLabel;
    }

    public void setmLabel(String mLabel) {
        this.mLabel = mLabel;
    }

}
