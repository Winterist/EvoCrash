/*
 * Copyright (C) The Apache Software Foundation. All rights reserved.
 *
 * This software is published under the terms of the Apache Software License
 * version 1.1, a copy of which has been included  with this distribution in
 * the LICENSE.APL file.
 */

package org.apache.log4jb.helpers;

import java.io.File;
import java.io.Writer;

import org.apache.log4jb.spi.ErrorCode;
import org.apache.log4jb.spi.ErrorHandler;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;

/**
   Counts the number of bytes written.

   @author Heinz Richter, heinz.richter@frogdot.com
   @since 0.8.1

   */
public class CountingQuietWriter extends QuietWriter {

  protected long count;

  public
  CountingQuietWriter(Writer writer, ErrorHandler eh) {
    super(writer, eh);
  }
  
  public
  void write(String string) {
    try {
      out.write(string);
      count += string.length();
    }
    catch(IOException e) {
      errorHandler.error("Write failure.", e, ErrorCode.WRITE_FAILURE);
    }
  }

  public
  long getCount() {
    return count;
  }

  public
  void setCount(long count) {
    this.count = count;
  }
  
}
