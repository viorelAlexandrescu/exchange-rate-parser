package ro.avs.bnr.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Body {
    @JacksonXmlProperty(localName = "Subject")
    private String subject;

    @JacksonXmlProperty(localName = "OrigCurrency")
    private String originalCurrency;

    @JacksonXmlProperty(localName = "Cube")
    private Cube cube;
}
