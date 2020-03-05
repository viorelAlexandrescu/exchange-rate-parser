package ro.avs.bnr.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Header {
    @JacksonXmlProperty(localName = "Publisher")
    private String publisher;

    @JacksonXmlProperty(localName = "PublishingDate")
    private Date publishingDate;

    @JacksonXmlProperty(localName = "MessageType")
    private String messageType;
}
