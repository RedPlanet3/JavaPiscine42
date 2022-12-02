package renderer;

import preProcessor.PreProcessor;

public class RendererStandardImpl implements Renderer{
    PreProcessor preProcessor;
    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String text) {
        System.out.println(this.preProcessor.print(text));
    }
}
