
package com.wangx.webservice.webserviceCXFJaxws.serialization;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.tempuri package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RunData_QNAME = new QName("http://tempuri.org/", "data");
    private final static QName _RunResponseRunResult_QNAME = new QName("http://tempuri.org/", "RunResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RunResponse }
     */
    public RunResponse createRunResponse() {
        return new RunResponse();
    }

    /**
     * Create an instance of {@link Run }
     */
    public Run createRun() {
        return new Run();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "data", scope = Run.class)
    public JAXBElement<String> createRunData(String value) {
        return new JAXBElement<String>(_RunData_QNAME, String.class, Run.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RunResult", scope = RunResponse.class)
    public JAXBElement<String> createRunResponseRunResult(String value) {
        return new JAXBElement<String>(_RunResponseRunResult_QNAME, String.class, RunResponse.class, value);
    }

}
