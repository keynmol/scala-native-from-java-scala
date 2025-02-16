//> using platform scala-native
//> using scala 3.6.3
//> using nativeVersion 0.5.6
//> using nativeTarget dynamic
//> using dep com.outr::scribe::3.16.0

package myscalalib.impl

import scalanative.unsafe.*
import myscalalib.all.*

object Implementations extends myscalalib.ExportedFunctions:

  def myscalalib_run(
      config: Ptr[myscalalib_config],
      left: Float,
      right: Float
  ): Float =
    val cfg = !config
    val label = fromCString(cfg.label)
    if cfg.op == myscalalib_operation.ADD then
      scribe.info(s"[$label] $left + $right = ${left + right}")
      left + right
    else if cfg.op == myscalalib_operation.MULTIPLY then
      scribe.info(s"[$label] $left * $right = ${left * right}")
      left * right
    else ???
