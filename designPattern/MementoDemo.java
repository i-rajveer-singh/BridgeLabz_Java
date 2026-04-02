package designpattern;

import java.util.Stack;

// 1. Originator
class TextEditor {

    private String content;

    public void write(String text) {
        content = text;
    }

    public String getContent() {
        return content;
    }

    public EditorMemento save() {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento) {
        content = memento.getState();
    }
}

// 2. Memento
class EditorMemento {

    private final String state;

    public EditorMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// 3. Caretaker
class HistoryManager {

    private Stack<EditorMemento> history = new Stack<>();

    public void save(EditorMemento memento) {
        history.push(memento);
    }

    public EditorMemento undo() {
        return history.pop();
    }
}

// 4. Main
public class MementoDemo {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        HistoryManager history = new HistoryManager();

        editor.write("Version 1");
        history.save(editor.save());

        editor.write("Version 2");
        history.save(editor.save());

        editor.restore(history.undo());
        System.out.println("Current Content: " + editor.getContent());
    }
}