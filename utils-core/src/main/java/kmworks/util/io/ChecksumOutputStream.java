/*BEGIN_COPYRIGHT_BLOCK*

PLT Utilities BSD License

Copyright (c) 2007-2010 JavaPLT group at Rice University
All rights reserved.

Developed by:   Java Programming Languages Team
                Rice University
                http://www.cs.rice.edu/~javaplt/

Redistribution and use in source and binary forms, with or without modification, are permitted 
provided that the following conditions are met:

    - Redistributions of source code must retain the above copyright notice, this list of conditions 
      and the following disclaimer.
    - Redistributions in binary form must reproduce the above copyright notice, this list of 
      conditions and the following disclaimer in the documentation and/or other materials provided 
      with the distribution.
    - Neither the name of the JavaPLT group, Rice University, nor the names of the library's 
      contributors may be used to endorse or promote products derived from this software without 
      specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR 
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND 
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS AND 
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*END_COPYRIGHT_BLOCK*/

package kmworks.util.io;

import java.util.zip.Checksum;
import java.util.zip.CRC32;
import java.util.zip.Adler32;

/** A stream that accumulates its bytes in a {@link Checksum} object. */
public class ChecksumOutputStream extends DirectOutputStream {
  private final Checksum _checksum;
  
  /**
   * Instantiate with the given Checksum.  {@code checksum} will not be reset, and
   * may contain a partially-computed value.
   */
  public ChecksumOutputStream(Checksum checksum) { _checksum = checksum; }
  
  /**
   * Return {@code checksum.getValue()}.  For 32-bit checksums, this can be cast to an int
   * without losing any information.
   */
  public long getValue() { return _checksum.getValue(); }
  
  @Override public void close() {}
  @Override public void flush() {}
  @Override public void write(byte[] bbuf) { _checksum.update(bbuf, 0, bbuf.length); }
  @Override public void write(byte[] bbuf, int offset, int len) { _checksum.update(bbuf, offset, len); }
  @Override public void write(int b) { _checksum.update(b); }
  
  /**
   * Create a stream for computing CRC-32 checksums.
   * @see CRC32
   */
  public static ChecksumOutputStream makeCRC32() {
    return new ChecksumOutputStream(new CRC32());
  }
  
  /**
   * Create a stream for computing Adler-32 checksums.
   * @see Adler32
   */
  public static ChecksumOutputStream makeAdler32() {
    return new ChecksumOutputStream(new Adler32());
  }
  
}
