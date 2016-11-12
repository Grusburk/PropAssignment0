    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class AssignmentNode implements INode {

    private INode childNode;
    private Lexeme lexeme1, lexeme2, lexeme3;

    public AssignmentNode() {
    }

    public AssignmentNode(Lexeme current) {
        setLexeme(current);
    }


    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("AssignmentNode\n");
        tabs++;
//        if (childNode != null){
//            childNode.buildString(builder, tabs);
//        }
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

    public INode getChild() {
        return childNode;
    }

    public void setChild(INode childNode) {
        this.childNode = childNode;
    }

    public Lexeme getLexeme() {
        return lexeme1;
    }

    public void setLexeme(Lexeme lexeme) {
        if (lexeme1 == null){
            this.lexeme1 = lexeme;
        }else if (lexeme2 == null){
            this.lexeme2 = lexeme;
        }else{
            this.lexeme3 = lexeme;
        }
    }
}
