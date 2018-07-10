//
//This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Any modifications to this file will be lost upon recompilation of the source schema. 
//Generated on: 2017.12.16 at 03:30:29 PM ICT 
//


package org.opencps.api.dossieraction.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
* <p>Java class for DossierActionNextActionModel complex type.
* 
* <p>The following schema fragment specifies the expected content contained within this class.
* 
* <pre>
* &lt;complexType name="DossierActionNextActionModel">
*   &lt;complexContent>
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       &lt;sequence>
*         &lt;element name="processActionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
*         &lt;element name="actionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="actionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="preStepCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="postStepCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="autoEvent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="preCondition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="allowAssignUser" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
*         &lt;element name="assignUserId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
*         &lt;element name="toUsers" type="{}DossierActionNextActiontoUser" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element name="createFiles" type="{}DossierActionNextActioncreateFiles" maxOccurs="unbounded" minOccurs="0"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DossierActionPaymentModel", propOrder = {
"requestPayment",
"advanceAmount",
"feeAmount",
"serviceAmount",
"shipAmount",
"editable"
})
public class DossierActionPaymentModel {

	protected Integer requestPayment;
	protected Long advanceAmount;
	protected Long feeAmount;
	protected Long serviceAmount;
	protected Long shipAmount;
	protected Boolean editable;

	public Integer getRequestPayment() {
		return requestPayment;
	}
	public void setRequestPayment(Integer requestPayment) {
		this.requestPayment = requestPayment;
	}
	public Long getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(Long advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	public Long getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(Long feeAmount) {
		this.feeAmount = feeAmount;
	}
	public Long getServiceAmount() {
		return serviceAmount;
	}
	public void setServiceAmount(Long serviceAmount) {
		this.serviceAmount = serviceAmount;
	}
	public Long getShipAmount() {
		return shipAmount;
	}
	public void setShipAmount(Long shipAmount) {
		this.shipAmount = shipAmount;
	}
	public Boolean getEditable() {
		return editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

}
