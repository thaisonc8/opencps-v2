//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.28 at 11:53:08 AM ICT 
//


package org.opencps.api.serviceprocess.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessActionDataModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessActionDataModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="processActionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preStepCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postStepCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="autoEvent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preCondition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allowAssignUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assignUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assignUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestPayment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createDossierFiles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="returnDossierFiles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="makeBriefNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="syncActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rollbackable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessActionDataModel", propOrder = {
    "processActionId",
    "actionCode",
    "actionName",
    "preStepCode",
    "postStepCode",
    "autoEvent",
    "preCondition",
    "allowAssignUser",
    "assignUserId",
    "assignUserName",
    "requestPayment",
    "paymentFee",
    "createDossierFiles",
    "returnDossierFiles",
    "makeBriefNote",
    "syncActionCode",
    "rollbackable",
    "preStepName",
    "postStepName",
    "createDossierNo",
    "eSignature",
    "configNote"
})
public class ProcessActionDataModel {

    protected String processActionId;
    protected String actionCode;
    protected String actionName;
    protected String preStepCode;
    protected String preStepName;
    protected String postStepCode;
    protected String postStepName;
    protected String autoEvent;
    protected String preCondition;
    protected String allowAssignUser;
    protected String assignUserId;
    protected String assignUserName;
    protected String requestPayment;
    protected String paymentFee;
    protected List<String> createDossierFiles;
    protected List<String> returnDossierFiles;
    protected String makeBriefNote;
    protected String syncActionCode;
    protected String rollbackable;

    protected boolean createDossierNo;
    protected boolean eSignature;
    protected String configNote;

    public String getConfigNote() {
		return configNote;
	}

	public void setConfigNote(String configNote) {
		this.configNote = configNote;
	}

	public boolean isCreateDossierNo() {
		return createDossierNo;
	}

	public void setCreateDossierNo(boolean createDossierNo) {
		this.createDossierNo = createDossierNo;
	}

	public boolean iseSignature() {
		return eSignature;
	}

	public void seteSignature(boolean eSignature) {
		this.eSignature = eSignature;
	}

	public String getPreStepName() {
		return preStepName;
	}

	public void setPreStepName(String preStepName) {
		this.preStepName = preStepName;
	}

	public String getPostStepName() {
		return postStepName;
	}

	public void setPostStepName(String postStepName) {
		this.postStepName = postStepName;
	}

	/**
     * Gets the value of the processActionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessActionId() {
        return processActionId;
    }

    /**
     * Sets the value of the processActionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessActionId(String value) {
        this.processActionId = value;
    }

    /**
     * Gets the value of the actionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

    /**
     * Gets the value of the actionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * Sets the value of the actionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionName(String value) {
        this.actionName = value;
    }

    /**
     * Gets the value of the preStepCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreStepCode() {
        return preStepCode;
    }

    /**
     * Sets the value of the preStepCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreStepCode(String value) {
        this.preStepCode = value;
    }

    /**
     * Gets the value of the postStepCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostStepCode() {
        return postStepCode;
    }

    /**
     * Sets the value of the postStepCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostStepCode(String value) {
        this.postStepCode = value;
    }

    /**
     * Gets the value of the autoEvent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoEvent() {
        return autoEvent;
    }

    /**
     * Sets the value of the autoEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoEvent(String value) {
        this.autoEvent = value;
    }

    /**
     * Gets the value of the preCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreCondition() {
        return preCondition;
    }

    /**
     * Sets the value of the preCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreCondition(String value) {
        this.preCondition = value;
    }

    /**
     * Gets the value of the allowAssignUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowAssignUser() {
        return allowAssignUser;
    }

    /**
     * Sets the value of the allowAssignUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowAssignUser(String value) {
        this.allowAssignUser = value;
    }

    /**
     * Gets the value of the assignUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignUserId() {
        return assignUserId;
    }

    /**
     * Sets the value of the assignUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignUserId(String value) {
        this.assignUserId = value;
    }

    /**
     * Gets the value of the assignUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignUserName() {
        return assignUserName;
    }

    /**
     * Sets the value of the assignUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignUserName(String value) {
        this.assignUserName = value;
    }

    /**
     * Gets the value of the requestPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestPayment() {
        return requestPayment;
    }

    /**
     * Sets the value of the requestPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestPayment(String value) {
        this.requestPayment = value;
    }

    /**
     * Gets the value of the paymentFee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentFee() {
        return paymentFee;
    }

    /**
     * Sets the value of the paymentFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentFee(String value) {
        this.paymentFee = value;
    }

    /**
     * Gets the value of the createDossierFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the createDossierFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreateDossierFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCreateDossierFiles() {
        if (createDossierFiles == null) {
            createDossierFiles = new ArrayList<String>();
        }
        return this.createDossierFiles;
    }

    /**
     * Gets the value of the returnDossierFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnDossierFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnDossierFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReturnDossierFiles() {
        if (returnDossierFiles == null) {
            returnDossierFiles = new ArrayList<String>();
        }
        return this.returnDossierFiles;
    }

    /**
     * Gets the value of the makeBriefNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMakeBriefNote() {
        return makeBriefNote;
    }

    /**
     * Sets the value of the makeBriefNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMakeBriefNote(String value) {
        this.makeBriefNote = value;
    }

    /**
     * Gets the value of the syncActionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyncActionCode() {
        return syncActionCode;
    }

    /**
     * Sets the value of the syncActionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyncActionCode(String value) {
        this.syncActionCode = value;
    }

    /**
     * Gets the value of the rollbackable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRollbackable() {
        return rollbackable;
    }

    /**
     * Sets the value of the rollbackable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRollbackable(String value) {
        this.rollbackable = value;
    }

}
