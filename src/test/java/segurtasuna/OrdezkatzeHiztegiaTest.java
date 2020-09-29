package segurtasuna;

import junit.framework.TestCase;

public class OrdezkatzeHiztegiaTest extends TestCase {
    OrdezkatzeHiztegia ordezkatzeHiztegia = null;

    public void setUp() throws Exception {
        super.setUp();
        ordezkatzeHiztegia = new OrdezkatzeHiztegia();
    }

    public void tearDown() throws Exception {
    }

    public void testZifratu() {
        assertEquals("BP MZTVB MBWWZWBJ ZGVB", ordezkatzeHiztegia.zifratu("EZ GAUDE GERRAREN ALDE"));
    }
    public void testDeszifratu() {

        assertEquals("EZ GAUDE GERRAREN ALDE",
                ordezkatzeHiztegia.deszifratu(
                        ordezkatzeHiztegia.zifratu("EZ GAUDE GERRAREN ALDE")));

    }
}