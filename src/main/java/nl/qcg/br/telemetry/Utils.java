/*
 *  Utils.java
 *
 *  Created on Jul 28, 2021 2:32:23 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

/**
 *
 * @author Simon IJskes
 */
public class Utils
{
//    public static String hexdump( byte[] buf, int len )
//    {
//        try {
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//
//            HexDump.dump( buf, len, os, 0 );
//
//            return new String( os.toByteArray(), Charset.forName( "ASCII") );
//
//        } catch (IOException | ArrayIndexOutOfBoundsException | IllegalArgumentException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

    public static String hexdump( byte[] buf, int len )
    {
        return hexdump( buf, 0, len );
    }

    public static String hexdump( byte[] buf, int off, int len )
    {
        StringBuilder sb = new StringBuilder();

        boolean first = true;
        for( int idx = 0; idx < len; idx++, off++ ) {
            if( first ) {
                first = false;
            } else {
                sb.append( ' ' );
            }
            sb.append( String.format( "%02x", buf[off] ) );
        }

        return sb.toString();

    }
}
