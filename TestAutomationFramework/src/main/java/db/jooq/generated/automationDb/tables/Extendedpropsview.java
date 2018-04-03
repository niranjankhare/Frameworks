/*
 * This file is generated by jOOQ.
*/
package db.jooq.generated.automationDb.tables;


import db.jooq.generated.automationDb.Automation;
import db.jooq.generated.automationDb.tables.records.ExtendedpropsviewRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Extendedpropsview extends TableImpl<ExtendedpropsviewRecord> {

    private static final long serialVersionUID = 1544443461;

    /**
     * The reference instance of <code>automation.EXTENDEDPROPSVIEW</code>
     */
    public static final Extendedpropsview EXTENDEDPROPSVIEW = new Extendedpropsview();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ExtendedpropsviewRecord> getRecordType() {
        return ExtendedpropsviewRecord.class;
    }

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.GUIMAPID</code>.
     */
    public final TableField<ExtendedpropsviewRecord, Integer> GUIMAPID = createField("GUIMAPID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.EXPROP1</code>.
     */
    public final TableField<ExtendedpropsviewRecord, String> EXPROP1 = createField("EXPROP1", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.EXPROP2</code>.
     */
    public final TableField<ExtendedpropsviewRecord, String> EXPROP2 = createField("EXPROP2", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.EXPROP3</code>.
     */
    public final TableField<ExtendedpropsviewRecord, String> EXPROP3 = createField("EXPROP3", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.EXPROP4</code>.
     */
    public final TableField<ExtendedpropsviewRecord, String> EXPROP4 = createField("EXPROP4", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.EXPROP5</code>.
     */
    public final TableField<ExtendedpropsviewRecord, String> EXPROP5 = createField("EXPROP5", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.EXPROP6</code>.
     */
    public final TableField<ExtendedpropsviewRecord, String> EXPROP6 = createField("EXPROP6", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.EXPROP7</code>.
     */
    public final TableField<ExtendedpropsviewRecord, String> EXPROP7 = createField("EXPROP7", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.EXPROP8</code>.
     */
    public final TableField<ExtendedpropsviewRecord, String> EXPROP8 = createField("EXPROP8", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPSVIEW.EXPROP9</code>.
     */
    public final TableField<ExtendedpropsviewRecord, String> EXPROP9 = createField("EXPROP9", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * Create a <code>automation.EXTENDEDPROPSVIEW</code> table reference
     */
    public Extendedpropsview() {
        this(DSL.name("EXTENDEDPROPSVIEW"), null);
    }

    /**
     * Create an aliased <code>automation.EXTENDEDPROPSVIEW</code> table reference
     */
    public Extendedpropsview(String alias) {
        this(DSL.name(alias), EXTENDEDPROPSVIEW);
    }

    /**
     * Create an aliased <code>automation.EXTENDEDPROPSVIEW</code> table reference
     */
    public Extendedpropsview(Name alias) {
        this(alias, EXTENDEDPROPSVIEW);
    }

    private Extendedpropsview(Name alias, Table<ExtendedpropsviewRecord> aliased) {
        this(alias, aliased, null);
    }

    private Extendedpropsview(Name alias, Table<ExtendedpropsviewRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "VIEW");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Automation.AUTOMATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Extendedpropsview as(String alias) {
        return new Extendedpropsview(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Extendedpropsview as(Name alias) {
        return new Extendedpropsview(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Extendedpropsview rename(String name) {
        return new Extendedpropsview(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Extendedpropsview rename(Name name) {
        return new Extendedpropsview(name, null);
    }
}
