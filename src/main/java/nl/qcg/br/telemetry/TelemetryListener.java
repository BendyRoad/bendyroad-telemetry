/*
 *  TelemetryListener.java
 *
 *  Created on Jul 28, 2021 2:23:42 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

/**
 *
 * @author Simon IJskes
 */
public interface TelemetryListener
{

    public void onReboot();

    public void onUnknownPacket( byte[] buf, int off, int len );

    public void onPanic();

    public void onUnknownValue( int tagnum, byte[] buf, int off, int len );

    public void onBITvalue( String name, boolean v );

    public void onU8value( String name, int v );

    public void onS8value( String name, int v );

    public void onU16value( String name, int v );

    public void onS16value( String name, int v );

    public void onU32value( String name, long v );

    public void onS32value( String name, int v );

}
