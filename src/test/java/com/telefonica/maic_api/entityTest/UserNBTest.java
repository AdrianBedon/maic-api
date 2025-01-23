package com.telefonica.maic_api.entityTest;

import org.junit.jupiter.api.Test;
import com.telefonica.maic_api.entity.UserNB;
import static org.junit.jupiter.api.Assertions.*;


class UserNBTest {

    @Test
    void testGetAndSetId() {
        UserNB userNB = new UserNB();
        userNB.setId(1L);
        assertEquals(1L, userNB.getId());
    }

    @Test
    void testGetAndSetNumTelefono() {
        UserNB userNB = new UserNB();
        userNB.setNumTelefono("123456789");
        assertEquals("123456789", userNB.getNumTelefono());
    }

    @Test
    void testGetAndSetProbAccion() {
        UserNB userNB = new UserNB();
        userNB.setProbAccion(0.75);
        assertEquals(0.75, userNB.getProbAccion());
    }

    @Test
    void testGetAndSetChannel() {
        UserNB userNB = new UserNB();
        userNB.setChannel("SMS");
        assertEquals("SMS", userNB.getChannel());
    }

    @Test
    void testGetAndSetAction() {
        UserNB userNB = new UserNB();
        userNB.setAction("Subscribe");
        assertEquals("Subscribe", userNB.getAction());
    }

    @Test
    void testGetAndSetUse() {
        UserNB userNB = new UserNB();
        userNB.setUse(1);
        assertEquals(1, userNB.getUse());
    }

    @Test
    void testGetAndSetOrder() {
        UserNB userNB = new UserNB();
        userNB.setOrder(2);
        assertEquals(2, userNB.getOrder());
    }

    @Test
    void testGetAndSetFeedback() {
        UserNB userNB = new UserNB();
        userNB.setFeedback(3);
        assertEquals(3, userNB.getFeedback());
    }
}