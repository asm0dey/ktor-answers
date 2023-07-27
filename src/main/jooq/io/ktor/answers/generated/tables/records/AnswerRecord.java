/*
 * This file is generated by jOOQ.
 */
package io.ktor.answers.generated.tables.records;


import io.ktor.answers.generated.tables.Answer;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AnswerRecord extends UpdatableRecordImpl<AnswerRecord> implements Record4<Long, Long, Long, Boolean> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.answer.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.answer.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.answer.question</code>.
     */
    public void setQuestion(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.answer.question</code>.
     */
    public Long getQuestion() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.answer.data</code>.
     */
    public void setData(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.answer.data</code>.
     */
    public Long getData() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.answer.accepted</code>.
     */
    public void setAccepted(Boolean value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.answer.accepted</code>.
     */
    public Boolean getAccepted() {
        return (Boolean) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, Long, Boolean> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, Long, Long, Boolean> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Answer.ANSWER.ID;
    }

    @Override
    public Field<Long> field2() {
        return Answer.ANSWER.QUESTION;
    }

    @Override
    public Field<Long> field3() {
        return Answer.ANSWER.DATA;
    }

    @Override
    public Field<Boolean> field4() {
        return Answer.ANSWER.ACCEPTED;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getQuestion();
    }

    @Override
    public Long component3() {
        return getData();
    }

    @Override
    public Boolean component4() {
        return getAccepted();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getQuestion();
    }

    @Override
    public Long value3() {
        return getData();
    }

    @Override
    public Boolean value4() {
        return getAccepted();
    }

    @Override
    public AnswerRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public AnswerRecord value2(Long value) {
        setQuestion(value);
        return this;
    }

    @Override
    public AnswerRecord value3(Long value) {
        setData(value);
        return this;
    }

    @Override
    public AnswerRecord value4(Boolean value) {
        setAccepted(value);
        return this;
    }

    @Override
    public AnswerRecord values(Long value1, Long value2, Long value3, Boolean value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AnswerRecord
     */
    public AnswerRecord() {
        super(Answer.ANSWER);
    }

    /**
     * Create a detached, initialised AnswerRecord
     */
    public AnswerRecord(Long id, Long question, Long data, Boolean accepted) {
        super(Answer.ANSWER);

        setId(id);
        setQuestion(question);
        setData(data);
        setAccepted(accepted);
        resetChangedOnNotNull();
    }
}
