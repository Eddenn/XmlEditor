//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.04.17 à 10:55:12 AM CEST 
//


package app.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identite">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nom" type="{http://univ.fr/cvi}upperLetters"/>
 *                   &lt;element name="prenom" type="{http://univ.fr/cvi}upperAndLowersLetters"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="objectif">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="stage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                     &lt;element name="emploi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="prof" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="expe" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="datedeb" type="{http://univ.fr/cvi}dateTimeFormat"/>
 *                             &lt;element name="datefin" type="{http://univ.fr/cvi}dateTimeFormat" minOccurs="0"/>
 *                             &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="competences">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="diplome" maxOccurs="5">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="date" type="{http://univ.fr/cvi}dateTimeFormat"/>
 *                             &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="institut" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="niveau" use="required" type="{http://univ.fr/cvi}niveauDiplome" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="certif" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="datedeb" type="{http://univ.fr/cvi}dateTimeFormat"/>
 *                             &lt;element name="datefin" type="{http://univ.fr/cvi}dateTimeFormat" minOccurs="0"/>
 *                             &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="lv" maxOccurs="5">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="iso" use="required" type="{http://univ.fr/cvi}langues" />
 *                           &lt;attribute name="cert" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="nivs" type="{http://univ.fr/cvi}niveauCertif" />
 *                           &lt;attribute name="nivi" type="{http://univ.fr/cvi}valeurToeic" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="info">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="langage" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="niveau" type="{http://univ.fr/cvi}niveauInfo"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="divers" maxOccurs="5" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "identite",
    "objectif",
    "prof",
    "competences",
    "divers"
})
@XmlRootElement(name = "cvi")
public class Cvi {

    @XmlElement(required = true)
    protected Cvi.Identite identite;
    @XmlElement(required = true)
    protected Cvi.Objectif objectif;
    protected Cvi.Prof prof;
    @XmlElement(required = true)
    protected Cvi.Competences competences;
    protected List<Cvi.Divers> divers;

    /**
     * Obtient la valeur de la propriété identite.
     * 
     * @return
     *     possible object is
     *     {@link Cvi.Identite }
     *     
     */
    public Cvi.Identite getIdentite() {
        return identite;
    }

    /**
     * Définit la valeur de la propriété identite.
     * 
     * @param value
     *     allowed object is
     *     {@link Cvi.Identite }
     *     
     */
    public void setIdentite(Cvi.Identite value) {
        this.identite = value;
    }

    /**
     * Obtient la valeur de la propriété objectif.
     * 
     * @return
     *     possible object is
     *     {@link Cvi.Objectif }
     *     
     */
    public Cvi.Objectif getObjectif() {
        return objectif;
    }

    /**
     * Définit la valeur de la propriété objectif.
     * 
     * @param value
     *     allowed object is
     *     {@link Cvi.Objectif }
     *     
     */
    public void setObjectif(Cvi.Objectif value) {
        this.objectif = value;
    }

    /**
     * Obtient la valeur de la propriété prof.
     * 
     * @return
     *     possible object is
     *     {@link Cvi.Prof }
     *     
     */
    public Cvi.Prof getProf() {
        return prof;
    }

    /**
     * Définit la valeur de la propriété prof.
     * 
     * @param value
     *     allowed object is
     *     {@link Cvi.Prof }
     *     
     */
    public void setProf(Cvi.Prof value) {
        this.prof = value;
    }

    /**
     * Obtient la valeur de la propriété competences.
     * 
     * @return
     *     possible object is
     *     {@link Cvi.Competences }
     *     
     */
    public Cvi.Competences getCompetences() {
        return competences;
    }

    /**
     * Définit la valeur de la propriété competences.
     * 
     * @param value
     *     allowed object is
     *     {@link Cvi.Competences }
     *     
     */
    public void setCompetences(Cvi.Competences value) {
        this.competences = value;
    }

