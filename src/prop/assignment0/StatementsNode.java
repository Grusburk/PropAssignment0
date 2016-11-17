    package prop.assignment0;

    import java.util.ArrayList;

    /**
 * Created by matt on 2016-11-02.
 */
public class StatementsNode implements INode {

    private INode assignNode, stmtsNode;
        private ArrayList<String> results = new ArrayList<>();

        @Override
    public Object evaluate(Object[] args) throws Exception {
//        if (stmtsNode != null) {
//            results.add(assignNode.evaluate(args).toString());
//            stmtsNode.evaluate(args);
//        } else {
//            results.add(assignNode.evaluate(args).toString());
//        }
//        return results;
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        appendTab(builder, tabs);
        builder.append("StatementsNode\n");
        tabs++;
        if (assignNode != null){
            assignNode.buildString(builder, tabs);
        }
        if (stmtsNode != null){
            stmtsNode.buildString(builder, tabs);
        }
    }

    private void appendTab (StringBuilder builder, int tabs) {
        for(int i = 0; i < tabs; i++){
            builder.append("\t");
        }
    }

    public void setAssignNode(INode assignNode){
        this.assignNode = assignNode;
    }

    public void setStmtsNode(INode stmtsNode){
        this.stmtsNode = stmtsNode;
    }
}
