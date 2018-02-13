/*
 * This file is generated by jOOQ.
*/
package db.jooq.generated.automationDb.tables;


import db.jooq.generated.automationDb.Automation;
import db.jooq.generated.automationDb.tables.records.PropsviewRecord;

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
public class Propsview extends TableImpl<PropsviewRecord> {

    private static final long serialVersionUID = -1835642266;

    /**
     * The reference instance of <code>automation.PROPSVIEW</code>
     */
    public static final Propsview PROPSVIEW = new Propsview();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PropsviewRecord> getRecordType() {
        return PropsviewRecord.class;
    }

    /**
     * The column <code>automation.PROPSVIEW.PAGENAME</code>.
     */
    public final TableField<PropsviewRecord, String> PAGENAME = createField("PAGENAME", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>automation.PROPSVIEW.GUIMAPID</code>.
     */
    public final TableField<PropsviewRecord, Integer> GUIMAPID = createField("GUIMAPID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>automation.PROPSVIEW.CONTROLTYPE</code>.
     */
    public final TableField<PropsviewRecord, String> CONTROLTYPE = createField("CONTROLTYPE", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>automation.PROPSVIEW.CONTROLNAME</code>.
     */
    public final TableField<PropsviewRecord, String> CONTROLNAME = createField("CONTROLNAME", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>automation.PROPSVIEW.CONTROLDESCRIPTION</code>.
     */
    public final TableField<PropsviewRecord, String> CONTROLDESCRIPTION = createField("CONTROLDESCRIPTION", org.jooq.impl.SQLDataType.VARCHAR(150), this, "");

    /**
     * The column <code>automation.PROPSVIEW.LOCATORVALUE</code>.
     */
    public final TableField<PropsviewRecord, String> LOCATORVALUE = createField("LOCATORVALUE", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>automation.PROPSVIEW.LOCATORTYPE</code>.
     */
    public final TableField<PropsviewRecord, String> LOCATORTYPE = createField("LOCATORTYPE", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * Create a <code>automation.PROPSVIEW</code> table reference
     */
    public Propsview() {
        this(DSL.name("PROPSVIEW"), null);
    }

    /**
     * Create an aliased <code>automation.PROPSVIEW</code> table reference
     */
    public Propsview(String alias) {
        this(DSL.name(alias), PROPSVIEW);
    }

    /**
     * Create an aliased <code>automation.PROPSVIEW</code> table reference
     */
    public Propsview(Name alias) {
        this(alias, PROPSVIEW);
    }

    private Propsview(Name alias, Table<PropsviewRecord> aliased) {
        this(alias, aliased, null);
    }

    private Propsview(Name alias, Table<PropsviewRecord> aliased, Field<?>[] parameters) {
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
    public Propsview as(String alias) {
        return new Propsview(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Propsview as(Name alias) {
        return new Propsview(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Propsview rename(String name) {
        return new Propsview(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Propsview rename(Name name) {
        return new Propsview(name, null);
    }
}
