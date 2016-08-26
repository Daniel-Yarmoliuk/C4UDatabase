package by.church4u.database.database;

import java.sql.*;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import by.church4u.database.database.interfaces.ResultSetConverter;

/**
 * Database Helper class.
 */
public final class DatabaseHelper
{
    private static final Logger LOGGER = Logger.getLogger(DatabaseHelper.class.getName());
    private static final String CALL = "call ";

    private DatabaseHelper()
    {
        // Utility class
    }

    /**
     * Method calls database stored procedures.
     *
     * @param aStoredProcedure - procedure call string
     * @param aParameters - arguments of the stored procedure
     * @param aConverter call convert() method of converter to get data from resultSet
     * @return true if procedures executed successful, else - false
     */
    public static boolean executeStoredProcedure(/* DataSource aDataSource, */final String aStoredProcedure,
                                                 final Object[] aParameters, final ResultSetConverter aConverter)
    {
        LOGGER.finest("executeStoredProcedure");
        Connection myConnection = /* aDataSource. */getConnection();
        try
        {
            String mySqlStatement = createSqlStatement(aStoredProcedure, aParameters);
            CallableStatement myStatement = myConnection.prepareCall(mySqlStatement);
            try
            {
                setParameters(myStatement, aParameters);
                ResultSet myResult = myStatement.executeQuery();
                try
                {
                    if (null != aConverter)
                    {
                        aConverter.convert(myResult);
                    }
                }
                finally
                {
                    myResult.close();
                }
            }
            finally
            {
                myStatement.close();
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        finally
        {
            releaseConnection(myConnection);
        }
        return true;
    }

    private static Connection getConnection()
    {
        LOGGER.finest("getConnection");

        DataSource ds = getDataSource();
        if (null != ds)
        {
            try
            {
                Connection connection = ds.getConnection();
                if (null != connection)
                {
                    return connection;
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        return null;
    }

    private static String createSqlStatement(final String aStoredProcedure, final Object[] aParameters)
    {
        LOGGER.finest("createSqlStatement");

        StringBuffer myParameterString = new StringBuffer(CALL);

        myParameterString.append(aStoredProcedure);

        if (aParameters != null && aParameters.length > 0)
        {
            myParameterString.append(" (?");
            for (int myIndex = 1; myIndex < aParameters.length; myIndex++)
            {
                myParameterString.append(",?");
            }
            myParameterString.append(")");
        }
        return myParameterString.toString();
    }

    private static void setParameters(final PreparedStatement aStatement, final Object[] aParameters)
            throws SQLException
    {
        LOGGER.finest("setParameters");
        if (aParameters != null)
        {
            for (int myIndex = 1; myIndex <= aParameters.length; myIndex++)
            {
                Object myParameter = aParameters[myIndex - 1];

                if (myParameter instanceof String)
                {
                    aStatement.setString(myIndex, (String) myParameter);
                }
                else if (myParameter instanceof Integer)
                {
                    aStatement.setInt(myIndex, ((Integer) myParameter).intValue());
                }
                else
                {
                    aStatement.setObject(myIndex, myParameter);
                }
            }
        }
    }

    /**
     * Releases the database connection.
     */
    private static void releaseConnection(final Connection aConnection)
    {
        LOGGER.finest("releaseConnection");
        if (aConnection != null)
        {
            try
            {
                aConnection.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private static DataSource getDataSource()
    {
        LOGGER.finest("getDataSource");
        try
        {
            Context envContext = (Context) new InitialContext().lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/HRTestTool");
            return dataSource;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

}
