/*
 * This file is generated by jOOQ.
 */
package ch.toubidev.db.jooq.processing;


import ch.toubidev.db.jooq.processing.tables.Category;
import ch.toubidev.db.jooq.processing.tables.User;
import ch.toubidev.db.jooq.processing.tables.records.CategoryRecord;
import ch.toubidev.db.jooq.processing.tables.records.UserRecord;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of
 * the <code>mybudget_appl</code> schema.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CategoryRecord> CATEGORY_PKEY = UniqueKeys0.CATEGORY_PKEY;
    public static final UniqueKey<UserRecord> USER_PKEY = UniqueKeys0.USER_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<CategoryRecord> CATEGORY_PKEY = Internal.createUniqueKey(Category.CATEGORY, "category_pkey", new TableField[]{Category.CATEGORY.ID}, true);
        public static final UniqueKey<UserRecord> USER_PKEY = Internal.createUniqueKey(User.USER, "user_pkey", new TableField[]{User.USER.ID}, true);
    }
}
