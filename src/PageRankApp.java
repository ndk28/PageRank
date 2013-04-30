
import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RunningJob;
import org.apache.hadoop.mapred.SequenceFileInputFormat;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;

//import PRMapRed.MapClass;
//import PRMapRed.ReduceClass;

public class PageRankApp {


	public static void main(String[] args) {
		String refpath = "http://edu-cornell-cs-cs5300s13-ndk28.s3.amazonaws.com/new-edges.txt";
		JobConf conf = new JobConf(PRMapRed.class);
		conf.setJobName("PageRank");
		conf.set("refpath", refpath);
		FileInputFormat.addInputPath(conf, new Path(refpath));
		
		conf.setMapperClass(PRMapRed.NodeMapClass.class);
		
		conf.setInputFormat(SequenceFileInputFormat.class);			
		conf.setMapOutputKeyClass(BytesWritable.class);
		conf.setMapOutputValueClass(BytesWritable.class);
		
		conf.setReducerClass(PRMapRed.NodeReduceClass.class);		
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(BytesWritable.class);
		conf.setOutputFormat(SequenceFileOutputFormat.class);
		
		Path oPath = new Path("http://edu-cornell-cs-cs5300s13-ndk28.s3.amazonaws.com/output.txt");
		FileOutputFormat.setOutputPath(conf, oPath);
		
		System.err.println("  Removing old results");
		FileSystem.get(conf).delete(oPath);
		
		RunningJob rj = JobClient.runJob(conf);
		System.err.println("CloudBurst Finished");
		

	}

}