    /**
     * Gets the value of the divers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the divers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDivers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cvi.Divers }
     * 
     * 
     */
    public List<Cvi.Divers> getDivers() {
        if (divers == null) {
            divers = new ArrayList<Cvi.Divers>();
        }
        return this.divers;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="diplome" maxOccurs="5">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="date" type="{http://univ.fr/cvi}dateTimeFormat"/>
     *                   &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="institut" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="niveau" use="required" type="{http://univ.fr/cvi}niveauDiplome" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="certif" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="datedeb" type="{http://univ.fr/cvi}dateTimeFormat"/>
     *                   &lt;element name="datefin" type="{http://univ.fr/cvi}dateTimeFormat" minOccurs="0"/>
     *                   &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="lv" maxOccurs="5">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="iso" use="required" type="{http://univ.fr/cvi}langues" />
     *                 &lt;attribute name="cert" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="nivs" type="{http://univ.fr/cvi}niveauCertif" />
     *                 &lt;attribute name="nivi" type="{http://univ.fr/cvi}valeurToeic" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="info">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="langage" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="niveau" type="{http://univ.fr/cvi}niveauInfo"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "diplome",
        "certif",
        "lv",
        "info"
    })
    public static class Competences {

        @XmlElement(required = true)
        protected List<Cvi.Competences.Diplome> diplome;
        protected List<Cvi.Competences.Certif> certif;
        @XmlElement(required = true)
        protected List<Cvi.Competences.Lv> lv;
        @XmlElement(required = true)
        protected Cvi.Competences.Info info;

        /**
         * Gets the value of the diplome property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the diplome property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDiplome().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Cvi.Competences.Diplome }
         * 
         * 
         */
        public List<Cvi.Competences.Diplome> getDiplome() {
            if (diplome == null) {
                diplome = new ArrayList<Cvi.Competences.Diplome>();
            }
            return this.diplome;
        }

        /**
         * Gets the value of the certif property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the certif property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCertif().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Cvi.Competences.Certif }
         * 
         * 
         */
        public List<Cvi.Competences.Certif> getCertif() {
            if (certif == null) {
                certif = new ArrayList<Cvi.Competences.Certif>();
            }
            return this.certif;
        }

        /**
         * Gets the value of the lv property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lv property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLv().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Cvi.Competences.Lv }
         * 
         * 
         */
        public List<Cvi.Competences.Lv> getLv() {
            if (lv == null) {
                lv = new ArrayList<Cvi.Competences.Lv>();
            }
            return this.lv;
        }

        /**
         * Obtient la valeur de la propriété info.
         * 
         * @return
         *     possible object is
         *     {@link Cvi.Competences.Info }
         *     
         */
        public Cvi.Competences.Info getInfo() {
            return info;
        }

        /**
         * Définit la valeur de la propriété info.
         * 
         * @param value
         *     allowed object is
         *     {@link Cvi.Competences.Info }
         *     
         */
        public void setInfo(Cvi.Competences.Info value) {
            this.info = value;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="datedeb" type="{http://univ.fr/cvi}dateTimeFormat"/>
         *         &lt;element name="datefin" type="{http://univ.fr/cvi}dateTimeFormat" minOccurs="0"/>
         *         &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "datedeb",
            "datefin",
            "descript"
        })
        public static class Certif {

            @XmlElement(required = true)
            protected String datedeb;
            protected String datefin;
            @XmlElement(required = true)
            protected String descript;

            /**
             * Obtient la valeur de la propriété datedeb.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatedeb() {
                return datedeb;
            }

            /**
             * Définit la valeur de la propriété datedeb.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatedeb(String value) {
                this.datedeb = value;
            }

            /**
             * Obtient la valeur de la propriété datefin.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatefin() {
                return datefin;
            }

            /**
             * Définit la valeur de la propriété datefin.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatefin(String value) {
                this.datefin = value;
            }

            /**
             * Obtient la valeur de la propriété descript.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescript() {
                return descript;
            }

            /**
             * Définit la valeur de la propriété descript.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescript(String value) {
                this.descript = value;
            }

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="date" type="{http://univ.fr/cvi}dateTimeFormat"/>
         *         &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="institut" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="niveau" use="required" type="{http://univ.fr/cvi}niveauDiplome" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "date",
            "descript",
            "institut"
        })
        public static class Diplome {

            @XmlElement(required = true)
            protected String date;
            @XmlElement(required = true)
            protected String descript;
            @XmlElement(required = true)
            protected String institut;
            @XmlAttribute(name = "niveau", required = true)
            protected NiveauDiplome niveau;

            /**
             * Obtient la valeur de la propriété date.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDate() {
                return date;
            }

            /**
             * Définit la valeur de la propriété date.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDate(String value) {
                this.date = value;
            }

            /**
             * Obtient la valeur de la propriété descript.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescript() {
                return descript;
            }

            /**
             * Définit la valeur de la propriété descript.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescript(String value) {
                this.descript = value;
            }

            /**
             * Obtient la valeur de la propriété institut.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInstitut() {
                return institut;
            }

            /**
             * Définit la valeur de la propriété institut.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInstitut(String value) {
                this.institut = value;
            }

            /**
             * Obtient la valeur de la propriété niveau.
             * 
             * @return
             *     possible object is
             *     {@link NiveauDiplome }
             *     
             */
            public NiveauDiplome getNiveau() {
                return niveau;
            }

            /**
             * Définit la valeur de la propriété niveau.
             * 
             * @param value
             *     allowed object is
             *     {@link NiveauDiplome }
             *     
             */
            public void setNiveau(NiveauDiplome value) {
                this.niveau = value;
            }

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="langage" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="niveau" type="{http://univ.fr/cvi}niveauInfo"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "langage"
        })
        public static class Info {

            @XmlElement(required = true)
            protected List<Cvi.Competences.Info.Langage> langage;

            /**
             * Gets the value of the langage property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the langage property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLangage().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Cvi.Competences.Info.Langage }
             * 
             * 
             */
            public List<Cvi.Competences.Info.Langage> getLangage() {
                if (langage == null) {
                    langage = new ArrayList<Cvi.Competences.Info.Langage>();
                }
                return this.langage;
            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="niveau" type="{http://univ.fr/cvi}niveauInfo"/>
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
                "nom",
                "niveau"
            })
            public static class Langage {

                @XmlElement(required = true)
                protected String nom;
                protected int niveau;

                /**
                 * Obtient la valeur de la propriété nom.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNom() {
                    return nom;
                }

                /**
                 * Définit la valeur de la propriété nom.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNom(String value) {
                    this.nom = value;
                }

                /**
                 * Obtient la valeur de la propriété niveau.
                 * 
                 */
                public int getNiveau() {
                    return niveau;
                }

                /**
                 * Définit la valeur de la propriété niveau.
                 * 
                 */
                public void setNiveau(int value) {
                    this.niveau = value;
                }

            }

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="iso" use="required" type="{http://univ.fr/cvi}langues" />
         *       &lt;attribute name="cert" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="nivs" type="{http://univ.fr/cvi}niveauCertif" />
         *       &lt;attribute name="nivi" type="{http://univ.fr/cvi}valeurToeic" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Lv {

            @XmlAttribute(name = "iso", required = true)
            protected Langues iso;
            @XmlAttribute(name = "cert", required = true)
            protected String cert;
            @XmlAttribute(name = "nivs")
            protected NiveauCertif nivs;
            @XmlAttribute(name = "nivi")
            protected Integer nivi;

            /**
             * Obtient la valeur de la propriété iso.
             * 
             * @return
             *     possible object is
             *     {@link Langues }
             *     
             */
            public Langues getIso() {
                return iso;
            }

            /**
             * Définit la valeur de la propriété iso.
             * 
             * @param value
             *     allowed object is
             *     {@link Langues }
             *     
             */
            public void setIso(Langues value) {
                this.iso = value;
            }

            /**
             * Obtient la valeur de la propriété cert.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCert() {
                return cert;
            }

            /**
             * Définit la valeur de la propriété cert.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCert(String value) {
                this.cert = value;
            }

            /**
             * Obtient la valeur de la propriété nivs.
             * 
             * @return
             *     possible object is
             *     {@link NiveauCertif }
             *     
             */
            public NiveauCertif getNivs() {
                return nivs;
            }

            /**
             * Définit la valeur de la propriété nivs.
             * 
             * @param value
             *     allowed object is
             *     {@link NiveauCertif }
             *     
             */
            public void setNivs(NiveauCertif value) {
                this.nivs = value;
            }

            /**
             * Obtient la valeur de la propriété nivi.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getNivi() {
                return nivi;
            }

            /**
             * Définit la valeur de la propriété nivi.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setNivi(Integer value) {
                this.nivi = value;
            }

        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "descript"
    })
    public static class Divers {

        @XmlElement(required = true)
        protected String descript;

        /**
         * Obtient la valeur de la propriété descript.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescript() {
            return descript;
        }

        /**
         * Définit la valeur de la propriété descript.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescript(String value) {
            this.descript = value;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="nom" type="{http://univ.fr/cvi}upperLetters"/>
     *         &lt;element name="prenom" type="{http://univ.fr/cvi}upperAndLowersLetters"/>
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
        "nom",
        "prenom"
    })
    public static class Identite {

        @XmlElement(required = true)
        protected String nom;
        @XmlElement(required = true)
        protected String prenom;

        /**
         * Obtient la valeur de la propriété nom.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNom() {
            return nom;
        }

        /**
         * Définit la valeur de la propriété nom.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNom(String value) {
            this.nom = value;
        }

        /**
         * Obtient la valeur de la propriété prenom.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrenom() {
            return prenom;
        }

        /**
         * Définit la valeur de la propriété prenom.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrenom(String value) {
            this.prenom = value;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;choice>
     *           &lt;element name="stage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *           &lt;element name="emploi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;/choice>
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
        "stage",
        "emploi"
    })
    public static class Objectif {

        protected String stage;
        protected String emploi;

        /**
         * Obtient la valeur de la propriété stage.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStage() {
            return stage;
        }

        /**
         * Définit la valeur de la propriété stage.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStage(String value) {
            this.stage = value;
        }

        /**
         * Obtient la valeur de la propriété emploi.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmploi() {
            return emploi;
        }

        /**
         * Définit la valeur de la propriété emploi.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmploi(String value) {
            this.emploi = value;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="expe" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="datedeb" type="{http://univ.fr/cvi}dateTimeFormat"/>
     *                   &lt;element name="datefin" type="{http://univ.fr/cvi}dateTimeFormat" minOccurs="0"/>
     *                   &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "expe"
    })
    public static class Prof {

        protected List<Cvi.Prof.Expe> expe;

        /**
         * Gets the value of the expe property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the expe property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExpe().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Cvi.Prof.Expe }
         * 
         * 
         */
        public List<Cvi.Prof.Expe> getExpe() {
            if (expe == null) {
                expe = new ArrayList<Cvi.Prof.Expe>();
            }
            return this.expe;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="datedeb" type="{http://univ.fr/cvi}dateTimeFormat"/>
         *         &lt;element name="datefin" type="{http://univ.fr/cvi}dateTimeFormat" minOccurs="0"/>
         *         &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "datedeb",
            "datefin",
            "descript"
        })
        public static class Expe {

            @XmlElement(required = true)
            protected String datedeb;
            protected String datefin;
            @XmlElement(required = true)
            protected String descript;

            /**
             * Obtient la valeur de la propriété datedeb.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatedeb() {
                return datedeb;
            }

            /**
             * Définit la valeur de la propriété datedeb.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatedeb(String value) {
                this.datedeb = value;
            }

            /**
             * Obtient la valeur de la propriété datefin.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatefin() {
                return datefin;
            }

            /**
             * Définit la valeur de la propriété datefin.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatefin(String value) {
                this.datefin = value;
            }

            /**
             * Obtient la valeur de la propriété descript.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescript() {
                return descript;
            }

            /**
             * Définit la valeur de la propriété descript.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescript(String value) {
                this.descript = value;
            }

        }

    }

}
