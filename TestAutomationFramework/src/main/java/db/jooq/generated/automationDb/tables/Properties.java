/*
 * This file is generated by jOOQ.
*/
package db.jooq.generated.automationDb.tables;


import db.jooq.generated.automationDb.Automation;
import db.jooq.generated.automationDb.Indexes;
import db.jooq.generated.automationDb.Keys;
import db.jooq.generated.automationDb.tables.records.PropertiesRecord;

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
public class Properties extends TableImpl<PropertiesRecord> {

    private static final long serialVersionUID = -352354945;

    /**
     * The reference instance of <code>automation.properties</code>
     */
    public static final Properties PROPERTIES = new Properties();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PropertiesRecord> getRecordType() {
        return PropertiesRecord.class;
    }

    /**
     * The column <code>automation.properties.PROPERTYID</code>.
     */
    public final TableField<PropertiesRecord, Integer> PROPERTYID = createField("PROPERTYID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>automation.properties.GUIMAPID</code>.
     */
    public final TableField<PropertiesRecord, Integer> GUIMAPID = createField("GUIMAPID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>automation.properties.STANDARDCLASS</code>.
     */
    public final TableField<PropertiesRecord, String> STANDARDCLASS = createField("STANDARDCLASS", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>automation.properties.MAPPEDCLASS</code>.
     */
    public final TableField<PropertiesRecord, String> MAPPEDCLASS = createField("MAPPEDCLASS", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>automation.properties.LOCATORVALUE</code>.
     */
    public final TableField<PropertiesRecord, String> LOCATORVALUE = createField("LOCATORVALUE", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>automation.properties.LOCATORTYPE</code>.
     */
    public final TableField<PropertiesRecord, String> LOCATORTYPE = createField("LOCATORTYPE", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * Create a <code>automation.properties</code> table reference
     */
    public Properties() {
        this(DSL.name("properties"), null);
    }

    /**
     * Create an aliased <code>automation.properties</code> table reference
     */
    public Properties(String alias) {
        this(DSL.name(alias), PROPERTIES);
    }

    /**
     * Create an aliased <code>automation.properties</code> table reference
     */
    public Properties(Name alias) {
        this(alias, PROPERTIES);
    }

    private Properties(Name alias, Table<PropertiesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Properties(Name alias, Table<PropertiesRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.PROPERTIES_FK_GUIMAP_PROPERTIES, Indexes.PROPERTIES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PropertiesRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PROPERTIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PropertiesRecord> getPrimaryKey() {
        return Keys.KEY_PROPERTIES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PropertiesRecord>> getKeys() {
        return Arrays.<UniqueKey<PropertiesRecord>>asList(Keys.KEY_PROPERTIES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PropertiesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PropertiesRecord, ?>>asList(Keys.FK_GUIMAP_PROPERTIES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Properties as(String alias) {
        return new Properties(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Properties as(Name alias) {
        return new Properties(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Properties rename(String name) {
        return new Properties(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Properties rename(Name name) {
        return new Properties(name, null);
    }
}
