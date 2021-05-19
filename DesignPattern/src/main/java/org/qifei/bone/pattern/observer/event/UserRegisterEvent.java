package org.qifei.bone.pattern.observer.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/25 17:42
 * @Description
 */
public class UserRegisterEvent extends ApplicationEvent {
    private String personId;
    public UserRegisterEvent(Object source) {
        super(source);
    }
    public UserRegisterEvent(Object source, String personId) {
        super(source);
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }

}
