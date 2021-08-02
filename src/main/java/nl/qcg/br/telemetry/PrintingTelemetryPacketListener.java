/*
 *  PrintingTelemetryPacketListener.java
 *
 *  Created on Jul 28, 2021 2:09:01 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

public class PrintingTelemetryPacketListener
    implements TelemetryPacketListener
{

    @Override
    public void packetReceived( byte[] buf, int len )
    {
        for( int i = 0; i < len; i++ ) {
            System.out.print( String.format( "%02x ", buf[i] & 0xFF ) );
        }
        System.out.println( "" );
    }

}
