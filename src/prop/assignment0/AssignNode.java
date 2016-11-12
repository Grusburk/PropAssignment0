    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class AssignNode implements INode {

    private INode childNode;
    private Lexeme lexemeId , lexemeOp; //, lexemeEnd;

    public AssignNode() {
    }

//    public AssignNode(Lexeme current) {
//        lexeme = current;
//    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return lexemeId.value();
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("AssignmentNode\n");
        tabs++;
        if (childNode != null){
            childNode.buildString(builder, tabs);
        }
//        rightNode.buildString(builder, tabs);
//        builder.append(lexeme.token() + " " + lexeme.value()  + "\n");
//        tabby(builder, tabs);
//        builder.append(leftNode+ "\n");
//        tabby(builder, tabs);
//        tabby(builder, tabs);
//        tabs++;
//        builder.append(rightNode.lexeme.token() + "" + leftNode.lexeme.lexeme());

//        builder.append(lexeme.token() + " " + lexeme.lexeme()+ "\n hejhej");


//        leftNode.buildString(builder, tabs);
//        tabs++;
//        builder.append(leftNode.lexeme);
//        tabs--;
//        rightNode.buildString(builder, tabs);
//        builder.append(rightNode.lexeme);
    }

    private void tabby(StringBuilder builder, int tabs) {
        for (int i = 0; i < tabs; i++) {
            builder.append("    ");
        }
    }

//    public INode getChild() {
//        return childNode;
//    }

    public void setChild(INode childNode) {
        this.childNode = childNode;
    }

//    public Lexeme getLexemeId() {
//        return lexemeId;
//    }

    public void setLexemeId(Lexeme lexeme) {
        this.lexemeId = lexeme;
    }

    public void setLexemeOp(Lexeme lexeme) {
        this.lexemeOp = lexeme;
    }

//    public void setLexemeEnd(Lexeme lexeme) {
//        this.lexemeEnd = lexeme;
//    }
}
