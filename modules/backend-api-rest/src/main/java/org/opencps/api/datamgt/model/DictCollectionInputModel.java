//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.03 at 04:22:04 PM ICT 
//


package org.opencps.api.datamgt.model;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.liferay.portal.kernel.util.StringPool;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="collectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="collectionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="collectionNameEN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "collectionCode",
    "collectionName",
    "collectionNameEN",
    "description"
})
@XmlRootElement(name = "DictCollectionInputModel")
public class DictCollectionInputModel {

    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "collectionCode")
    protected String collectionCode;
    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "collectionName")
    protected String collectionName;
    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "collectionNameEN")
    protected String collectionNameEN;
    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "description")
    protected String description;

    /**
     * Gets the value of the collectionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionCode() {
        return collectionCode;
    }

    /**
     * Sets the value of the collectionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionCode(String value) {
        this.collectionCode = value;
    }

    /**
     * Gets the value of the collectionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * Sets the value of the collectionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionName(String value) {
        this.collectionName = value;
    }

    /**
     * Gets the value of the collectionNameEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionNameEN() {
        return collectionNameEN;
    }

    /**
     * Sets the value of the collectionNameEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionNameEN(String value) {
        this.collectionNameEN = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
