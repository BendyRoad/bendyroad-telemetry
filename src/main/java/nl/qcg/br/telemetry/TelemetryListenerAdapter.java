/*
 *  TelemetryListenerAdapter.java
 *
 *  Created on Jul 28, 2021 3:04:55 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

public class TelemetryListenerAdapter
    implements TelemetryListener
{

    @Override
    public void onReboot()
    {
    }

    @Override
    public void onPanic()
    {
    }

    @Override
    public void onUnknownValue( int tagnum, byte[] buf, int off, int len )
    {
    }

    @Override
    public void onUnknownPacket( byte[] buf, int off, int len )
    {
    }

    @Override
    public void onBITvalue( String name, boolean v )
    {
    }

    @Override
    public void onU8value( String name, int v )
    {
    }

    @Override
    public void onS8value( String name, int v )
    {
    }

    @Override
    public void onU16value( String name, int v )
    {
    }

    @Override
    public void onS16value( String name, int v )
    {
    }

    @Override
    public void onU32value( String name, long v )
    {
    }

    @Override
    public void onS32value( String name, int v )
    {
    }


}
