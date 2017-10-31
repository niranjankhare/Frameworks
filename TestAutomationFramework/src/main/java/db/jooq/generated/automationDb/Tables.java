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

import javax.annotation.Generated;


/**
 * Convenience access to all tables in automation
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>automation.extendedprops</code>.
     */
    public static final Extendedprops EXTENDEDPROPS = db.jooq.generated.automationDb.tables.Extendedprops.EXTENDEDPROPS;

    /**
     * VIEW
     */
    public static final Extendedpropsview EXTENDEDPROPSVIEW = db.jooq.generated.automationDb.tables.Extendedpropsview.EXTENDEDPROPSVIEW;

    /**
     * The table <code>automation.guimap</code>.
     */
    public static final Guimap GUIMAP = db.jooq.generated.automationDb.tables.Guimap.GUIMAP;

    /**
     * The table <code>automation.pages</code>.
     */
    public static final Pages PAGES = db.jooq.generated.automationDb.tables.Pages.PAGES;

    /**
     * The table <code>automation.properties</code>.
     */
    public static final Properties PROPERTIES = db.jooq.generated.automationDb.tables.Properties.PROPERTIES;

    /**
     * VIEW
     */
    public static final Propsview PROPSVIEW = db.jooq.generated.automationDb.tables.Propsview.PROPSVIEW;

    /**
     * VIEW
     */
    public static final Showtable SHOWTABLE = db.jooq.generated.automationDb.tables.Showtable.SHOWTABLE;

    /**
     * The table <code>automation.types</code>.
     */
    public static final Types TYPES = db.jooq.generated.automationDb.tables.Types.TYPES;
}
