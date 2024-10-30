Upload retail_data.csv to HDFS:
hadoop fs -mkdir /user/hadoop/retail_data
hadoop fs -put retail_data.csv /user/hadoop/retail_data/

Submit the MapReduce Job:
hadoop jar RetailStoreAnalytics.jar RetailSalesDriver /user/hadoop/retail_data /user/hadoop/output

Check Output:
Once the job completes, retrieve the output from HDFS:
hadoop fs -cat /user/hadoop/output/part-r-00000
