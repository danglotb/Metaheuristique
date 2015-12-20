package util

import java.io._


object Logger {
  
  var writer : FileWriter = _
  
  def open(pathname : String) : Unit = writer = new FileWriter(pathname, true)
  
  def write(str : String) : Unit = writer.write(str)
  
  def close() : Unit = writer.close()
  
  def write(name: String, str: String): Unit = {
    Some(new java.io.PrintWriter(name)).foreach { p => p.write(str); p.close }
  }
  
}