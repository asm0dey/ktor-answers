/*
 * This file is generated by jOOQ.
 */
package io.ktor.answers.generated.tables;


import io.ktor.answers.generated.Indexes;
import io.ktor.answers.generated.Keys;
import io.ktor.answers.generated.Public;
import io.ktor.answers.generated.tables.records.UserRoleRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRole extends TableImpl<UserRoleRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.user_role</code>
     */
    public static final UserRole USER_ROLE = new UserRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRoleRecord> getRecordType() {
        return UserRoleRecord.class;
    }

    /**
     * The column <code>public.user_role.user</code>.
     */
    public final TableField<UserRoleRecord, Long> USER = createField(DSL.name("user"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.user_role.role</code>.
     */
    public final TableField<UserRoleRecord, Integer> ROLE = createField(DSL.name("role"), SQLDataType.INTEGER.nullable(false), this, "");

    private UserRole(Name alias, Table<UserRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserRole(Name alias, Table<UserRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.user_role</code> table reference
     */
    public UserRole(String alias) {
        this(DSL.name(alias), USER_ROLE);
    }

    /**
     * Create an aliased <code>public.user_role</code> table reference
     */
    public UserRole(Name alias) {
        this(alias, USER_ROLE);
    }

    /**
     * Create a <code>public.user_role</code> table reference
     */
    public UserRole() {
        this(DSL.name("user_role"), null);
    }

    public <O extends Record> UserRole(Table<O> child, ForeignKey<O, UserRoleRecord> key) {
        super(child, key, USER_ROLE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.USER_ROLE_ROLE, Indexes.USER_ROLE_USER);
    }

    @Override
    public UniqueKey<UserRoleRecord> getPrimaryKey() {
        return Keys.PK_USER_ROLE;
    }

    @Override
    public List<ForeignKey<UserRoleRecord, ?>> getReferences() {
        return Arrays.asList(Keys.USER_ROLE__FK_USER_ROLE_USER__ID, Keys.USER_ROLE__FK_USER_ROLE_ROLE__ID);
    }

    private transient Users _users;
    private transient Role _role;

    /**
     * Get the implicit join path to the <code>public.users</code> table.
     */
    public Users users() {
        if (_users == null)
            _users = new Users(this, Keys.USER_ROLE__FK_USER_ROLE_USER__ID);

        return _users;
    }

    /**
     * Get the implicit join path to the <code>public.role</code> table.
     */
    public Role role() {
        if (_role == null)
            _role = new Role(this, Keys.USER_ROLE__FK_USER_ROLE_ROLE__ID);

        return _role;
    }

    @Override
    public UserRole as(String alias) {
        return new UserRole(DSL.name(alias), this);
    }

    @Override
    public UserRole as(Name alias) {
        return new UserRole(alias, this);
    }

    @Override
    public UserRole as(Table<?> alias) {
        return new UserRole(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserRole rename(String name) {
        return new UserRole(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserRole rename(Name name) {
        return new UserRole(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserRole rename(Table<?> name) {
        return new UserRole(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Long, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Long, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
