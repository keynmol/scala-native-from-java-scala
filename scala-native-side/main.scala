package myscalalib.impl

import scalanative.unsafe.*

object Implementations extends myscalalib.ExportedFunctions {
  import _root_.myscalalib.structs.*
  /**
   * [bindgen] header: interface.h
  */
  def myscalalib_complex(times : CInt, clamp : Ptr[myscalalib_struct], result : CString): Unit = 
    ()

  /**
   * [bindgen] header: interface.h
  */
  def myscalalib_exports(i : CInt, r : CInt): CInt = i + r
}
  
