/*
 *  TelemetryMap.java
 *
 *  Created on Jul 28, 2021 2:42:31 PM by Simon IJskes
 *
 */

package nl.qcg.br.telemetry.map;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Simon IJskes
 */
@XmlRootElement(name="telemetry-map")
public class TelemetryMap
{
    private List<TelemetryTag> tags = new ArrayList<>();

    @XmlElementRef
    @XmlElementWrapper(name = "tags")
    public List<TelemetryTag> getTags()
    {
        return tags;
    }

    public void setTags( List<TelemetryTag> tags )
    {
        this.tags = tags;
    }


}
