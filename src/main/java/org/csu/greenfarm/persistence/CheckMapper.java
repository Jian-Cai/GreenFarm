package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.Check;

public interface CheckMapper {
    Check getCheckById(String checkId);
    void insertCheckItem(Check check);
    void deleteCheckItem(String checkId);
}
