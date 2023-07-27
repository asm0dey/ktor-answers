/*
 * This file is generated by jOOQ.
 */
package io.ktor.answers.generated.tables.records;


import io.ktor.answers.generated.tables.Users;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record10<Long, String, String, Boolean, String, LocalDateTime, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.users.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.users.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.users.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.users.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.users.password_hash</code>.
     */
    public void setPasswordHash(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.users.password_hash</code>.
     */
    public String getPasswordHash() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.users.active</code>.
     */
    public void setActive(Boolean value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.users.active</code>.
     */
    public Boolean getActive() {
        return (Boolean) get(3);
    }

    /**
     * Setter for <code>public.users.email</code>.
     */
    public void setEmail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.users.email</code>.
     */
    public String getEmail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.users.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.users.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.users.display_name</code>.
     */
    public void setDisplayName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.users.display_name</code>.
     */
    public String getDisplayName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.users.location</code>.
     */
    public void setLocation(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.users.location</code>.
     */
    public String getLocation() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.users.about_me</code>.
     */
    public void setAboutMe(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.users.about_me</code>.
     */
    public String getAboutMe() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.users.link</code>.
     */
    public void setLink(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.users.link</code>.
     */
    public String getLink() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, String, String, Boolean, String, LocalDateTime, String, String, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Long, String, String, Boolean, String, LocalDateTime, String, String, String, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.NAME;
    }

    @Override
    public Field<String> field3() {
        return Users.USERS.PASSWORD_HASH;
    }

    @Override
    public Field<Boolean> field4() {
        return Users.USERS.ACTIVE;
    }

    @Override
    public Field<String> field5() {
        return Users.USERS.EMAIL;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Users.USERS.CREATED_AT;
    }

    @Override
    public Field<String> field7() {
        return Users.USERS.DISPLAY_NAME;
    }

    @Override
    public Field<String> field8() {
        return Users.USERS.LOCATION;
    }

    @Override
    public Field<String> field9() {
        return Users.USERS.ABOUT_ME;
    }

    @Override
    public Field<String> field10() {
        return Users.USERS.LINK;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getPasswordHash();
    }

    @Override
    public Boolean component4() {
        return getActive();
    }

    @Override
    public String component5() {
        return getEmail();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedAt();
    }

    @Override
    public String component7() {
        return getDisplayName();
    }

    @Override
    public String component8() {
        return getLocation();
    }

    @Override
    public String component9() {
        return getAboutMe();
    }

    @Override
    public String component10() {
        return getLink();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getPasswordHash();
    }

    @Override
    public Boolean value4() {
        return getActive();
    }

    @Override
    public String value5() {
        return getEmail();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedAt();
    }

    @Override
    public String value7() {
        return getDisplayName();
    }

    @Override
    public String value8() {
        return getLocation();
    }

    @Override
    public String value9() {
        return getAboutMe();
    }

    @Override
    public String value10() {
        return getLink();
    }

    @Override
    public UsersRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public UsersRecord value3(String value) {
        setPasswordHash(value);
        return this;
    }

    @Override
    public UsersRecord value4(Boolean value) {
        setActive(value);
        return this;
    }

    @Override
    public UsersRecord value5(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UsersRecord value6(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public UsersRecord value7(String value) {
        setDisplayName(value);
        return this;
    }

    @Override
    public UsersRecord value8(String value) {
        setLocation(value);
        return this;
    }

    @Override
    public UsersRecord value9(String value) {
        setAboutMe(value);
        return this;
    }

    @Override
    public UsersRecord value10(String value) {
        setLink(value);
        return this;
    }

    @Override
    public UsersRecord values(Long value1, String value2, String value3, Boolean value4, String value5, LocalDateTime value6, String value7, String value8, String value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Long id, String name, String passwordHash, Boolean active, String email, LocalDateTime createdAt, String displayName, String location, String aboutMe, String link) {
        super(Users.USERS);

        setId(id);
        setName(name);
        setPasswordHash(passwordHash);
        setActive(active);
        setEmail(email);
        setCreatedAt(createdAt);
        setDisplayName(displayName);
        setLocation(location);
        setAboutMe(aboutMe);
        setLink(link);
        resetChangedOnNotNull();
    }
}
