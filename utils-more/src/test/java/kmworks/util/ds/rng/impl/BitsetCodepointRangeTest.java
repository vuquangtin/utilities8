/*
 * Copyright (C) 2005-2016 Christian P. Lerch <christian.p.lerch[at]gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package kmworks.util.ds.rng.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;

import kmworks.util.ds.rng.CodepointRange;
import kmworks.util.ds.rng.CodepointRangeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Christian P. Lerch
 */
public class BitsetCodepointRangeTest {

    private BitsetCodepointRange.Builder randomBuilder(int setSize, int maxCodepoint) {
        final Random RANDOM = new Random();
        final BitsetCodepointRange.Builder builder = new BitsetCodepointRange.Builder();
        for (int j = 0; j < setSize; j++) {
            builder.add(RANDOM.nextInt(maxCodepoint));
        }
        return builder;
    }

    private void pln(String s) {
        System.out.println(s);
    }
    private void p(String s)  {
        System.out.print(s);
    }

    private void print(CodepointRange cps) {
        Writer w = new PrintWriter(System.out);
        pln("\nCodepointRange: " + cps.toString());
        try {
            CodepointRangeUtil.toText(cps, w, 10);
            w.flush();
        } catch (IOException e) {}
    }

    public BitsetCodepointRangeTest() {
    }

    @Test
    public void test() throws Exception {
        CodepointRange bs = BitsetCodepointRange.of(44, 50);
        assertTrue(!bs.contains(43));
        assertTrue(bs.contains(44));
        assertTrue(bs.contains(50));
        assertTrue(!bs.contains(51));
        assertTrue(bs.size() == 2);
    }

    @Test
    public void testSingularity() throws Exception {
        CodepointRange bs = new BitsetCodepointRange.Builder()
                .addRange(33000, 33000)
                .add(33000)
                .build();
        assertTrue(!bs.contains(32999));
        assertTrue(bs.contains(33000));
        assertTrue(!bs.contains(34));
        assertEquals(1, bs.size());
        //assertEquals(1, ((BitsetCodepointRange)bs).bucketsCount());
    }

    @Test
    public void testLoader() throws Exception {
        String initialBits = "  # uoöhef \n  30 -40  #p owr\n63\n\n128 #jnoö  wetä\n80-82";
        StringReader r = new StringReader(initialBits);
        CodepointRange bs = CodepointRangeUtil.fromText(r, 10);
        assertTrue(bs.size() == 16);
        assertTrue(bs.contains(30));
        assertTrue(bs.contains(40));
        assertTrue(bs.contains(63));
        assertTrue(bs.contains(80));
        assertTrue(bs.contains(128));
        assertTrue(!bs.contains(29));
        assertTrue(!bs.contains(41));
    }


    /*
     * Equality
     */
    @Test
    public void testNonEquals1() throws Exception {
        CodepointRange bs1 = new BitsetCodepointRange.Builder()
                .addRange(33000, 33000)
                .build();
        CodepointRange bs2 = new BitsetCodepointRange.Builder()
                .addRange(32950, 33050)
                .build();
        assertEquals(bs1.size(), 1);
        assertEquals(bs2.size(), 101);
        assertTrue(bs1.contains(33000));
        assertTrue(bs2.contains(33000));
        assertFalse(bs1.equals(bs2));
    }

    @Test
    public void testEquals() throws Exception {
        CodepointRange bs1 = new BitsetCodepointRange.Builder().addRange(5, 10).add(20).build();
        CodepointRange bs2 = new BitsetCodepointRange.Builder().addRange(5, 10).add(20).build();
        assertEquals(bs1, bs2);
        assertEquals(bs1.hashCode(), bs2.hashCode());
    }

    @Test
    public void testSetEquivalence() {
        final int maxCodepoint = 0xffff;
        final int iterations = 1000;

        for (int i = 0; i < iterations; i++) {
            final BitsetCodepointRange.Builder builder = randomBuilder(1000, maxCodepoint);
            final SortedSet<Integer> set = builder.getSet();
            final CodepointRange cps = builder.build();

            assertEquals(set.size(), cps.size());
            assertTrue(set.first() == cps.first());
            assertTrue(set.last() == cps.last());

            final Iterator<Integer> setIter = set.iterator();
            final Iterator<Integer> bsIter = cps.iterator();
            while (setIter.hasNext() && bsIter.hasNext()) {
                assertEquals(setIter.next(), bsIter.next());
            }
        }
    }
  
    /*
    @Test
    public void testEmptyEquals1() {
    CodepointRange bs1 = BitsetCodepointRange.of();
    CodepointRange bs2 = BitsetCodepointRange.of();
    assertTrue(bs1 == bs2);
    assertEquals(bs1, bs2);
    }

    @Test
    public void testEmptyEquals2() {
    CodepointRange bs1 = BitsetCodepointRange.of();
    CodepointRange bs2 = BitsetCodepointRange.of(1,2,3);
    CodepointRange bs3 = BitsetCodepointRange.of(4,5,6);
    CodepointRange bs4 = bs2.intersect(bs3);  // -> yields EMPTY
    assertTrue(bs1 == bs4);
    assertEquals(bs1, bs4);
    }
    */

