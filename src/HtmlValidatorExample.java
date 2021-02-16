
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class is used to see if the syntax of an html file is valid.
 */

/*
public class HtmlValidator {

    // default constructor
    private Queue<HtmlTag> tags;
    public HtmlValidator(){
        tags = new LinkedList<HtmlTag>();
    }

    // constructor to make a new queue of html tags
    public HtmlValidator(Queue<HtmlTag> tags){
        if(tags == null)
            throw new IllegalArgumentException();
        this.tags = tags;
    }


    // adds tag to the queue
    // has error message if the tag is empty
    public void addTag(HtmlTag tag){
        if(tag ==  null)
            throw new IllegalArgumentException();
        tags.add(tag);
    }

    // returns all the tags in the queue
    public Queue<HtmlTag> getTags(){
        return tags;
    }


    // removes all the tags that have the string "element"
    // throws IllegalArgumentException if the element is an null string
    public void removeAll(String element){
        if(element.equals(null) ) {
            throw new IllegalArgumentException();
        }
        if(!tags.isEmpty()){
            int size = tags.size();
            for(int i = 0; i < size; i++){
                HtmlTag t = tags.remove();
                if(!t.getElement().equals(element)){
                    tags.add(t);
                }
            }
        }
    }


    // method to check if the HTML file is valid.
    // calls helper methods printTag and copy
    public void validate() {
        Queue<HtmlTag> copy = copy(tags); // copy of the queue to not change the input for the HTML file
        Stack<HtmlTag> tagsStack = new Stack<HtmlTag>();
        int indent = 0;
        while ( !copy.isEmpty() ) {
            HtmlTag t = copy.remove();
            if ( !t.isOpenTag() ) {
                if ( !tagsStack.isEmpty() && t.matches(tagsStack.peek())) {
                    indent--;
                    printTag(indent,t); // print indentation and the tag
                    tagsStack.pop();
                } else {
                    System.out.println("ERROR unexpected tag: " + t);
                }
            } else {
                printTag(indent,t);
                if ( !t.isSelfClosing() ) {
                    tagsStack.add(t);
                    indent++;
                }
            }
        }

        // print if error for unclosed tag
        while ( !tagsStack.isEmpty() ) {
            HtmlTag tag = tagsStack.pop();
            System.out.println( "ERROR unclosed tag: " + tag );
        }
    }

    // helper method for validate
    // returns a copy of the Queue
    private Queue<HtmlTag> copy(Queue<HtmlTag> tags) {
        if ( tags != null ) {
            Queue<HtmlTag> copyQ = new LinkedList<HtmlTag>();
            int size = tags.size();
            for ( int i = 0; i < size; i++ ) {
                HtmlTag ht = tags.remove();
                copyQ.add(ht);
                tags.add(ht);
            }
            return copyQ;
        }
        return null;
    }

    // helper method for validate
    // print tags and indentation
    private void printTag(int num, HtmlTag tag) {
        for ( int i = 0; i < num; i++ ) {
            System.out.print("    ");
        }
        System.out.println(tag);
    }
}
*/