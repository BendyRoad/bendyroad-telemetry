/*
 *  ConvertorTest.java
 *
 *  Created on Jul 28, 2021 4:20:15 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Simon IJskes
 */
public class ConvertorTest
{

    public ConvertorTest()
    {
    }

    @Test
    public void testConv01()
    {
        byte buf[] = { 0x1 } ;
        int v = Convertor.intConv( buf, 0, 1);
        assertEquals( 1, v );
    }

    @Test
    public void testUnsignedConv01()
    {
        byte buf[] = { 0x1 } ;
        int v = Convertor.uIntConv( buf, 0, 1);
        assertEquals( 1, v );
    }

    @Test
    public void testConvFF()
    {
        byte buf[] = { (byte)0xFF } ;
        int v = Convertor.intConv( buf, 0, 1);
        assertEquals( -1, v );
    }

    @Test
    public void testUnsignedConvFF()
    {
        byte buf[] = { (byte)0xFF } ;
        int v = Convertor.uIntConv( buf, 0, 1);
        assertEquals( 0xFF, v );
    }

    @Test
    public void testConv0100()
    {
        byte buf[] = { 0x00, 0x1 } ;
        int v = Convertor.intConv( buf, 0, 2);
        assertEquals( 0x100, v );
    }

    @Test
    public void testUnsignedConv0100()
    {
        byte buf[] = { 0x00, 0x1 } ;
        int v = Convertor.uIntConv( buf, 0, 2);
        assertEquals( 0x100, v );
    }

    @Test
    public void testConv0001()
    {
        byte buf[] = { 0x01, 0x0 } ;
        int v = Convertor.intConv( buf, 0, 2);
        assertEquals( 0x1, v );
    }

    @Test
    public void testConv00000001()
    {
        byte buf[] = { 0x01, 0x0, 0x0, 0x0 } ;
        int v = Convertor.intConv( buf, 0, 4);
        assertEquals( 0x1, v );
    }

    @Test
    public void testUnsignedConv00000001()
    {
        byte buf[] = { 0x01, 0x0, 0x0, 0x0 } ;
        int v = Convertor.intConv( buf, 0, 4);
        assertEquals( 0x1, v );
    }

    @Test
    public void testUnsignedConv00FF0000()
    {
        byte buf[] = { 0x00, 0x0, (byte)0xFF, 0x0 } ;
        int v = Convertor.uIntConv( buf, 0, 4);
        assertEquals( 0x00FF0000, v );
    }

    @Test
    public void testConv000000FF()
    {
        byte buf[] = { (byte)0xFF, 0x0, 0x0, 0x0 } ;
        int v = Convertor.intConv( buf, 0, 4);
        assertEquals( 0xFF, v );
    }

    @Test
    public void testConv01000000()
    {
        byte buf[] = { 0x0, 0x0, 0x0, 0x1 } ;
        int v = Convertor.intConv( buf, 0, 4);
        assertEquals( 0x01000000, v );
    }

    @Test
    public void testConvFF000000()
    {
        byte buf[] = { 0x0, 0x0, 0x0, (byte)0xFF } ;
        int v = Convertor.intConv( buf, 0, 4);
        assertEquals( 0xFF000000, v );
    }

    @Test
    public void testUnsignedConvFF000000()
    {
        byte buf[] = { 0x0, 0x0, 0x0, (byte)0xFF } ;
        int v = Convertor.uIntConv( buf, 0, 4);
        assertEquals( 0xFF000000, v );
    }
}
