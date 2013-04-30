
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class PRMapRed {
	
	public static class NodeMapClass extends MapReduceBase implements
		Mapper<IntWritable, BytesWritable, BytesWritable, BytesWritable>  {

		@Override
		public void map(IntWritable id, BytesWritable rawRecord,
				OutputCollector<BytesWritable, BytesWritable> output,
				Reporter reporter) throws IOException {
			// TODO Auto-generated method stub
			
		}
		
	}
}
