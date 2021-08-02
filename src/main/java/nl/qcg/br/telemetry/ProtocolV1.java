/*
 *  ProtocolV1.java
 *
 *  Created on Jul 28, 2021 1:46:15 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry;

/**
 *
 * @author Simon IJskes
 */
public class ProtocolV1
{
    public static final int STX = 0x2;

    public static final int ETX = 0x3;

    public static final int DLE = 0x10;

    public static final int PANIC = 'P' ;

    public static final int REBOOT = 'R' ;

    public static final int VALUE = 'V' ;


}
