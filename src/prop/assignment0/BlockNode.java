package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class BlockNode implements INode {

    private Lexeme lexemeLeftCurly, lexemeRightCurly;
    private INode stmtsNode;

    /*
    Evaluator only works for program1.txt. Starts in AssignmentNode.
    */

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("BlockNode\n");
        builder.append(lexemeLeftCurly + "\n");
        tabs++;
        if (stmtsNode != null){
            stmtsNode.buildString(builder, tabs);
        }
        builder.append(lexemeRightCurly + "\n");
    }

    public void setLexemeLeftCurly(Lexeme lexemeLeftCurly) {
        this.lexemeLeftCurly = lexemeLeftCurly;
    }

    public void setLexemeRightCurly(Lexeme lexemeRightCurly) {
        this.lexemeRightCurly = lexemeRightCurly;
    }

    public void setStmtNode(INode stmtsNode){
        this.stmtsNode = stmtsNode;
    }
}
