package ro.avs.bnr.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Cube")
public class Cube {
    @JacksonXmlProperty(isAttribute = true)
    private Date date;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Rate")
    private Rate[] rates;
}
