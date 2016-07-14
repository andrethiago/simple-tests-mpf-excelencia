package br.mp.mpf.simpletests.infra.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

public class GenericEnumUserType implements UserType, ParameterizedType {

    private Class<?> enumClass;

    @Override
    public Object assemble(final Serializable cached, final Object owner) throws HibernateException {
	return cached;
    }

    @Override
    public Object deepCopy(final Object value) throws HibernateException {
	return value;
    }

    @Override
    public Serializable disassemble(final Object value) throws HibernateException {
	return (Serializable) value;
    }

    @Override
    public boolean equals(final Object x, final Object y) throws HibernateException {
	return (x == null) ? x == y : x.equals(y);
    }

    @Override
    public int hashCode(final Object x) throws HibernateException {
	if (x == null) {
	    return 0;
	}
	return x.hashCode();
    }

    @Override
    public boolean isMutable() {
	return false;
    }

    @Override
    public Object nullSafeGet(final ResultSet rs, final String[] names, final SessionImplementor sessionImplementor,
	    final Object owner) throws HibernateException, SQLException {
	final Integer value = rs.getInt(names[0]) == 0 ? null : rs.getInt(names[0]);
	if (value == null) {
	    return value;
	} else if (EnumTypeInteger.class.isAssignableFrom(this.enumClass)) {
	    for (final Object possibleValue : this.enumClass.getEnumConstants()) {
		final EnumTypeInteger typeInt = (EnumTypeInteger) possibleValue;
		if (typeInt.getCodigo().equals(value)) {
		    return typeInt;
		}
	    }
	} else {
	    for (final Object possibleValue : this.enumClass.getEnumConstants()) {
		final Enum<?> ident = (Enum<?>) possibleValue;
		if (ident.name().equals(value)) {
		    return ident;
		}
	    }
	}
	throw new HibernateException(value + " não foi encontrado no enum " + this.enumClass);
    }

    @Override
    public void nullSafeSet(final PreparedStatement st, final Object value, final int index,
	    final SessionImplementor sessionImplementor) throws HibernateException, SQLException {
	final Enum<?> en = (Enum<?>) value;
	if (en == null) {
	    st.setNull(index, Types.INTEGER);
	} else if (en instanceof EnumTypeInteger) {
	    st.setInt(index, ((EnumTypeInteger) en).getCodigo());
	} else {
	    throw new HibernateException("Não foi possível definir um valor para o enum " + this.enumClass);
	}
    }

    @Override
    public Object replace(final Object original, final Object target, final Object owner) throws HibernateException {
	return original;
    }

    @Override
    public Class<?> returnedClass() {
	return this.enumClass;
    }

    @Override
    public void setParameterValues(final Properties parameters) {
	if (parameters != null) {
	    final String classeEnum = parameters.getProperty("enumClass");
	    try {
		this.enumClass = Class.forName(classeEnum);
	    } catch (final ClassNotFoundException e) {
		throw new IllegalArgumentException("A classe '" + classeEnum + "' não existe, corrija o mapeamento!");
	    }
	}

    }

    @Override
    public int[] sqlTypes() {
	return new int[] { Types.INTEGER };
    }

}
