/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.deployer.spi.yarn;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;

/**
 * This class holds an instance of {@link PrintStream} for each thread, the default being the
 * original System.out, with the option to set your own.
 */
class ThreadPrintStream extends PrintStream {

  private ThreadLocal<PrintStream> localPrintStream = new ThreadLocal<>();

  public ThreadPrintStream() {
    super(System.out);
  }

  public void setThreadStream(PrintStream printStream) {
    this.localPrintStream.set(printStream);
  }

  // The following are just overridden print methods that instead of doing super.foo() does
  // this.localPrintStream.get().foo() to get the thread's PrintStream.

  @Override
  public void close() {
    this.localPrintStream.get().close();
    this.localPrintStream.remove();
  }

  @Override
  public void print(boolean b) {
    this.localPrintStream.get().print(b);
  }

  @Override
  public void print(char c) {
    this.localPrintStream.get().print(c);
  }

  @Override
  public void print(int i) {
    this.localPrintStream.get().print(i);
  }

  @Override
  public void print(long l) {
    this.localPrintStream.get().print(l);
  }

  @Override
  public void print(float f) {
    this.localPrintStream.get().print(f);
  }

  @Override
  public void print(double d) {
    this.localPrintStream.get().print(d);
  }

  @Override
  public void print(char[] s) {
    this.localPrintStream.get().print(s);
  }

  @Override
  public void print(String s) {
    this.localPrintStream.get().print(s);
  }

  @Override
  public void print(Object obj) {
    this.localPrintStream.get().print(obj);
  }

  @Override
  public void println() {
    this.localPrintStream.get().println();
  }

  @Override
  public void println(boolean x) {
    this.localPrintStream.get().println(x);
  }

  @Override
  public void println(char x) {
    this.localPrintStream.get().println(x);
  }

  @Override
  public void println(int x) {
    this.localPrintStream.get().println(x);
  }

  @Override
  public void println(long x) {
    this.localPrintStream.get().println(x);
  }

  @Override
  public void println(float x) {
    this.localPrintStream.get().println(x);
  }

  @Override
  public void println(double x) {
    this.localPrintStream.get().println(x);
  }

  @Override
  public void println(char[] x) {
    this.localPrintStream.get().println(x);
  }

  @Override
  public void println(String x) {
    this.localPrintStream.get().println(x);
  }

  @Override
  public void println(Object x) {
    this.localPrintStream.get().println(x);
  }

  @Override
  public PrintStream printf(String format, Object... args) {
    return this.localPrintStream.get().printf(format, args);
  }

  @Override
  public PrintStream printf(Locale l, String format, Object... args) {
    return this.localPrintStream.get().printf(l, format, args);
  }

  @Override
  public PrintStream append(char c) {
    return this.localPrintStream.get().append(c);
  }

  @Override
  public PrintStream append(CharSequence csq) {
    return this.localPrintStream.get().append(csq);
  }

  @Override
  public PrintStream append(CharSequence csq, int start, int end) {
    return this.localPrintStream.get().append(csq, start, end);
  }

  @Override
  public void flush() {
    this.localPrintStream.get().flush();
  }

  @Override
  public void write(byte[] b) throws IOException {
    this.localPrintStream.get().write(b);
  }

  @Override
  public void write(byte[] buf, int off, int len) {
    this.localPrintStream.get().write(buf, off, len);
  }

  @Override
  public void write(int b) {
    this.localPrintStream.get().write(b);
  }

  @Override
  public boolean checkError() {
    return this.localPrintStream.get().checkError();
  }

  @Override
  public PrintStream format(Locale l, String format, Object... args) {
    return this.localPrintStream.get().format(l, format, args);
  }

  @Override
  public PrintStream format(String format, Object... args) {
    return this.localPrintStream.get().format(format, args);
  }

  @Override
  public boolean equals(Object arg0) {
    return this.localPrintStream.get().equals(arg0);
  }

  @Override
  public int hashCode() {
    return this.localPrintStream.get().hashCode();
  }

  @Override
  public String toString() {
    return this.localPrintStream.get().toString();
  }
}
