package com.qiumingjie.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.util.Locale;

/**
 * @author QiuMingJie
 * @date 2020-08-27 15:15
 * @description
 */
@Slf4j
public class JpaTableName extends SpringPhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier name,
                                            JdbcEnvironment jdbcEnvironment) {
        return apply(name, jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name,
                                           JdbcEnvironment jdbcEnvironment) {
        return apply(name, jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name,
                                          JdbcEnvironment jdbcEnvironment) {
        return apply(name, jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name,
                                             JdbcEnvironment jdbcEnvironment) {
        return apply(name, jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name,
                                           JdbcEnvironment jdbcEnvironment) {
        return apply(name, jdbcEnvironment);
    }

    private Identifier apply(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name == null) {
            return null;
        }
        if (name.getText().contains("_")) {
            log.info(name.getText()+"包含_，重写jpa跳过转换");
            return getIdentifier(name.getText(), name.isQuoted(), jdbcEnvironment);
        }
        if (name.getText().contains("ID")) {
            log.info(name.getText() + "包含大写ID，跳过");
            return getIdentifier(name.getText(), name.isQuoted(), jdbcEnvironment);
        }
        if ("emergencyOrNot".equals(name.getText())||"isPrinted".equals(name.getText())) {
            return getIdentifier(name.getText(), name.isQuoted(), jdbcEnvironment);
        }


        StringBuilder builder = new StringBuilder(name.getText().replace('.', '_'));
        for (int i = 1; i < builder.length() - 1; i++) {
            if (isUnderscoreRequired(builder.charAt(i - 1), builder.charAt(i),
                    builder.charAt(i + 1))) {
                builder.insert(i++, '_');
            }
        }
        return getIdentifier(builder.toString(), name.isQuoted(), jdbcEnvironment);
    }

    /**
     * Get an identifier for the specified details. By default this method will return an
     * identifier with the name adapted based on the result of
     * {@link #isCaseInsensitive(JdbcEnvironment)}
     * @param name the name of the identifier
     * @param quoted if the identifier is quoted
     * @param jdbcEnvironment the JDBC environment
     * @return an identifier instance
     */
    protected Identifier getIdentifier(String name, boolean quoted,
                                       JdbcEnvironment jdbcEnvironment) {
        if (isCaseInsensitive(jdbcEnvironment)) {
            name = name.toLowerCase(Locale.ROOT);
        }
        return new Identifier(name, quoted);
    }

    /**
     * Specify whether the database is case sensitive.
     * @param jdbcEnvironment the JDBC environment which can be used to determine case
     * @return true if the database is case insensitive sensitivity
     */
    protected boolean isCaseInsensitive(JdbcEnvironment jdbcEnvironment) {
        return true;
    }

    private boolean isUnderscoreRequired(char before, char current, char after) {
        return Character.isLowerCase(before) && Character.isUpperCase(current)
                && Character.isLowerCase(after);
    }



}
