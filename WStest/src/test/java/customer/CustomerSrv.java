
package customer;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CustomerSrv", targetNamespace = "http://Webservice.helman.com/", wsdlLocation = "http://localhost:8080/order/soap/customer?wsdl")
public class CustomerSrv
    extends Service
{

    private final static URL CUSTOMERSRV_WSDL_LOCATION;
    private final static WebServiceException CUSTOMERSRV_EXCEPTION;
    private final static QName CUSTOMERSRV_QNAME = new QName("http://Webservice.helman.com/", "CustomerSrv");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/order/soap/customer?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CUSTOMERSRV_WSDL_LOCATION = url;
        CUSTOMERSRV_EXCEPTION = e;
    }

    public CustomerSrv() {
        super(__getWsdlLocation(), CUSTOMERSRV_QNAME);
    }

    public CustomerSrv(WebServiceFeature... features) {
        super(__getWsdlLocation(), CUSTOMERSRV_QNAME, features);
    }

    public CustomerSrv(URL wsdlLocation) {
        super(wsdlLocation, CUSTOMERSRV_QNAME);
    }

    public CustomerSrv(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CUSTOMERSRV_QNAME, features);
    }

    public CustomerSrv(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerSrv(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CustomerInt
     */
    @WebEndpoint(name = "CustomerIntPort")
    public CustomerInt getCustomerIntPort() {
        return super.getPort(new QName("http://Webservice.helman.com/", "CustomerIntPort"), CustomerInt.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerInt
     */
    @WebEndpoint(name = "CustomerIntPort")
    public CustomerInt getCustomerIntPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Webservice.helman.com/", "CustomerIntPort"), CustomerInt.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CUSTOMERSRV_EXCEPTION!= null) {
            throw CUSTOMERSRV_EXCEPTION;
        }
        return CUSTOMERSRV_WSDL_LOCATION;
    }

}
