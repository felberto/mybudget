package ch.toubidev.backend.rest;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BaseRestController {

    @Autowired
    @Qualifier("DSLContext")
    protected DSLContext jooq;
}
