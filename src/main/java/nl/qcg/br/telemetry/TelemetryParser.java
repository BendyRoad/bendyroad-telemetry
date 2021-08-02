/*
 *  TelemetryParser.java
 *
 *  Created on Jul 28, 2021 2:20:28 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

import java.util.logging.Logger;
import nl.qcg.br.telemetry.map.TelemetryMapper;
import nl.qcg.br.telemetry.map.TelemetryTag;

public class TelemetryParser
    implements TelemetryPacketListener
{

    private static final Logger LOG = Logger.getLogger( TelemetryParser.class.getName() );

    private TelemetryListener listener;

    private TelemetryMapper mapper;

    private boolean panic = false;

    public TelemetryParser()
    {
    }

    public TelemetryParser( TelemetryListener listener )
    {
        this.listener = listener;
    }

    public void setListener( TelemetryListener listener )
    {
        this.listener = listener;
    }

    public void setMapper( TelemetryMapper mapper )
    {
        this.mapper = mapper;
    }

    @Override
    public void packetReceived( byte[] buf, int len )
    {
        if( len < 1 ) {
            return;
        }

        final byte type = buf[0];

        if( type == ProtocolV1.PANIC ) {
            if( !panic ) {
                listener.onPanic();
                panic = true;
            }
            return;
        }

        panic = false;

        if( type == ProtocolV1.REBOOT ) {
            listener.onReboot();
            return;
        }

        if( type == ProtocolV1.VALUE ) {
            onValuePacket( buf, len );
            return;
        }

        listener.onUnknownPacket( buf, 0, len );
    }

    private void onValuePacket( byte[] buf, int len )
    {
        if( len < 4 ) {
            listener.onUnknownPacket( buf, 0, len );
            return;
        }

        int tagnum = Convertor.uIntConv( buf, 1, 2);

        TelemetryTag tag = mapper.getTag( tagnum );

        if( tag == null ) {
            listener.onUnknownValue( tagnum, buf, 3, len - 3 );
            return;
        }

        String name = tag.getName();

        //LOG.info( String.format("packet: %s %s %s", tag.getName(), tag.getType(), Utils.hexdump( buf, 3, len-3 )) );

        switch( tag.getType() ) {
            case BIT:
                if( len == 4 ) {
                    listener.onBITvalue( name, buf[3] != 0 );
                    return;
                }
                break;
            case U8:
                if( len == 4 ) {
                    listener.onU8value( name, Convertor.uIntConv( buf, 3, 1 ) );
                    return;
                }
                break;
            case S8:
                if( len == 4 ) {
                    listener.onS8value( name, Convertor.intConv( buf, 3, 1 ) );
                    return;
                }
                break;
            case U16:
                if( len == 5 ) {
                    listener.onU16value( name, Convertor.uIntConv( buf, 3, 2 ) );
                    return;
                }
                break;
            case S16:
                if( len == 5 ) {
                    listener.onS16value( name, Convertor.intConv( buf, 3, 2 ) );
                    return;
                }
                break;
            case U32:
                if( len == 7 ) {
                    listener.onU32value( name, Convertor.uIntConv( buf, 3, 4 ) & 0xFFFFFFFFL );
                    return;
                }
                break;
            case S32:
                if( len == 7 ) {
                    listener.onS32value( name, Convertor.intConv( buf, 3, 4 ) );
                    return;
                }
                break;
        }
        listener.onUnknownValue( tagnum, buf, 3, len - 3 );
    }

}