    // Test Intersection
/*
    @Test
    public void testIntersect1() {
        CodepointRange bs1 = BitsetCodepointRange.fromRange(10, 50);
        CodepointRange bs2 = BitsetCodepointRange.fromRange(20, 60);

        assertEquals(bs1.size(), 41);
        assertEquals(bs1.size(), bs2.size());

        bs1 = bs1.intersect(bs2);

        assertEquals(bs1.size(), 31);
        assertTrue(bs1.contains(20));
        assertTrue(bs1.contains(50));
        assertTrue(!bs1.contains(19));
        assertTrue(!bs1.contains(51));
    }


    // Test Unions

    @Test
    public void testUnion1() throws Exception {
        // bs1 << bs2, no overlap
        CodepointRange bs1 = BitsetCodepointRange.of(20, 40);
        CodepointRange bs2 = BitsetCodepointRange.of(50, 70);
        bs1 = bs1.union(bs2);

        assertTrue(bs1.contains(20));
        assertTrue(bs1.contains(40));
        assertTrue(bs1.contains(50));
        assertTrue(bs1.contains(70));
        assertTrue(bs1.size() == 4);
        assertTrue(bs1.first() == 20);
        assertTrue(bs1.last() == 70);
    }

    @Test
    public void testUnion2() throws Exception {
        // bs1 >> bs2, no overlap
        CodepointRange bs1 = BitsetCodepointRange.of(50, 70);
        CodepointRange bs2 = BitsetCodepointRange.of(20, 40);
        bs1 = bs1.union(bs2);

        assertTrue(bs1.contains(20));
        assertTrue(bs1.contains(40));
        assertTrue(bs1.contains(50));
        assertTrue(bs1.contains(70));
        assertTrue(bs1.size() == 4);
        assertTrue(bs1.first() == 20);
        assertTrue(bs1.last() == 70);
    }
*/

    @Test
    public void testRandomEquals() {
        long start, ende;
        long equalsDuration = 0, hashDuration = 0, newDuration = 0, buildDuration = 0;
        final int ITERATIONS = 1000;
        final Random rand = new Random();

        for (int k = 1; k <= 10; k++) {
            int SET_SIZE = 100 * k;
            for (int i = 0; i < ITERATIONS; i++) {
                final BitsetCodepointRange.Builder builder1 = new BitsetCodepointRange.Builder();
                final BitsetCodepointRange.Builder builder2 = new BitsetCodepointRange.Builder();
                start = System.nanoTime();
                for (int j = 0; j < SET_SIZE; j++) {
                    int value = rand.nextInt(CodepointRange.CODEPOINT_MAX);
                    builder1.add(value);
                    builder2.add(value);
                }
                ende = System.nanoTime();
                buildDuration += (ende - start);

                start = System.nanoTime();
                final CodepointRange bs1 = builder1.build();
                final CodepointRange bs2 = builder2.build();
                ende = System.nanoTime();
                newDuration += (ende - start);

                start = System.nanoTime();
                final boolean isEqual = bs1.equals(bs2);
                ende = System.nanoTime();
                equalsDuration += (ende - start);
                if (!isEqual) {
                    pln(String.format("\ni=%d: CodepointSets NOT equal", i));
                    if (builder1.getSet().equals(builder2.getSet())) {
                        pln("... but underlying sorted sets ARE equal.");
                    } else {
                        pln("... and underlying sorted sets are different.");
                    }
                    for (int n : bs1) {
                        if (!bs2.contains(n)) {
                            pln(String.format("    %d from set #1 not contained in set #2", n));
                        }
                    }
                    for (int n : bs2) {
                        if (!bs1.contains(n)) {
                            pln(String.format("    %d from set #2 not contained in set #1", n));
                        }
                    }
                }
                assertTrue(isEqual);

                start = System.nanoTime();
                final int hash1 = bs1.hashCode();
                final int hash2 = bs2.hashCode();
                ende = System.nanoTime();
                hashDuration += (ende - start);
                assertEquals(hash1, hash2);
            }
            System.out.println(String.format("SetSize: %d -- build: %d msec  - create: %d msec  -  equals: %d msec  -  hash: %d msec",
                    SET_SIZE,
                    buildDuration / 1000 / ITERATIONS,
                    newDuration / 2000 / ITERATIONS,
                    equalsDuration / 1000 / ITERATIONS,
                    hashDuration / 2000 / ITERATIONS));
        }
    }

    @Test
    public void testRandomAccessPerformance() {
        long start, ende;

        start = System.currentTimeMillis();
        final BitsetCodepointRange.Builder builder = new BitsetCodepointRange.Builder();
        final int setsize = 100000;
        final Random rand = new Random();
        for (int i = 0; i < setsize; i++) {
            builder.add(rand.nextInt(CodepointRange.CODEPOINT_MAX));
        }
        CodepointRange bs = builder.build();
        ende = System.currentTimeMillis();
        System.out.println(String.format("Timing1: build a %d codepoints random bitset in %d msec", bs.size(), (ende - start)));

        final int lookups = 10000000;
        start = System.currentTimeMillis();
        for (int i = 0; i < lookups; i++) {
            bs.contains(rand.nextInt(CodepointRange.CODEPOINT_MAX));
        }
        ende = System.currentTimeMillis();
        System.out.println(String.format("Timing2: Do %d random lookups in %d msec (%d lookups /sec)"
                , lookups, (ende - start), 1000 * (lookups / (ende - start))));
    }

    @Test
    public void testIterator_1() {
        List<Integer> values = Arrays.asList(new Integer[]{1, 3, 6, 7, 10, 14, 15, 90});
        CodepointRange cps = BitsetCodepointRange.of(values);
        assertEquals(values.size(), cps.size());
        Iterator<Integer> listIter = values.iterator();
        Iterator<Integer> cpsIter = cps.iterator();
        while (cpsIter.hasNext()) {
            Integer cp = cpsIter.next();
            Integer val = listIter.next();
            assertEquals(cp, val);
            pln(cp.toString());
        }
    }

}