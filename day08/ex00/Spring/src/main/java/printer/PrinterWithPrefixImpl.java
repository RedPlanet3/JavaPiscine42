package printer;

import renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithPrefixImpl implements Printer{
    Renderer renderer;
    String pref;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        this.pref = "Prefix ";
    }

    @Override
    public void setPrefix(String pref) {
        this.pref = pref;
    }

    @Override
    public void print(String text) {

        this.renderer.print(pref + " " + text);
    }
}
