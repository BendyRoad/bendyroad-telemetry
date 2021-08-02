/*
 *  TelemetryPacketListener.java
 *
 *  Created on Jul 28, 2021 1:30:56 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

/**
 *
 * @author Simon IJskes
 */
public interface TelemetryPacketListener
{

    void packetReceived( byte[] buf, int len );

}
