/*
 * This file is generated by jOOQ.
*/
package db.jooq.generated.automationDb.tables;


import db.jooq.generated.automationDb.Automation;
import db.jooq.generated.automationDb.tables.records.EntryformRecord;

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
public class Entryform extends TableImpl<EntryformRecord> {

    private static final long serialVersionUID = 115849355;

    /**
     * The reference instance of <code>automation.entryform</code>
     */
    public static final Entryform ENTRYFORM = new Entryform();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EntryformRecord> getRecordType() {
        return EntryformRecord.class;
    }

    /**
     * The column <code>automation.entryform.ELEMENTTYPE</code>.
     */
    public final TableField<EntryformRecord, String> CONTROLTYPE = createField("CONTROLTYPE", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>automation.entryform.CONTROLNAME</code>.
     */
    public final TableField<EntryformRecord, String> CONTROLNAME = createField("CONTROLNAME", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>automation.entryform.CONTROLDESCRIPTION</code>.
     */
    public final TableField<EntryformRecord, String> CONTROLDESCRIPTION = createField("CONTROLDESCRIPTION", org.jooq.impl.SQLDataType.VARCHAR(150), this, "");

    /**
     * The column <code>automation.entryform.LOCATORVALUE</code>.
     */
    public final TableField<EntryformRecord, String> LOCATORVALUE = createField("LOCATORVALUE", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * Create a <code>automation.entryform</code> table reference
     */
    public Entryform() {
        this(DSL.name("entryform"), null);
    }

    /**
     * Create an aliased <code>automation.entryform</code> table reference
     */
    public Entryform(String alias) {
        this(DSL.name(alias), ENTRYFORM);
    }

    /**
     * Create an aliased <code>automation.entryform</code> table reference
     */
    public Entryform(Name alias) {
        this(alias, ENTRYFORM);
    }

    private Entryform(Name alias, Table<EntryformRecord> aliased) {
        this(alias, aliased, null);
    }

    private Entryform(Name alias, Table<EntryformRecord> aliased, Field<?>[] parameters) {
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
    public Entryform as(String alias) {
        return new Entryform(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entryform as(Name alias) {
        return new Entryform(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Entryform rename(String name) {
        return new Entryform(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Entryform rename(Name name) {
        return new Entryform(name, null);
    }
}
