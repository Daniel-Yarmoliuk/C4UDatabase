package by.church4u.database.database.interfaces;

import java.sql.ResultSet;

/**
 * DB ResultSet convertor Interface.
 */
public interface ResultSetConverter
{
    /**
     * Convert ResultSet.
     *
     * @param aResultSet - ResultSet to be converted
     */
    void convert(final ResultSet aResultSet);
}