/*
 *  SerialStateMachine.java
 *
 *  Created on Jul 28, 2021 1:30:32 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

/**
 *
 * @author Simon IJskes
 */
public class SerialStateMachine
{

    private byte[] buf;

    private int idx;

    private boolean escaped;

    private boolean sync;

    private TelemetryPacketListener listener;

    public void setListener( TelemetryPacketListener listener )
    {
        this.listener = listener;
    }

    public void onReceiveChar( byte ch )
    {
        if( escaped ) {
            switch( ch ) {
                case ProtocolV1.STX:
                    sync = true;
                    packetBegin();
                    break;
                case ProtocolV1.ETX:
                    if( sync ) {
                        packetEnd();
                    }
                    sync = false;
                    break;
                case ProtocolV1.DLE:
                    if( sync ) {
                        packetChar( ch );
                    }
                    break;
                default:
                    sync = false;
            }
            escaped = false;
            return;
        }

        if( ch == ProtocolV1.DLE ) {
            escaped = true;
            return;
        }

        if( sync ) {
            packetChar( ch );
        }
    }

    private void packetBegin()
    {
        idx = 0;
        buf = new byte[1000];
    }

    private void packetChar( byte ch )
    {
        if( idx >= buf.length ) {
            sync = false;
            return;
        }
        buf[idx] = ch;
        idx++;
    }

    private void packetEnd()
    {
        if( listener != null ) {
            listener.packetReceived( buf, idx );
        }
    }

}
