/*
 * This file is generated by jOOQ.
 */
package io.ktor.answers.generated.tables.records;


import io.ktor.answers.generated.tables.QuestionTag;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QuestionTagRecord extends UpdatableRecordImpl<QuestionTagRecord> implements Record2<Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.question_tag.question_id</code>.
     */
    public void setQuestionId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.question_tag.question_id</code>.
     */
    public Long getQuestionId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.question_tag.tag_id</code>.
     */
    public void setTagId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.question_tag.tag_id</code>.
     */
    public Long getTagId() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return QuestionTag.QUESTION_TAG.QUESTION_ID;
    }

    @Override
    public Field<Long> field2() {
        return QuestionTag.QUESTION_TAG.TAG_ID;
    }

    @Override
    public Long component1() {
        return getQuestionId();
    }

    @Override
    public Long component2() {
        return getTagId();
    }

    @Override
    public Long value1() {
        return getQuestionId();
    }

    @Override
    public Long value2() {
        return getTagId();
    }

    @Override
    public QuestionTagRecord value1(Long value) {
        setQuestionId(value);
        return this;
    }

    @Override
    public QuestionTagRecord value2(Long value) {
        setTagId(value);
        return this;
    }

    @Override
    public QuestionTagRecord values(Long value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QuestionTagRecord
     */
    public QuestionTagRecord() {
        super(QuestionTag.QUESTION_TAG);
    }

    /**
     * Create a detached, initialised QuestionTagRecord
     */
    public QuestionTagRecord(Long questionId, Long tagId) {
        super(QuestionTag.QUESTION_TAG);

        setQuestionId(questionId);
        setTagId(tagId);
        resetChangedOnNotNull();
    }
}
