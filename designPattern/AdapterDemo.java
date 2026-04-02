package designpattern;

// 1. Old Class
class OldPrinter {
    public void oldPrint(String text) {
        System.out.println("Old Printer: " + text);
    }
}

// 2. New Interface
interface NewPrinter {
    void print(String text);
}

// 3. Adapter Class
class PrinterAdapter implements NewPrinter {

    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String text) {
        oldPrinter.oldPrint(text);
    }
}

// 4. Main Class
public class AdapterDemo {

    public static void main(String[] args) {

        OldPrinter oldPrinter = new OldPrinter();

        NewPrinter adapter = new PrinterAdapter(oldPrinter);
        adapter.print("Hello Adapter Pattern");
    }
}