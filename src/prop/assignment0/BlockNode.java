package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class BlockNode implements INode {

    private Lexeme lexeme;
    private INode stmtsNode;

    public BlockNode() {

    }

    public BlockNode(Lexeme current) {
        lexeme = current;
    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return lexeme.value();
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("\nBlockNode");
        for (int i = 0; i < tabs; i++) {
            builder.append("    ");
        }
        builder.append(lexeme.token() + " " + lexeme.value());
    }

    public void setLexeme(Lexeme lexeme){
        this.lexeme = lexeme;
    }

    public void setStmtNode(INode stmtsNode){
        this.stmtsNode = stmtsNode;
    }
}
