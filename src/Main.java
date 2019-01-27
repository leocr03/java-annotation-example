import com.leocr.example.Example;
import com.leocr.processor.GenerateValuesProcessor;
import com.leocr.processor.LogMetricProcessor;

public class Main {

    public static void main (String [] args) {
        LogMetricProcessor processor = new LogMetricProcessor();
        processor.process(Example.class);

        final Example example = new Example();
        example.sum(1, 3);
        example.multiply(2, 5);
        example.divide(6, 3);

        example.setIntValuesFrom("1-5");

        GenerateValuesProcessor generateValuesProcessor = new GenerateValuesProcessor();
        generateValuesProcessor.process(example);
    }
}
