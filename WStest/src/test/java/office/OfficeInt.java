
package office;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OfficeInt", targetNamespace = "http://Webservice.helman.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OfficeInt {


    /**
     * 
     * @return
     *     returns office.OfficeArray
     */
    @WebMethod
    @WebResult(name = "Offices", partName = "Offices")
    @Action(input = "http://Webservice.helman.com/OfficeInt/findallRequest", output = "http://Webservice.helman.com/OfficeInt/findallResponse")
    public OfficeArray findall();

    /**
     * 
     * @param officeCode
     * @return
     *     returns office.Office
     */
    @WebMethod
    @WebResult(name = "Office", partName = "Office")
    @Action(input = "http://Webservice.helman.com/OfficeInt/findbyidRequest", output = "http://Webservice.helman.com/OfficeInt/findbyidResponse")
    public Office findbyid(
        @WebParam(name = "officeCode", partName = "officeCode")
        String officeCode);

    /**
     * 
     * @param office
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "returnStatus", partName = "returnStatus")
    @Action(input = "http://Webservice.helman.com/OfficeInt/updateRequest", output = "http://Webservice.helman.com/OfficeInt/updateResponse")
    public String update(
        @WebParam(name = "Office", partName = "Office")
        Office office);

    /**
     * 
     * @param officeCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "returnStatus", partName = "returnStatus")
    @Action(input = "http://Webservice.helman.com/OfficeInt/deleteRequest", output = "http://Webservice.helman.com/OfficeInt/deleteResponse")
    public String delete(
        @WebParam(name = "officeCode", partName = "officeCode")
        String officeCode);

    /**
     * 
     * @param office
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "returnStatus", partName = "returnStatus")
    @Action(input = "http://Webservice.helman.com/OfficeInt/insertRequest", output = "http://Webservice.helman.com/OfficeInt/insertResponse")
    public String insert(
        @WebParam(name = "Office", partName = "Office")
        Office office);

}
