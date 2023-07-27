/*
 * This file is generated by jOOQ.
 */
package io.ktor.answers.generated.public_.tables;


import io.ktor.answers.generated.public_.Indexes;
import io.ktor.answers.generated.public_.Keys;
import io.ktor.answers.generated.public_.Public;
import io.ktor.answers.generated.public_.tables.records.VoteRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
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
public class Vote extends TableImpl<VoteRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.vote</code>
     */
    public static final Vote VOTE = new Vote();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VoteRecord> getRecordType() {
        return VoteRecord.class;
    }

    /**
     * The column <code>public.vote.id</code>.
     */
    public final TableField<VoteRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.vote.voter</code>.
     */
    public final TableField<VoteRecord, Long> VOTER = createField(DSL.name("voter"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.vote.content</code>.
     */
    public final TableField<VoteRecord, Long> CONTENT = createField(DSL.name("content"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.vote.value</code>.
     */
    public final TableField<VoteRecord, Short> VALUE = createField(DSL.name("value"), SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>public.vote.created_at</code>.
     */
    public final TableField<VoteRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    private Vote(Name alias, Table<VoteRecord> aliased) {
        this(alias, aliased, null);
    }

    private Vote(Name alias, Table<VoteRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.vote</code> table reference
     */
    public Vote(String alias) {
        this(DSL.name(alias), VOTE);
    }

    /**
     * Create an aliased <code>public.vote</code> table reference
     */
    public Vote(Name alias) {
        this(alias, VOTE);
    }

    /**
     * Create a <code>public.vote</code> table reference
     */
    public Vote() {
        this(DSL.name("vote"), null);
    }

    public <O extends Record> Vote(Table<O> child, ForeignKey<O, VoteRecord> key) {
        super(child, key, VOTE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.VOTE_CONTENT, Indexes.VOTE_VOTER);
    }

    @Override
    public Identity<VoteRecord, Long> getIdentity() {
        return (Identity<VoteRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<VoteRecord> getPrimaryKey() {
        return Keys.VOTE_PKEY;
    }

    @Override
    public List<ForeignKey<VoteRecord, ?>> getReferences() {
        return Arrays.asList(Keys.VOTE__FK_VOTE_VOTER__ID, Keys.VOTE__FK_VOTE_CONTENT__ID);
    }

    private transient Users _users;
    private transient Content _content;

    /**
     * Get the implicit join path to the <code>public.users</code> table.
     */
    public Users users() {
        if (_users == null)
            _users = new Users(this, Keys.VOTE__FK_VOTE_VOTER__ID);

        return _users;
    }

    /**
     * Get the implicit join path to the <code>public.content</code> table.
     */
    public Content content() {
        if (_content == null)
            _content = new Content(this, Keys.VOTE__FK_VOTE_CONTENT__ID);

        return _content;
    }

    @Override
    public Vote as(String alias) {
        return new Vote(DSL.name(alias), this);
    }

    @Override
    public Vote as(Name alias) {
        return new Vote(alias, this);
    }

    @Override
    public Vote as(Table<?> alias) {
        return new Vote(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Vote rename(String name) {
        return new Vote(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Vote rename(Name name) {
        return new Vote(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Vote rename(Table<?> name) {
        return new Vote(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Long, Short, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super Long, ? super Long, ? super Long, ? super Short, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super Long, ? super Long, ? super Long, ? super Short, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
