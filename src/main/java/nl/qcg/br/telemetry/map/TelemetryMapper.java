/*
 *  TelemetryMapper.java
 *
 *  Created on Jul 28, 2021 2:46:39 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry.map;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXB;

/**
 *
 * @author Simon IJskes
 */
public class TelemetryMapper
{

    private final Map<Integer,TelemetryTag> tagMap = new HashMap<>();

    public void load( File f )
    {
        TelemetryMap tmap = JAXB.unmarshal( f, TelemetryMap.class );

        for( TelemetryTag tag : tmap.getTags() ) {
            tagMap.put( tag.getTag(), tag);
        }
    }

    public String getName( int tagnum )
    {
        TelemetryTag tag = tagMap.get( tagnum );
        if( tag == null ) {
            return null ;
        }
        return tag.getName();
    }

    public TelemetryTag getTag( int tagnum )
    {
        TelemetryTag tag = tagMap.get( tagnum );
        return tag ;
    }

}
