/*
 * This file is generated by jOOQ.
*/
package db.jooq.generated.automationDb;


import db.jooq.generated.automationDb.tables.Extendedprops;
import db.jooq.generated.automationDb.tables.Extendedpropsview;
import db.jooq.generated.automationDb.tables.Guimap;
import db.jooq.generated.automationDb.tables.Pages;
import db.jooq.generated.automationDb.tables.Properties;
import db.jooq.generated.automationDb.tables.Propsview;
import db.jooq.generated.automationDb.tables.Showtable;
import db.jooq.generated.automationDb.tables.Types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Automation extends SchemaImpl {

    private static final long serialVersionUID = -284335321;

    /**
     * The reference instance of <code>automation</code>
     */
    public static final Automation AUTOMATION = new Automation();

    /**
     * The table <code>automation.extendedprops</code>.
     */
    public final Extendedprops EXTENDEDPROPS = db.jooq.generated.automationDb.tables.Extendedprops.EXTENDEDPROPS;

    /**
     * VIEW
     */
    public final Extendedpropsview EXTENDEDPROPSVIEW = db.jooq.generated.automationDb.tables.Extendedpropsview.EXTENDEDPROPSVIEW;

    /**
     * The table <code>automation.guimap</code>.
     */
    public final Guimap GUIMAP = db.jooq.generated.automationDb.tables.Guimap.GUIMAP;

    /**
     * The table <code>automation.pages</code>.
     */
    public final Pages PAGES = db.jooq.generated.automationDb.tables.Pages.PAGES;

    /**
     * The table <code>automation.properties</code>.
     */
    public final Properties PROPERTIES = db.jooq.generated.automationDb.tables.Properties.PROPERTIES;

    /**
     * VIEW
     */
    public final Propsview PROPSVIEW = db.jooq.generated.automationDb.tables.Propsview.PROPSVIEW;

    /**
     * VIEW
     */
    public final Showtable SHOWTABLE = db.jooq.generated.automationDb.tables.Showtable.SHOWTABLE;

    /**
     * The table <code>automation.types</code>.
     */
    public final Types TYPES = db.jooq.generated.automationDb.tables.Types.TYPES;

    /**
     * No further instances allowed
     */
    private Automation() {
        super("automation", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Extendedprops.EXTENDEDPROPS,
            Extendedpropsview.EXTENDEDPROPSVIEW,
            Guimap.GUIMAP,
            Pages.PAGES,
            Properties.PROPERTIES,
            Propsview.PROPSVIEW,
            Showtable.SHOWTABLE,
            Types.TYPES);
    }
}
