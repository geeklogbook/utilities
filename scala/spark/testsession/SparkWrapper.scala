package spark.testsession

import org.apache.spark.sql.SparkSession

trait SparkWrapper {

  val sparkSession =
    SparkSession
      .builder()
      .appName("scala-utilities")
      .master("local")
      .getOrCreate()

}
