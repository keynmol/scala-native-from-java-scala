package myscalalib

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object structs:
  import _root_.myscalalib.structs.*
  /**
   * [bindgen] header: interface.h
  */
  opaque type myscalalib_struct = CStruct2[CChar, CChar]
  object myscalalib_struct:
    given _tag: Tag[myscalalib_struct] = Tag.materializeCStruct2Tag[CChar, CChar]
    def apply()(using Zone): Ptr[myscalalib_struct] = scala.scalanative.unsafe.alloc[myscalalib_struct](1)
    def apply(a : CChar, b : CChar)(using Zone): Ptr[myscalalib_struct] = 
      val ____ptr = apply()
      (!____ptr).a = a
      (!____ptr).b = b
      ____ptr
    extension (struct: myscalalib_struct)
      def a : CChar = struct._1
      def a_=(value: CChar): Unit = !struct.at1 = value
      def b : CChar = struct._2
      def b_=(value: CChar): Unit = !struct.at2 = value

trait ExportedFunctions:
  import _root_.myscalalib.structs.*
  /**
   * [bindgen] header: interface.h
  */
  def myscalalib_complex(times : CInt, clamp : Ptr[myscalalib_struct], result : CString): Unit

  /**
   * [bindgen] header: interface.h
  */
  def myscalalib_exports(i : CInt, r : CInt): CInt


object functions extends ExportedFunctions:
  import _root_.myscalalib.structs.*
  /**
   * [bindgen] header: interface.h
  */
  @exported
  override def myscalalib_complex(times : CInt, clamp : Ptr[myscalalib_struct], result : CString): Unit = myscalalib.impl.Implementations.myscalalib_complex(times, clamp, result)

  /**
   * [bindgen] header: interface.h
  */
  @exported
  override def myscalalib_exports(i : CInt, r : CInt): CInt = myscalalib.impl.Implementations.myscalalib_exports(i, r)

object types:
  export _root_.myscalalib.structs.*

object all:
  export _root_.myscalalib.structs.myscalalib_struct