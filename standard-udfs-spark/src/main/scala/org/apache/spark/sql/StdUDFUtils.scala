package org.apache.spark.sql

import com.linkedin.stdudfs.spark.StdUdfWrapper
import org.apache.spark.sql.catalyst.FunctionIdentifier
import org.apache.spark.sql.catalyst.analysis.FunctionRegistry.FunctionBuilder
import org.apache.spark.sql.catalyst.expressions.Expression

import scala.util.{Failure, Success, Try}

object StdUDFUtils {

  private def functionBuilder[T <: StdUdfWrapper](stdUDFWrapperClass: Class[T]): FunctionBuilder = {
    (children: Seq[Expression]) => {
      Try(stdUDFWrapperClass.getDeclaredConstructor(classOf[Seq[Expression]]).newInstance(children)) match {
        case Success(exprObject) => exprObject.asInstanceOf[Expression]
        case Failure(e) => throw new IllegalStateException(e)
      }
    }
  }

  def register[T <: StdUdfWrapper](name: String, stdUDFWrapperClass: Class[T], sparkSession: SparkSession): Unit = {
    val registry = sparkSession.sessionState.functionRegistry
    registry.registerFunction(FunctionIdentifier(name), functionBuilder(stdUDFWrapperClass))
  }
}