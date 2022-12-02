package printer;

import renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer{
    Renderer renderer;
    String pref;
    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void setPrefix(String pref) {
        this.pref = pref;
    }

    @Override
    public void print(String text) {
        this.renderer.print(LocalDateTime.now().toLocalDate().toString() +
                " - " + LocalDateTime.now().toLocalTime().toString() +
                " - " + text);
    }
}
