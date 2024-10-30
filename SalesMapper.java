import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class SalesMapper extends Mapper<Object, Text, Text, FloatWritable> {
    private Text productID = new Text();
    private FloatWritable saleAmount = new FloatWritable();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");
        if (fields.length == 5) {
            String productId = fields[0].trim();
            float amount = Float.parseFloat(fields[4].trim());
            productID.set(productId);
            saleAmount.set(amount);
            context.write(productID, saleAmount);
        }
    }
}
