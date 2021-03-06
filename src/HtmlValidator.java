import java.util.*;

public class HtmlValidator {
    private Queue<HtmlTag> tags;
    public HtmlValidator() {
        tags = new LinkedList<HtmlTag>();
    }
    public HtmlValidator(Queue<HtmlTag> tags){
        if(tags == null)
            throw new IllegalArgumentException();
        this.tags = tags;
    }

    public void addTag(HtmlTag tag) {
        if(tags == null)
            throw new IllegalArgumentException();
        tags.add(tag);
    }

    public Queue<HtmlTag> getTags(){
        return tags;
    }

    public void removeAll (String element) {
        Queue<HtmlTag> copy = copy(tags);
        while (!copy.isEmpty()) {
            HtmlTag t = copy.remove();
            if(t.getElement().equals(element)){
                tags.remove(t);
            }
        }
    }
    public void validate() {
        Queue<HtmlTag> copy = copy(tags);
        Stack<HtmlTag> tagsStack = new Stack<HtmlTag>();
        int indent = 0;
        while (!copy.isEmpty()) {
            HtmlTag t = copy.remove();
            if (t.isOpenTag() && !t.isSelfClosing()) {
                printTag(indent,t);
                tagsStack.push(t);
                indent++;
            } else if (t.isSelfClosing()) {
                printTag(indent, t);
            } else {
                indent--;
                printTag(indent, t);
                if (!t.matches(tagsStack.peek())) {
                    System.out.println("ERROR unexpected tag: " + t);
                } else {
                    tagsStack.pop();
                }
            }
        }
        while ( !tagsStack.isEmpty() ) {
            HtmlTag tag = tagsStack.pop();
            System.out.println( "ERROR unclosed tag: " + tag );
        }
    }

    private Queue<HtmlTag> copy(Queue<HtmlTag> tags) {
        Queue<HtmlTag> copyQ = new LinkedList<HtmlTag>();
        int size = tags.size();
        for ( int i = 0; i < size; i++ ) {
            HtmlTag ht = tags.remove();
            copyQ.add(ht);
            tags.add(ht);
        }
        return copyQ;
    }

    private void printTag(int num, HtmlTag tag) {
        for ( int i = 0; i < num; i++ ) {
            System.out.print("    ");
        }
        System.out.println(tag);
    }
}
