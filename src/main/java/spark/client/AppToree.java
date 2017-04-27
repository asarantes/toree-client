

package spark.client;

import com.typesafe.config.ConfigFactory;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import com.typesafe.config.Config;

import org.apache.toree.kernel.protocol.v5.client.SparkKernelClient;
import org.apache.toree.kernel.protocol.v5.client.boot.ClientBootstrap;
import org.apache.toree.kernel.protocol.v5.client.boot.layers.StandardHandlerInitialization;
import org.apache.toree.kernel.protocol.v5.client.boot.layers.StandardSystemInitialization;
import org.apache.toree.kernel.protocol.v5.client.boot.layers.StandardSystemInitialization$class;
import org.apache.toree.kernel.protocol.v5.client.execution.DeferredExecution;
//import org.apache.toree.kernel.protocol.v5.content.{ExecuteReplyError, ExecuteReplyOk, ExecuteResult, StreamContent}
import org.apache.toree.kernel.protocol.v5.client.execution.DeferredExecution;
//import org.apache.toree.kernel.protocol.v5.content.{ExecuteReplyError, ExecuteReplyOk, ExecuteResult, StreamContent}



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 *
 * Usage: AppToree
 *
 * To run this example: 
 * 
 *  $SPARK_HOME/bin/spark-submit \
 *  --class com.spark.consumer.AppToree \
 *  ./.
 *  
 *  
 */

public final class AppToree
{



   public static void main(String[] args) throws IOException
   {

      // Check correct parameters


      // Create spark context with 5 second batch interval
      SparkConf sparkConf = new SparkConf().setAppName("AppToree");

      JavaSparkContext sc = new JavaSparkContext(sparkConf); // An existing JavaSparkContext.
      SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);



      // Config file
//      val profileJSON: String = """
//      {
//         "stdin_port":   48701,
//              "control_port": 48702,
//              "hb_port":      48705,
//              "shell_port":   48703,
//              "iopub_port":   48704,
//              "ip": "9.30.137.220",
//              "transport": "tcp",
//              "signature_scheme": "hmac-sha256",
//              "key": "",
//              "py4j_java":     25433,
//              "py4j_python":   25434
//      }
//      """.stripMargin




//      val configFileContent = scala.io.Source.fromFile(getConfigurationFilePath).mkString
//      if (log.isDebugEnabled()) {
//         log.debug(">>> Configuration in use " + configFileContent)
//      }
      //val config: Config = ConfigFactory.parseString(configFileContent)
      String path = "/Users/user/";
      String fileName=path + "profile.json";

      String configFileContent = new String(Files.readAllBytes(Paths.get(fileName)));

      Config config = ConfigFactory.parseString(configFileContent);



//      val client = (new ClientBootstrap(config)
//      with StandardSystemInitialization
//      with StandardHandlerInitialization).createClient()


      ClientBootstrap clientBootstrap = new ClientBootstrap(config);

      SparkKernelClient client = clientBootstrap.createClient();

      DeferredExecution exe = client.execute("1+1");


//      StandardSystemInitialization
//
//
//             val promise = Promise[String]
//      try {
//         val exRes: DeferredExecution = client.execute(code)
//                 .onResult(executeResult => {
//                 handleResult(promise, executeResult)
//         }).onError(executeReplyError =>{
//                 handleError(promise, executeReplyError)
//         }).onSuccess(executeReplyOk => {
//                 handleSuccess(promise, executeReplyOk)
//         }).onStream(streamResult => {
//                 handleStream(promise, streamResult)
//         })
//
//      } catch {
//      case t : Throwable => {
//         log.info("Error submitting request: " + t.getMessage, t)
//         promise.success("Error submitting request: " + t.getMessage)
//      }
//   }
//
//      Await.result(promise.future, Duration.Inf)
//
//   }
   }
   


}