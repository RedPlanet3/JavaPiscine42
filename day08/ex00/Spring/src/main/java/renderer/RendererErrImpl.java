package renderer;

import preProcessor.PreProcessor;

public class RendererErrImpl implements Renderer{
    PreProcessor preProcessor;
    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String text) {
        System.err.println(this.preProcessor.print(text));
    }
}
