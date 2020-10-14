/*
 * This file is generated by jOOQ.
 */
package ch.toubidev.db.jooq.processing;


import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class DefaultCatalog extends CatalogImpl {

    /**
     * The reference instance of <code>DEFAULT_CATALOG</code>
     */
    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();
    private static final long serialVersionUID = -1669721458;
    /**
     * The schema <code>mybudget_appl</code>.
     */
    public final MybudgetAppl MYBUDGET_APPL = MybudgetAppl.MYBUDGET_APPL;

    /**
     * No further instances allowed
     */
    private DefaultCatalog() {
        super("");
    }

    @Override
    public final List<Schema> getSchemas() {
        return Arrays.<Schema>asList(
                MybudgetAppl.MYBUDGET_APPL);
    }
}
