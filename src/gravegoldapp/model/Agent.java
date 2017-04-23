/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravegoldapp.model;

import gravegoldapp.until.Direction;
import java.util.List;
import gravegoldapp.until.Direction.Flag;

/**
 *
 * @author beepi
 */
public class Agent {
    
    private Arrow mArrow;
    private List<Node> mFootPrints;
    private Direction.Flag mFlag;
  
    public Arrow getArrow() {
        return mArrow;
    }

    public void setArrow(Arrow arrow) {
        this.mArrow = arrow;
    }

    public List<Node> getFootPrints() {
        return mFootPrints;
    }

    public void setFootPrints(List<Node> footPrints) {
        this.mFootPrints = footPrints;
    }

    public Flag getFlag() {
        return mFlag;
    }

    /**
     *
     * @param flag
     */
    public void setFlag(@Direction Flag flag) {
        this.mFlag = flag;
    }
    
}
