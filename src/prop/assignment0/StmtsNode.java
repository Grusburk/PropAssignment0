    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class StmtsNode implements INode {

    private INode assignNode, stmtsNode;

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {

    }

    public void setAssignNode(INode assignNode){
        this.assignNode = assignNode;
    }

    public void setStmtsNode(INode stmtsNode){
        this.stmtsNode = stmtsNode;
    }
}
