import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class SalesCombiner extends Reducer<Text, FloatWritable, Text, FloatWritable> {
    private FloatWritable partialSum = new FloatWritable();

    @Override
    protected void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        float sum = 0;
        for (FloatWritable value : values) {
            sum += value.get();
        }
        partialSum.set(sum);
        context.write(key, partialSum);
    }
}
