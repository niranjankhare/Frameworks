/*
 * This file is generated by jOOQ.
*/
package db.jooq.generated.automationDb;


import db.jooq.generated.automationDb.tables.Guimap;
import db.jooq.generated.automationDb.tables.Pages;
import db.jooq.generated.automationDb.tables.Properties;
import db.jooq.generated.automationDb.tables.Types;
import db.jooq.generated.automationDb.tables.records.GuimapRecord;
import db.jooq.generated.automationDb.tables.records.PagesRecord;
import db.jooq.generated.automationDb.tables.records.PropertiesRecord;
import db.jooq.generated.automationDb.tables.records.TypesRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>automation</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<GuimapRecord, Integer> IDENTITY_GUIMAP = Identities0.IDENTITY_GUIMAP;
    public static final Identity<PropertiesRecord, Integer> IDENTITY_PROPERTIES = Identities0.IDENTITY_PROPERTIES;
    public static final Identity<TypesRecord, Integer> IDENTITY_TYPES = Identities0.IDENTITY_TYPES;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<GuimapRecord> KEY_GUIMAP_PRIMARY = UniqueKeys0.KEY_GUIMAP_PRIMARY;
    public static final UniqueKey<PagesRecord> KEY_PAGES_PRIMARY = UniqueKeys0.KEY_PAGES_PRIMARY;
    public static final UniqueKey<PropertiesRecord> KEY_PROPERTIES_PRIMARY = UniqueKeys0.KEY_PROPERTIES_PRIMARY;
    public static final UniqueKey<TypesRecord> KEY_TYPES_PRIMARY = UniqueKeys0.KEY_TYPES_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<GuimapRecord, Integer> IDENTITY_GUIMAP = createIdentity(Guimap.GUIMAP, Guimap.GUIMAP.GUIMAPID);
        public static Identity<PropertiesRecord, Integer> IDENTITY_PROPERTIES = createIdentity(Properties.PROPERTIES, Properties.PROPERTIES.PROPERTYID);
        public static Identity<TypesRecord, Integer> IDENTITY_TYPES = createIdentity(Types.TYPES, Types.TYPES.CLASSID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<GuimapRecord> KEY_GUIMAP_PRIMARY = createUniqueKey(Guimap.GUIMAP, "KEY_guimap_PRIMARY", Guimap.GUIMAP.GUIMAPID);
        public static final UniqueKey<PagesRecord> KEY_PAGES_PRIMARY = createUniqueKey(Pages.PAGES, "KEY_pages_PRIMARY", Pages.PAGES.PAGENAME);
        public static final UniqueKey<PropertiesRecord> KEY_PROPERTIES_PRIMARY = createUniqueKey(Properties.PROPERTIES, "KEY_properties_PRIMARY", Properties.PROPERTIES.PROPERTYID);
        public static final UniqueKey<TypesRecord> KEY_TYPES_PRIMARY = createUniqueKey(Types.TYPES, "KEY_types_PRIMARY", Types.TYPES.CLASSID);
    }
}
