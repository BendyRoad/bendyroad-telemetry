/*
 *  TelemetryTag.java
 *
 *  Created on Jul 28, 2021 2:45:29 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry.map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Simon IJskes
 */
@XmlRootElement(name="telemetry-map")
public class TelemetryTag
{
    private int tag ;

    private String name ;

    private TelemetryTagType type ;

    @XmlAttribute(name="tag")
    public int getTag()
    {
        return tag;
    }

    public void setTag( int tag )
    {
        this.tag = tag;
    }

    @XmlAttribute(name="name")
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    @XmlAttribute(name="type")
    public TelemetryTagType getType()
    {
        return type;
    }

    public void setType( TelemetryTagType type )
    {
        this.type = type;
    }


}
