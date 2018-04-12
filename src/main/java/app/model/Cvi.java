//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.04.12 à 02:48:54 PM CEST 
//


package app.model;

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
 *                   &lt;element name="expe">
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
 *                   &lt;element name="diplome">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="date" type="{http://univ.fr/cvi}dateTimeFormat"/>
 *                             &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="institut" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="niveau" type="{http://univ.fr/cvi}niveauDiplome" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="certif" minOccurs="0">
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
 *                   &lt;element name="lv">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="iso" type="{http://univ.fr/cvi}langues" />
 *                           &lt;attribute name="cert" type="{http://www.w3.org/2001/XMLSchema}string" />
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
 *                             &lt;element name="langage">
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
 *         &lt;element name="divers" minOccurs="0">
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
    protected Cvi.Divers divers;

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
     * Obtient la valeur de la propriété divers.
     * 
     * @return
     *     possible object is
     *     {@link Cvi.Divers }
     *     
     */
    public Cvi.Divers getDivers() {
        return divers;
    }

    /**
     * Définit la valeur de la propriété divers.
     * 
     * @param value
     *     allowed object is
     *     {@link Cvi.Divers }
     *     
     */
    public void setDivers(Cvi.Divers value) {
        this.divers = value;
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
     *         &lt;element name="diplome">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="date" type="{http://univ.fr/cvi}dateTimeFormat"/>
     *                   &lt;element name="descript" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="institut" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="niveau" type="{http://univ.fr/cvi}niveauDiplome" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="certif" minOccurs="0">
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
     *         &lt;element name="lv">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="iso" type="{http://univ.fr/cvi}langues" />
     *                 &lt;attribute name="cert" type="{http://www.w3.org/2001/XMLSchema}string" />
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
     *                   &lt;element name="langage">
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
        protected Cvi.Competences.Diplome diplome;
        protected Cvi.Competences.Certif certif;
        @XmlElement(required = true)
        protected Cvi.Competences.Lv lv;
        @XmlElement(required = true)
        protected Cvi.Competences.Info info;

        /**
         * Obtient la valeur de la propriété diplome.
         * 
         * @return
         *     possible object is
         *     {@link Cvi.Competences.Diplome }
         *     
         */
        public Cvi.Competences.Diplome getDiplome() {
            return diplome;
        }

        /**
         * Définit la valeur de la propriété diplome.
         * 
         * @param value
         *     allowed object is
         *     {@link Cvi.Competences.Diplome }
         *     
         */
        public void setDiplome(Cvi.Competences.Diplome value) {
            this.diplome = value;
        }

        /**
         * Obtient la valeur de la propriété certif.
         * 
         * @return
         *     possible object is
         *     {@link Cvi.Competences.Certif }
         *     
         */
        public Cvi.Competences.Certif getCertif() {
            return certif;
        }

        /**
         * Définit la valeur de la propriété certif.
         * 
         * @param value
         *     allowed object is
         *     {@link Cvi.Competences.Certif }
         *     
         */
        public void setCertif(Cvi.Competences.Certif value) {
            this.certif = value;
        }

        /**
         * Obtient la valeur de la propriété lv.
         * 
         * @return
         *     possible object is
         *     {@link Cvi.Competences.Lv }
         *     
         */
        public Cvi.Competences.Lv getLv() {
            return lv;
        }

        /**
         * Définit la valeur de la propriété lv.
         * 
         * @param value
         *     allowed object is
         *     {@link Cvi.Competences.Lv }
         *     
         */
        public void setLv(Cvi.Competences.Lv value) {
            this.lv = value;
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

            @Override
            public String toString() {
                return datedeb + " -> " + datefin + " : " + descript;
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
         *       &lt;attribute name="niveau" type="{http://univ.fr/cvi}niveauDiplome" />
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
            @XmlAttribute(name = "niveau")
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

            @Override
            public String toString() {
                return date +" - "+ descript +" ("+institut+") ["+ niveau+"]";
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
         *         &lt;element name="langage">
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
            protected Cvi.Competences.Info.Langage langage;

            /**
             * Obtient la valeur de la propriété langage.
             * 
             * @return
             *     possible object is
             *     {@link Cvi.Competences.Info.Langage }
             *     
             */
            public Cvi.Competences.Info.Langage getLangage() {
                return langage;
            }

            /**
             * Définit la valeur de la propriété langage.
             * 
             * @param value
             *     allowed object is
             *     {@link Cvi.Competences.Info.Langage }
             *     
             */
            public void setLangage(Cvi.Competences.Info.Langage value) {
                this.langage = value;
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
         *       &lt;attribute name="iso" type="{http://univ.fr/cvi}langues" />
         *       &lt;attribute name="cert" type="{http://www.w3.org/2001/XMLSchema}string" />
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

            @XmlAttribute(name = "iso")
            protected Langues iso;
            @XmlAttribute(name = "cert")
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

            @Override
            public String toString() {
                if(nivs == null) return iso +" - "+ cert +"["+nivi+"]";
                else return iso +" - "+ cert +"["+nivs+"]";
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
     *         &lt;element name="expe">
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

        @XmlElement(required = true)
        protected Cvi.Prof.Expe expe;

        /**
         * Obtient la valeur de la propriété expe.
         * 
         * @return
         *     possible object is
         *     {@link Cvi.Prof.Expe }
         *     
         */
        public Cvi.Prof.Expe getExpe() {
            return expe;
        }

        /**
         * Définit la valeur de la propriété expe.
         * 
         * @param value
         *     allowed object is
         *     {@link Cvi.Prof.Expe }
         *     
         */
        public void setExpe(Cvi.Prof.Expe value) {
            this.expe = value;
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

            @Override
            public String toString() {
                return datedeb + " -> " + datefin + " : " + descript;
            }
        }

    }

}
