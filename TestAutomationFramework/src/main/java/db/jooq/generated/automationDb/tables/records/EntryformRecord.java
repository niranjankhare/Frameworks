/*
 * This file is generated by jOOQ.
*/
package db.jooq.generated.automationDb.tables.records;


import db.jooq.generated.automationDb.tables.Entryform;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.TableRecordImpl;


/**
 * VIEW
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EntryformRecord extends TableRecordImpl<EntryformRecord> implements Record15<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = -1148444972;

    /**
     * Setter for <code>automation.entryform.CONTROLTYPE</code>.
     */
    public void setControltype(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>automation.entryform.CONTROLTYPE</code>.
     */
    public String getControltype() {
        return (String) get(0);
    }

    /**
     * Setter for <code>automation.entryform.CONTROLNAME</code>.
     */
    public void setControlname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>automation.entryform.CONTROLNAME</code>.
     */
    public String getControlname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>automation.entryform.CONTROLDESCRIPTION</code>.
     */
    public void setControldescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>automation.entryform.CONTROLDESCRIPTION</code>.
     */
    public String getControldescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>automation.entryform.LOCATORVALUE</code>.
     */
    public void setLocatorvalue(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>automation.entryform.LOCATORVALUE</code>.
     */
    public String getLocatorvalue() {
        return (String) get(3);
    }

    /**
     * Setter for <code>automation.entryform.LOCATORTYPE</code>.
     */
    public void setLocatortype(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>automation.entryform.LOCATORTYPE</code>.
     */
    public String getLocatortype() {
        return (String) get(4);
    }

    /**
     * Setter for <code>automation.entryform.PROPERTYMAP</code>.
     */
    public void setPropertymap(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>automation.entryform.PROPERTYMAP</code>.
     */
    public String getPropertymap() {
        return (String) get(5);
    }

    /**
     * Setter for <code>automation.entryform.EXPROP1</code>.
     */
    public void setExprop1(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>automation.entryform.EXPROP1</code>.
     */
    public String getExprop1() {
        return (String) get(6);
    }

    /**
     * Setter for <code>automation.entryform.EXPROP2</code>.
     */
    public void setExprop2(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>automation.entryform.EXPROP2</code>.
     */
    public String getExprop2() {
        return (String) get(7);
    }

    /**
     * Setter for <code>automation.entryform.EXPROP3</code>.
     */
    public void setExprop3(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>automation.entryform.EXPROP3</code>.
     */
    public String getExprop3() {
        return (String) get(8);
    }

    /**
     * Setter for <code>automation.entryform.EXPROP4</code>.
     */
    public void setExprop4(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>automation.entryform.EXPROP4</code>.
     */
    public String getExprop4() {
        return (String) get(9);
    }

    /**
     * Setter for <code>automation.entryform.EXPROP5</code>.
     */
    public void setExprop5(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>automation.entryform.EXPROP5</code>.
     */
    public String getExprop5() {
        return (String) get(10);
    }

    /**
     * Setter for <code>automation.entryform.EXPROP6</code>.
     */
    public void setExprop6(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>automation.entryform.EXPROP6</code>.
     */
    public String getExprop6() {
        return (String) get(11);
    }

    /**
     * Setter for <code>automation.entryform.EXPROP7</code>.
     */
    public void setExprop7(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>automation.entryform.EXPROP7</code>.
     */
    public String getExprop7() {
        return (String) get(12);
    }

    /**
     * Setter for <code>automation.entryform.EXPROP8</code>.
     */
    public void setExprop8(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>automation.entryform.EXPROP8</code>.
     */
    public String getExprop8() {
        return (String) get(13);
    }

    /**
     * Setter for <code>automation.entryform.EXPROP9</code>.
     */
    public void setExprop9(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>automation.entryform.EXPROP9</code>.
     */
    public String getExprop9() {
        return (String) get(14);
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Entryform.ENTRYFORM.CONTROLTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Entryform.ENTRYFORM.CONTROLNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Entryform.ENTRYFORM.CONTROLDESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Entryform.ENTRYFORM.LOCATORVALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Entryform.ENTRYFORM.LOCATORTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Entryform.ENTRYFORM.PROPERTYMAP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Entryform.ENTRYFORM.EXPROP1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Entryform.ENTRYFORM.EXPROP2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Entryform.ENTRYFORM.EXPROP3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Entryform.ENTRYFORM.EXPROP4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Entryform.ENTRYFORM.EXPROP5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Entryform.ENTRYFORM.EXPROP6;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return Entryform.ENTRYFORM.EXPROP7;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return Entryform.ENTRYFORM.EXPROP8;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return Entryform.ENTRYFORM.EXPROP9;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getControltype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getControlname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getControldescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getLocatorvalue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getLocatortype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getPropertymap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getExprop1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getExprop2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getExprop3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getExprop4();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getExprop5();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getExprop6();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getExprop7();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getExprop8();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getExprop9();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getControltype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getControlname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getControldescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getLocatorvalue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getLocatortype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPropertymap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getExprop1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getExprop2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getExprop3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getExprop4();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getExprop5();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getExprop6();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getExprop7();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getExprop8();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getExprop9();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value1(String value) {
        setControltype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value2(String value) {
        setControlname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value3(String value) {
        setControldescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value4(String value) {
        setLocatorvalue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value5(String value) {
        setLocatortype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value6(String value) {
        setPropertymap(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value7(String value) {
        setExprop1(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value8(String value) {
        setExprop2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value9(String value) {
        setExprop3(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value10(String value) {
        setExprop4(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value11(String value) {
        setExprop5(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value12(String value) {
        setExprop6(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value13(String value) {
        setExprop7(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value14(String value) {
        setExprop8(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord value15(String value) {
        setExprop9(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntryformRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EntryformRecord
     */
    public EntryformRecord() {
        super(Entryform.ENTRYFORM);
    }

    /**
     * Create a detached, initialised EntryformRecord
     */
    public EntryformRecord(String controltype, String controlname, String controldescription, String locatorvalue, String locatortype, String propertymap, String exprop1, String exprop2, String exprop3, String exprop4, String exprop5, String exprop6, String exprop7, String exprop8, String exprop9) {
        super(Entryform.ENTRYFORM);

        set(0, controltype);
        set(1, controlname);
        set(2, controldescription);
        set(3, locatorvalue);
        set(4, locatortype);
        set(5, propertymap);
        set(6, exprop1);
        set(7, exprop2);
        set(8, exprop3);
        set(9, exprop4);
        set(10, exprop5);
        set(11, exprop6);
        set(12, exprop7);
        set(13, exprop8);
        set(14, exprop9);
    }
}
