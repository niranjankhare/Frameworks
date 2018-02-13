/*
 * This file is generated by jOOQ.
*/
package db.jooq.generated.automationDb.tables.records;


import db.jooq.generated.automationDb.tables.Extendedpropsview;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class ExtendedpropsviewRecord extends TableRecordImpl<ExtendedpropsviewRecord> implements Record9<String, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1579326745;

    /**
     * Setter for <code>automation.EXTENDEDPROPSVIEW.EXPROP1</code>.
     */
    public void setExprop1(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>automation.EXTENDEDPROPSVIEW.EXPROP1</code>.
     */
    public String getExprop1() {
        return (String) get(0);
    }

    /**
     * Setter for <code>automation.EXTENDEDPROPSVIEW.EXPROP2</code>.
     */
    public void setExprop2(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>automation.EXTENDEDPROPSVIEW.EXPROP2</code>.
     */
    public String getExprop2() {
        return (String) get(1);
    }

    /**
     * Setter for <code>automation.EXTENDEDPROPSVIEW.EXPROP3</code>.
     */
    public void setExprop3(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>automation.EXTENDEDPROPSVIEW.EXPROP3</code>.
     */
    public String getExprop3() {
        return (String) get(2);
    }

    /**
     * Setter for <code>automation.EXTENDEDPROPSVIEW.EXPROP4</code>.
     */
    public void setExprop4(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>automation.EXTENDEDPROPSVIEW.EXPROP4</code>.
     */
    public String getExprop4() {
        return (String) get(3);
    }

    /**
     * Setter for <code>automation.EXTENDEDPROPSVIEW.EXPROP5</code>.
     */
    public void setExprop5(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>automation.EXTENDEDPROPSVIEW.EXPROP5</code>.
     */
    public String getExprop5() {
        return (String) get(4);
    }

    /**
     * Setter for <code>automation.EXTENDEDPROPSVIEW.EXPROP6</code>.
     */
    public void setExprop6(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>automation.EXTENDEDPROPSVIEW.EXPROP6</code>.
     */
    public String getExprop6() {
        return (String) get(5);
    }

    /**
     * Setter for <code>automation.EXTENDEDPROPSVIEW.EXPROP7</code>.
     */
    public void setExprop7(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>automation.EXTENDEDPROPSVIEW.EXPROP7</code>.
     */
    public String getExprop7() {
        return (String) get(6);
    }

    /**
     * Setter for <code>automation.EXTENDEDPROPSVIEW.EXPROP8</code>.
     */
    public void setExprop8(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>automation.EXTENDEDPROPSVIEW.EXPROP8</code>.
     */
    public String getExprop8() {
        return (String) get(7);
    }

    /**
     * Setter for <code>automation.EXTENDEDPROPSVIEW.EXPROP9</code>.
     */
    public void setExprop9(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>automation.EXTENDEDPROPSVIEW.EXPROP9</code>.
     */
    public String getExprop9() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Extendedpropsview.EXTENDEDPROPSVIEW.EXPROP1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Extendedpropsview.EXTENDEDPROPSVIEW.EXPROP2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Extendedpropsview.EXTENDEDPROPSVIEW.EXPROP3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Extendedpropsview.EXTENDEDPROPSVIEW.EXPROP4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Extendedpropsview.EXTENDEDPROPSVIEW.EXPROP5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Extendedpropsview.EXTENDEDPROPSVIEW.EXPROP6;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Extendedpropsview.EXTENDEDPROPSVIEW.EXPROP7;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Extendedpropsview.EXTENDEDPROPSVIEW.EXPROP8;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Extendedpropsview.EXTENDEDPROPSVIEW.EXPROP9;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getExprop1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getExprop2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getExprop3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getExprop4();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getExprop5();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getExprop6();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getExprop7();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getExprop8();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getExprop9();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getExprop1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getExprop2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getExprop3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getExprop4();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getExprop5();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getExprop6();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getExprop7();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getExprop8();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getExprop9();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord value1(String value) {
        setExprop1(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord value2(String value) {
        setExprop2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord value3(String value) {
        setExprop3(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord value4(String value) {
        setExprop4(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord value5(String value) {
        setExprop5(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord value6(String value) {
        setExprop6(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord value7(String value) {
        setExprop7(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord value8(String value) {
        setExprop8(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord value9(String value) {
        setExprop9(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedpropsviewRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ExtendedpropsviewRecord
     */
    public ExtendedpropsviewRecord() {
        super(Extendedpropsview.EXTENDEDPROPSVIEW);
    }

    /**
     * Create a detached, initialised ExtendedpropsviewRecord
     */
    public ExtendedpropsviewRecord(String exprop1, String exprop2, String exprop3, String exprop4, String exprop5, String exprop6, String exprop7, String exprop8, String exprop9) {
        super(Extendedpropsview.EXTENDEDPROPSVIEW);

        set(0, exprop1);
        set(1, exprop2);
        set(2, exprop3);
        set(3, exprop4);
        set(4, exprop5);
        set(5, exprop6);
        set(6, exprop7);
        set(7, exprop8);
        set(8, exprop9);
    }
}
