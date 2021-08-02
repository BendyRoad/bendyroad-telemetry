/*
 *  Convertor.java
 *
 *  Created on Jul 28, 2021 4:18:19 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

/**
 *
 * @author Simon IJskes
 */
public class Convertor
{

    public static int intConv( byte[] buf, int off, int len )
    {
        int accu = 0 ;
        int mult = 1 ;

        for(int i=1;i<len;i++,off++) { // (len-1)
           accu += ( buf[off] & 0xFF ) * mult ;
           mult <<= 8 ;
        }

        accu += buf[off] * mult ;

        return accu ;
    }

    public static int uIntConv( byte[] buf, int off, int len )
    {
        int accu = 0 ;
        int mult = 1 ;

        for(int i=0;i<len;i++,off++) {
           accu += ( buf[off] & 0xFF ) * mult ;
           mult <<= 8 ;
        }

        return accu ;
    }
}
