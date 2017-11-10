/*
 * This file is generated by jOOQ.
*/
package db.jooq.generated.automationDb.tables;


import db.jooq.generated.automationDb.Automation;
import db.jooq.generated.automationDb.Indexes;
import db.jooq.generated.automationDb.Keys;
import db.jooq.generated.automationDb.tables.records.ExtendedpropsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Extendedprops extends TableImpl<ExtendedpropsRecord> {

    private static final long serialVersionUID = 1446943257;

    /**
     * The reference instance of <code>automation.EXTENDEDPROPS</code>
     */
    public static final Extendedprops EXTENDEDPROPS = new Extendedprops();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ExtendedpropsRecord> getRecordType() {
        return ExtendedpropsRecord.class;
    }

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROPID</code>.
     */
    public final TableField<ExtendedpropsRecord, Integer> EXPROPID = createField("EXPROPID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.GUIMAPID</code>.
     */
    public final TableField<ExtendedpropsRecord, Integer> GUIMAPID = createField("GUIMAPID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROP1</code>.
     */
    public final TableField<ExtendedpropsRecord, String> EXPROP1 = createField("EXPROP1", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROP2</code>.
     */
    public final TableField<ExtendedpropsRecord, String> EXPROP2 = createField("EXPROP2", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROP3</code>.
     */
    public final TableField<ExtendedpropsRecord, String> EXPROP3 = createField("EXPROP3", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROP4</code>.
     */
    public final TableField<ExtendedpropsRecord, String> EXPROP4 = createField("EXPROP4", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROP5</code>.
     */
    public final TableField<ExtendedpropsRecord, String> EXPROP5 = createField("EXPROP5", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROP6</code>.
     */
    public final TableField<ExtendedpropsRecord, String> EXPROP6 = createField("EXPROP6", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROP7</code>.
     */
    public final TableField<ExtendedpropsRecord, String> EXPROP7 = createField("EXPROP7", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROP8</code>.
     */
    public final TableField<ExtendedpropsRecord, String> EXPROP8 = createField("EXPROP8", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>automation.EXTENDEDPROPS.EXPROP9</code>.
     */
    public final TableField<ExtendedpropsRecord, String> EXPROP9 = createField("EXPROP9", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * Create a <code>automation.EXTENDEDPROPS</code> table reference
     */
    public Extendedprops() {
        this(DSL.name("EXTENDEDPROPS"), null);
    }

    /**
     * Create an aliased <code>automation.EXTENDEDPROPS</code> table reference
     */
    public Extendedprops(String alias) {
        this(DSL.name(alias), EXTENDEDPROPS);
    }

    /**
     * Create an aliased <code>automation.EXTENDEDPROPS</code> table reference
     */
    public Extendedprops(Name alias) {
        this(alias, EXTENDEDPROPS);
    }

    private Extendedprops(Name alias, Table<ExtendedpropsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Extendedprops(Name alias, Table<ExtendedpropsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
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
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.EXTENDEDPROPS_FK_GUIMAP_EXTENDEDPROPS, Indexes.EXTENDEDPROPS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ExtendedpropsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_EXTENDEDPROPS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ExtendedpropsRecord> getPrimaryKey() {
        return Keys.KEY_EXTENDEDPROPS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ExtendedpropsRecord>> getKeys() {
        return Arrays.<UniqueKey<ExtendedpropsRecord>>asList(Keys.KEY_EXTENDEDPROPS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ExtendedpropsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ExtendedpropsRecord, ?>>asList(Keys.FK_GUIMAP_EXTENDEDPROPS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Extendedprops as(String alias) {
        return new Extendedprops(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Extendedprops as(Name alias) {
        return new Extendedprops(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Extendedprops rename(String name) {
        return new Extendedprops(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Extendedprops rename(Name name) {
        return new Extendedprops(name, null);
    }
}
